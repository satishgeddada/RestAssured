package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test2 {

	
	//@Test 
	public void test_2() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		int x = response.getStatusCode();
		
		Assert.assertEquals(x, 200);
		
	}
	
}
