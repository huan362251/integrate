package com.jdbc.springdemo.subassembly.a05;

import com.alibaba.druid.pool.DruidDataSource;
import com.jdbc.springdemo.subassembly.a05.component.Bean2;
import com.jdbc.springdemo.subassembly.a05.mapper.Mapper1;
import com.jdbc.springdemo.subassembly.a05.mapper.Mapper2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@ComponentScan("com.jdbc.springdemo.subassembly.a05.component")
public class Config {

    @Bean
    public Bean2 bean1() {
        return new Bean2();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }

    @Bean(initMethod = "init")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.56.10:3306/mybatis_plus");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

//    @Bean
//    public MapperFactoryBean<Mapper1> mapper1(SqlSessionFactory sqlSessionFactory) {
//        //mapper工厂，用来创建mapper接口
//        MapperFactoryBean<Mapper1> mapper1MapperFactoryBean = new MapperFactoryBean<>(Mapper1.class);
//        //因为要进行数据库操作，关联连接
//        mapper1MapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//        return mapper1MapperFactoryBean;
//    }
//
//    @Bean
//    public MapperFactoryBean<Mapper2> mapper2(SqlSessionFactory sqlSessionFactory) {
//        MapperFactoryBean<Mapper2> mapper1MapperFactoryBean = new MapperFactoryBean<>(Mapper2.class);
//        mapper1MapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//        return mapper1MapperFactoryBean;
//    }
}
