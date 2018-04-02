package TestFramework;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class Basic1 {

	@Test
	public void Test1()
	{
		
		//BaseURL or Host
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Parameters and resources should be provided. 
		given().
			param("location","-33.8670522,151.1957362").
			param("radius","500").
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
			header("Server","pablo");
				

	}

}
