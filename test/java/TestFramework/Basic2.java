package TestFramework;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
public class Basic2 
{
	
	@Test
	public void postData()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
		//add forword slash '\' before quotes ""  ------- Also for new as param are present in new lines then they should be present between  " and "+ 
		queryParam("key","AIzaSyCqyL3y3akSd7i5UhARLAONkAYRcEdn_U4").
		body("{"+
				  "\"location\": {"+
				    "\"lat\": -33.8669710,"+
				    "\"lng\": 151.1958750"+
				  "},"+
				  "\"accuracy\": 50,"+
				  "\"name\": \"Google Shoes!\","+
				  "\"phone_number\": \"(02) 9374 4000\","+
				  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
				  "\"types\": [\"shoe_store\"],"+
				  "\"website\": \"http://www.google.com.au/\","+
				  "\"language\": \"en-AU\""+
				"}").
		when().
		post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));
		
		// Create a place  = Response Place_id
		// And delete that = Request Place ID
		
		
	}

}
