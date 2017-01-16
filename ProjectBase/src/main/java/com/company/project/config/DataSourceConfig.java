package com.company.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("classpath:/db.properties")
public class DataSourceConfig
{
	@Value("${master.datasource.url}")
	String masterUrl;

	@Value("${master.datasource.password}")
	String masterPassword;

	@Value("${master.datasource.username}")
	String masterUsername;

	@Value("${master.datasource.driver-class-name}")
	String masterDriverClassName;

	@Bean(name = "datasource")
	public DataSource initializeDataSource()
	{
		BoneCPDataSource ds = new BoneCPDataSource();
		ds.setUsername(masterUsername);
		ds.setPassword(masterPassword);
		ds.setDriverClass(masterDriverClassName);
		ds.setJdbcUrl(masterUrl);
		return ds;
	}

	@Bean(name = "master")
	public JdbcTemplate initializeJdbcTemplate(@Qualifier("datasource") DataSource ds)
	{
		JdbcTemplate master = new JdbcTemplate();
		master.setDataSource(ds);
		return master;
	}

}
