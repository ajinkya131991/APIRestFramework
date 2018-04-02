package TestFramework;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import TestFramework.ReusableMethods;
import io.restassured.RestAssured;



public class Basic8 
{
	@Test
	public void JiraAPIUpdate()
	{
		RestAssured.baseURI= "http://localhost:8100"; 
		given().header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getsessionkey()).
		pathParams("commentid","10024").
		
		body("{\"body\": \"Yes Only by MEEEEEEEEEEEEE\","+
    "\"visibility\": {"+
        "\"type\": \"role\","+
        "\"value\": \"Administrators\"}"+
	"}").when().put("/rest/api/2/issue/10029/comment/{commentid}").then().statusCode(200).extract().response();
		
		
		
				
	}

}
