package com.mikeldi.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mikeldi.demo.component.RequestInterceptor;


@Configuration
public class ConfiguracionWebMVC implements WebMvcConfigurer {
	
	@Autowired
	@Qualifier("requestTimeInterceptor")
	RequestInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(interceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	

}
