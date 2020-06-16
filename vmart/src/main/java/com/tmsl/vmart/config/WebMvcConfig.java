package com.tmsl.vmart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages ={"com.tmsl.vmart"})
@EnableWebMvc
@Controller

public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver()
	{
		InternalResourceViewResolver ivr=new InternalResourceViewResolver();
		ivr.setSuffix(".jsp");
		return ivr;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}
	
	

}
