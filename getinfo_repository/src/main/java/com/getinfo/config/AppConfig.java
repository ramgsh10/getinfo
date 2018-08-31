package com.getinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class AppConfig 
{
	 @Bean
	 public InternalResourceViewResolver resolver() 
	 {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setViewClass(JstlView.class);
	      resolver.setPrefix("/WEB-INF/views/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	  }
	/* @Bean
	 public void addResourceHandlers(ResourceHandlerRegistry registry) 
	 {
		 registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/");
		 registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
   }*/
}
