package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class LocalTest {
	
	@Test
	public void testGet() {
		
		baseURI = "http://localhost:3000/";
		given().get("clients").then().statusCode(200).log().all();
		
	}
	
	
	@Test
	public void testPost() {
		
		JSONObject request = new JSONObject();
		
		request.put("id", "75c23b30d971669fb42ff");
		request.put("isActive", true);
		request.put("age", 36);
		request.put("name", "Satish2 G");
		
		baseURI = "http://localhost:3000";
		
		System.out.println(request.toJSONString());
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			
		when().
			post("/clients").
		then().
			statusCode(201).
			log().all();
		
			
	}
	
	@Test
	public void put() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Satish1 G1");
		request.put("id", "7255c23b30d971669fb42ff");
		request.put("isActive", true);
		request.put("age", 40);
		
		baseURI = "http://localhost:3000/";
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("clients/7255c23b30d971669fb42ff").
		then().statusCode(200).log().all();
		
					
	}
	@Test
	public void patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("age", 45);
		
		baseURI = "http://localhost:3000/";
		
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("clients/78965c23b30d971669fb42ff").
		then().statusCode(200).log().all();
		
				
	}
	
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000/";
		given().
		when().
		delete("clients/7255c23b30d971669fb42ff").
		then().statusCode(200).
		log().all();
		
	}
	

}
