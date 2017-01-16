package com.company.project.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.company.project")
@SpringBootApplication
public class ApplicationConfig extends SpringBootServletInitializer
{
	public static void main(String[] args)
	{
		new ApplicationConfig().configure(new SpringApplicationBuilder(ApplicationConfig.class)).run(args);
	}

}
