package TestFramework;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import TestFramework.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Basic4 
{
	// For XML
		@Test
		public void postDataXML() throws IOException
		{
			String postdata=GenerateStringFromResource("C:\\Users\\ajinkya.bh\\Documents\\postdata.xml");
			
			RestAssured.baseURI="https://maps.googleapis.com";		
			Response resp=given().
			
			queryParam("key","AIzaSyCqyL3y3akSd7i5UhARLAONkAYRcEdn_U4").
			body(postdata).
			when().
			post("/maps/api/place/add/xml").
			then().assertThat().statusCode(200).and().contentType(ContentType.XML).
			extract().response();
			
			XmlPath x =ReusableMethods.rawtoxml(resp);
			String y = x.get("PlaceAddResponse.place_id");
			System.out.println(y);
		}
		
		public static String GenerateStringFromResource(String path) throws IOException
		{
				return new String(Files.readAllBytes(Paths.get(path)));
		}


}
