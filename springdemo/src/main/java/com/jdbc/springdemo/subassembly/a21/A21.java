package com.jdbc.springdemo.subassembly.a21;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockPart;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExpressionValueMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestHeaderMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class A21 {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
        // 准备测试 Request
        HttpServletRequest request = mockRequest();

        // 要点1. 控制器方法被封装为 HandlerMethod
        HandlerMethod handlerMethod = new HandlerMethod(new Controller(), Controller.class.getMethod("test",
                String.class, String.class, int.class, String.class, MultipartFile.class, int.class, String.class, String.class, String.class, HttpServletRequest.class, User.class, User.class, User.class));

        // 要点2. 准备对象绑定与类型转换
        ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(null, null);

        // 要点3. 准备 ModelAndViewContainer 用来存储中间 Model 结果
        ModelAndViewContainer container = new ModelAndViewContainer();

        // 要点4. 解析每个参数值
        for (MethodParameter parameter : handlerMethod.getMethodParameters()) {
            // 多个解析器组合
            HandlerMethodArgumentResolverComposite composite = new HandlerMethodArgumentResolverComposite();
            List<HttpMessageConverter<?>> converters = new ArrayList<>();
            converters.add(new MappingJackson2HttpMessageConverter());
            composite.addResolvers(
                    //                                          false 表示必须有 @RequestParam
                    new RequestParamMethodArgumentResolver(beanFactory, false),
                    new PathVariableMethodArgumentResolver(),
                    new RequestHeaderMethodArgumentResolver(beanFactory),
                    new ServletCookieValueMethodArgumentResolver(beanFactory),
                    new ExpressionValueMethodArgumentResolver(beanFactory),
                    new ServletRequestMethodArgumentResolver(),
                    new ServletModelAttributeMethodProcessor(false), // 必须有 @ModelAttribute
                    new RequestResponseBodyMethodProcessor(converters),
                    new ServletModelAttributeMethodProcessor(true), // 省略了 @ModelAttribute
                    new RequestParamMethodArgumentResolver(beanFactory, true) // 省略 @RequestParam
            );

            String annotations = Arrays.stream(parameter.getParameterAnnotations()).map(a -> a.annotationType().getSimpleName()).collect(Collectors.joining());
            String str = annotations.length() > 0 ? " @" + annotations + " " : " ";
            parameter.initParameterNameDiscovery(new DefaultParameterNameDiscoverer());

            if (composite.supportsParameter(parameter)) {
                // 支持此参数
                Object v = composite.resolveArgument(parameter, container, new ServletWebRequest(request), factory);
//                System.out.println(v.getClass());
                System.out.println("[" + parameter.getParameterIndex() + "] " + str + parameter.getParameterType().getSimpleName() + " " + parameter.getParameterName() + "->" + v);
                System.out.println("模型数据为：" + container.getModel());
            } else {
                System.out.println("[" + parameter.getParameterIndex() + "] " + str + parameter.getParameterType().getSimpleName() + " " + parameter.getParameterName());
            }
        }

        /*
            学到了什么
                a. 每个参数处理器能干啥
                    1) 看是否支持某种参数
                    2) 获取参数的值
                b. 组合模式在 Spring 中的体现
                c. @RequestParam, @CookieValue 等注解中的参数名、默认值, 都可以写成活的, 即从 ${ } #{ }中获取
         */
//        SimpleTypeConverter simpleTypeConverter = new SimpleTypeConverter();
//        simpleTypeConverter.convertIfNecessary()
//        BeanWrapperImpl beanWrapper = new BeanWrapperImpl();
//        beanWrapper.setPropertyValue("a","10");
//        DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor();
//        ServletRequestParameterPropertyValues values = new ServletRequestParameterPropertyValues();
//        DefaultFormattingConversionService service = new DefaultFormattingConversionService();
        
    }

    private static HttpServletRequest mockRequest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("name1", "zhangsan");
        request.setParameter("name2", "lisi");
        request.addPart(new MockPart("file", "abc", "hello".getBytes(StandardCharsets.UTF_8)));
        Map<String, String> map = new AntPathMatcher().extractUriTemplateVariables("/test/{id}", "/test/123");
        System.out.println(map);
        request.setAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, map);
        request.setContentType("application/json");
        request.setCookies(new Cookie("token", "123456"));
        request.setParameter("name", "张三");
        request.setParameter("age", "18");
        request.setContent("{\"name\":\"李四\",\"age\":20}".getBytes(StandardCharsets.UTF_8));
        return new StandardServletMultipartResolver().resolveMultipart(request);
    }


    static class Controller {
        public void test(
                @RequestParam("name1") String name1, // name1=张三
                String name2,                        // name2=李四
                @RequestParam("age") int age,        // age=18
                @RequestParam(name = "home", defaultValue = "${JAVA_HOME}") String home1, // spring 获取数据
                @RequestParam("file") MultipartFile file, // 上传文件
                @PathVariable("id") int id,               //  /test/124   /test/{id}
                @RequestHeader("Content-Type") String header,
                @CookieValue("token") String token,
                @Value("${JAVA_HOME}") String home2, // spring 获取数据  ${} #{}
                HttpServletRequest request,          // request, response, session ...
                @ModelAttribute("abc") User user1,          // name=zhang&age=18
                User user2,                          // name=zhang&age=18
                @RequestBody User user3              // json
        ) {
        }
    }

    static class User {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
