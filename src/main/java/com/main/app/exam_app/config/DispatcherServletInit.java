package com.main.app.exam_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.main.app.exam_app")
public class DispatcherServletInit implements  WebMvcConfigurer {

	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver view_resolver = new InternalResourceViewResolver();
		view_resolver.setPrefix("WEB-INF/view/");
		view_resolver.setSuffix(".jsp");
		return view_resolver;
		
	}

}
