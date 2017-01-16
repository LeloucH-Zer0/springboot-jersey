package com.company.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.project.dao.ISampleDao;

@Repository
public class SampleDaoImpl implements ISampleDao
{

	@Autowired
	@Qualifier("master")
	JdbcTemplate master;
	
	@Override
	public Integer sampleDBCall()
	{
		String query = "select 10";
		return master.queryForObject(query, Integer.class);
	}

}
