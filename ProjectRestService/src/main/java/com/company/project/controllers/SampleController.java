package com.company.project.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.dao.ISampleDao;
import com.company.project.model.ErrorClass;
import com.company.project.model.SampleClass;

@Path("/sample")
public class SampleController
{
	public static final Logger LOG = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	ISampleDao dao;
	
	@GET
	@Path("/success")
	@Produces(MediaType.APPLICATION_JSON)
	public Response success()
	{
		LOG.info("Call for Success!");
		SampleClass sample = new SampleClass();
		sample.setData(dao.sampleDBCall());
		return Response.status(Status.OK).entity(sample).build();
	}

	@GET
	@Path("/failure")
	@Produces(MediaType.APPLICATION_JSON)
	public Response failure()
	{
		LOG.info("Call for Failure!");
		ErrorClass error = new ErrorClass();
		error.setErrorCode(501);
		error.setMessage("This API hasn't been implemented yet. Hence returning with a failure code!");
		return Response.status(Status.NOT_IMPLEMENTED).entity(error).build();
	}
}
