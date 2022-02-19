package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {

	
	
	public class GetandPost {
		@Test
		public void TestGet() {
			
			baseURI = "https://reqres.in/api/";
			
			given().
				get("users?page=2").
			then().
				statusCode(200).
				body("data[4].avatar", equalTo("https://reqres.in/img/faces/11-image.jpg")).
				body("data.last_name", hasItems("Ferguson","Funke","Fields")).log().all();


		}
		
}
}