package TestFramework;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import TestFramework. Resources;
import TestFramework.ReusableMethods;
import TestFramework.Payload;;


public class basic3  
{	
	Properties prop = new Properties();
	
	@BeforeTest
	public void getData() throws IOException 
	{
		
		FileInputStream fis=new FileInputStream("C:/Users/ajinkya.bh/workspace/RestAPI/src/filess/env2.properties");
		prop.load(fis);
	}
	
	@Test
	public void AddandDeletePlaceAPI()
	{
		
		//Task 1- Grab the response  https://maps.googleapis.com
		
		//RestAssured.baseURI="https://maps.googleapis.com";
		RestAssured.baseURI= prop.getProperty("HOST");     
		Response res=given().         
		queryParam("key",prop.getProperty("KEY")).
		body(Payload.getpostdata()).
		when().
		post(Resources.placepostdata()). //add
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		extract().response();
		
		
		//Task 2 - Grab the place id from response
		String responseString = res.asString();
		System.out.println(responseString);
		
		//Now convert string into JSON (As above data is stored as string format)
		JsonPath x =ReusableMethods.rawtojson(res);
		String placeID = x.get("place_id");
		System.out.println(placeID);
		
		//Task 3 place this place id in the delete request
		
		given().
		queryParam("key","AIzaSyCqyL3y3akSd7i5UhARLAONkAYRcEdn_U4").
		//Manipulate hardcoded string placeID used above 
		body("{"+
  "\"place_id\": \""+placeID+"\""+
"}").
		when().
		post("/maps/api/place/delete/json").  //delete 
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));
		
		
	}

}
