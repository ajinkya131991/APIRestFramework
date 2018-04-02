package TestFramework;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import TestFramework.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Basic7 
{
	@Test
	public void JiraAPICreateComment()
	{
		RestAssured.baseURI= "http://localhost:8100"; 
		Response res = given().header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getsessionkey()).
		body("{\"body\": \"Will be commented by MEEEEEEEEEEEEEEEEEEE\","+
    "\"visibility\": {"+
        "\"type\": \"role\","+
        "\"value\": \"Administrators\"}"+
	"}").when().post("/rest/api/2/issue/10029/comment").then().statusCode(201).extract().response();
		
		JsonPath x = ReusableMethods.rawtojson(res);
		String id= x.get("id");
		System.out.println(id);
		
				
	}

}
