package org.restAssured.deserialize;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserializeDemo {

	@Test
	public void testRegistrationSuccessfull() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "1xestestname"); // Cast
		requestParams.put("LastName", "1xtesesstlastname");
		requestParams.put("UserName", "1xtesestusername");
		requestParams.put("Password", "1xteestspassword");
		requestParams.put("Email", "1xtestuenasme@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

//		System.out.println(response.jsonPath().get("SuccessCode"));
		System.out.println("status line: " + response.getStatusLine());
		System.out.println(response.getBody().asString());

		System.out.println("++++++++++++++++++++++++++++++++++++++");

		 ResponseBody body = response.getBody();

		if (response.getStatusCode() == 201) {
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);

			System.out.println("class success code : " + responseBody.SuccessCode);
			System.out.println("class message : " + responseBody.Message);
		} else {
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);

			System.out.println("class success code : " + responseBody.FaultId);
			System.out.println("class message : " + responseBody.fault);
		}

	}

}
