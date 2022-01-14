package com.trabeya.core_bank.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
//*
//Author: Harilojunan.N
//Date	: 13/January/2022
//*
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    // Servlet Registration Bean
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messaageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet,"/core_bank/accounts/*");
    }

    @Bean
    public XsdSchema accountSchema(){
        return new SimpleXsdSchema(new ClassPathResource("accounts.xsd"));
    }

    //  Bean Initialization
    @Bean(name="bank_accounts")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema accountSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(accountSchema);
        definition.setLocationUri("/core_bank/accounts");
        definition.setPortTypeName("AccountServicePort");
        definition.setTargetNamespace("http://www.trabeya.com/core_bank/accounts");
        return definition;
    }
}
