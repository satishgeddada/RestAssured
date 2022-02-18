package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class GetandPost {
	//@Test
	public void TestGet() {
		
		baseURI = "https://reqres.in/api/";
		
		given().
			get("users?page=2").
		then().
			statusCode(200).
			body("data[4].avatar", equalTo("https://reqres.in/img/faces/11-image.jpg")).
			body("data.last_name", hasItems("Ferguson","Funke","Fields"));


	}
	
	@Test
	public void TestPost() {

//		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		request.put("name", "morpheus");
		request.put("job", "leader");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	
		
		
	
	}


}
