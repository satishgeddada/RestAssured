package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PutPatchDelete {

	@Test
	public void TestPut() {
	
	JSONObject request = new JSONObject();
	request.put( "name", "morpheus");
	request.put("job", "zion resident");
	
	baseURI = "https://reqres.in/api";
	
	given().
	body(request.toJSONString()).
	when().
	put("/users/2").
	then().
	statusCode(200).
	log().all();
	
	}
	
	
	@Test
	public void TestPatch() {
	
	JSONObject request = new JSONObject();
	request.put( "name", "morpheus");
	request.put("job", "zion resident");
	
	baseURI = "https://reqres.in/api";
	
	given().
	body(request.toJSONString()).
	when().
	patch("/users/2").
	then().
	statusCode(200).
	log().all();
	
	}
	
	@Test
	public void TestDelete() {

		baseURI = "https://reqres.in/api";
		when().
		delete("/users/2").
		then().
		statusCode(204).
		log().all();

	}
	
}
