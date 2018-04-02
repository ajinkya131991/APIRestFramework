package TestFramework;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import org.testng.annotations.Test;

import TestFramework.ReusableMethods;

public class Basic5 {

	@Test
	public void ExtarctingNamesAPI()
	{
		
		//BaseURL or Host
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Parameters and resources should be provided. 
		Response res=given().
			param("location","-33.8670522,151.1957362").   //Request
			param("radius","500").                          //Request
			param("key","AIzaSyCqyL3y3akSd7i5UhARLAONkAYRcEdn_U4").log().all().
			/*header("value","").
			cookie("","").
			body(args);*/
			when().
			get("/maps/api/place/nearbysearch/json").
			then().
			assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).
			body("results[1].name",equalTo("Astral Tower & Residences - The Star")).and().
			header("Server","pablo").log().body().
			extract().response();  // will give response
		
		// x has json objects and arrays
		JsonPath x = ReusableMethods.rawtojson(res);
		
		int count = x.getInt("results.size()");

		for(int i=0;i<count;i++)
		{
			String name = x.get("results["+i+"].name");
			System.out.println(name);
		}
		
			

			
		
		
	}

	


}
