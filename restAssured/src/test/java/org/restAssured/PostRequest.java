package com.automation.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.*; 	 	

public class PostRequest {
	
	
	@Test
	public void postJson() {
		
		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		 
		 JSONObject requestParams = new JSONObject();
		 
		 requestParams.put("FirstName", "xHimanshuaa"); 
		 requestParams.put("LastName", "xSharmaaaa");
		 requestParams.put("UserName", "xtestuser001xaa");
		 requestParams.put("Password", "xpassword1");
		 requestParams.put("Email",  "xaxaatest@gmail.com");

		 request.header("Content-Type","application/json");
		 request.body(requestParams.toJSONString());
		 
		 Response response = request.post ("/register");
		 System.out.println(response.getStatusLine());
		 
		 System.out.println("Response body: " + response.body().asString());
	
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 201 );
	}
	
	
	
	@Test
	public void testwithGet()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virssender"); // Cast
		requestParams.put("LastName", "Sinssgh");
		requestParams.put("UserName", "sdimplsseuser2dd2011");
		requestParams.put("Password", "passwossrd1");	
		requestParams.put("Email",  "samplsse2ee26d9@gmail.com");

		request.body(requestParams.toJSONString());
		Response response = request.get("/register");

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.body().asString());
	}

}
