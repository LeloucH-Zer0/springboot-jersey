package com.company.project.controllers.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.project.config.ApplicationConfig;
import com.company.project.model.ErrorClass;
import com.company.project.model.SampleClass;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes=ApplicationConfig.class)
public class SampleControllerTest
{

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testFailure()
	{
		ErrorClass error = new ErrorClass();
		error.setErrorCode(501);
		error.setMessage("This API hasn't been implemented yet. Hence returning with a failure code!");
		ResponseEntity<ErrorClass> apiValue=this.restTemplate.getForEntity("/sample/failure", ErrorClass.class);
		assertThat(apiValue.getBody()).isEqualTo(error);
		assertThat(apiValue.getStatusCode()).isEqualTo(HttpStatus.NOT_IMPLEMENTED);
		assertThat(apiValue.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
	}
	
	@Test
	public void testSuccess()
	{
		SampleClass success = new SampleClass();
		success.setData(10);
		ResponseEntity<SampleClass> apiValue=this.restTemplate.getForEntity("/sample/success", SampleClass.class);
		assertThat(apiValue.getBody()).isEqualTo(success);
		assertThat(apiValue.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(apiValue.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
	}

}
