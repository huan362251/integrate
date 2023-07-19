package com.jdbc.springdemo.subassembly.a20;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */
public class YmlReturnValueResolver implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        Yml methodAnnotation = returnType.getMethodAnnotation(Yml.class);
        return methodAnnotation != null;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        //转换返回结果字符串
        String dump = new Yaml().dump(returnValue);
        //将yaml字符串写入响应
        HttpServletResponse nativeResponse = webRequest.getNativeResponse(HttpServletResponse.class);
        nativeResponse.setContentType("text/plain;charset=utf-8");
        nativeResponse.getWriter().print(dump);
        //告诉mvc已经处理完成
        mavContainer.setRequestHandled(true);
    }

}
