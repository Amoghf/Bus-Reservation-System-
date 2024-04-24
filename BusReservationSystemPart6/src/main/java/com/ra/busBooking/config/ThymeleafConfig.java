package com.ra.busBooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class ThymeleafConfig {
	
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver template = new ClassLoaderTemplateResolver();
		template.setPrefix("templates/");
		template.setTemplateMode("HTML5");
		template.setSuffix(".html");
		template.setTemplateMode("XHTML");
		template.setCharacterEncoding("UTF-8");
		template.setOrder(1);
		return template;
	}

}
//Design Principles Used:

//Configuration by Convention: This class provides configuration for Thymeleaf template resolver using Java-based configuration.
//SOLID Principles Violated:

//Dependency Injection: There are no dependencies to inject in this class, so it doesn't violate any SOLID principles explicitly.
//Single Responsibility Principle (SRP): The class has a single responsibility of configuring the Thymeleaf template resolver, which is good.