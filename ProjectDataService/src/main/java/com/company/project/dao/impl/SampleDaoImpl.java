package com.company.project.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.project.dao.ISampleDao;

@Repository
public class SampleDaoImpl implements ISampleDao
{

	public static final Logger LOG = LoggerFactory.getLogger(SampleDaoImpl.class);
	
	@Autowired
	@Qualifier("master")
	JdbcTemplate master;
	
	@Override
	public Integer sampleDBCall()
	{
		LOG.debug("DB Call to be made");
		String query = "select 10";
		return master.queryForObject(query, Integer.class);
	}

}
