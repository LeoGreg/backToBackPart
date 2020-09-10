package com.example.demo3.configs.hessian;

import com.example.demo3.service.hessianService.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class HessianConfig {

    @Bean
    public BookService commentService() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8080/interconnect/bookService");
        invoker.setServiceInterface(BookService.class);
        invoker.setHessian2(true);
        invoker.setUsername("interconnect_user");
        invoker.setPassword("interconnect_password");
        invoker.afterPropertiesSet();
        return (BookService) invoker.getObject();
    }
}
