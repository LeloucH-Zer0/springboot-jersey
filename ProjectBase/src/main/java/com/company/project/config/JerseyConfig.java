package com.company.project.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig
{
	public JerseyConfig()
	{
		// TODO Auto-generated constructor stub
		this.packages("com.company.project.controllers");
	}
	
}
