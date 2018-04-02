package TestFramework;
/*package apiPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;



public class Basic9 
{
	String ConsumerKey="Sj9dztHaXnaeIeNv1G0FPPTP1";
	String ConsumerSecret ="cXi9mZSHUoNHqbA07CpJITev65aUl5hGtUCXeDQ1HH0qeSqHKI";
	String Token ="940541348398096385-rJMx44ZbaohlCGxb5poOoPdqnSBso3K";
	String TokenSecret="pkD9cdqYam0a57MQSXpRmdXQtRdkorePWYhpUYgV92vjd";
	
	@Test
	public void getLatestTweet()
	{		
		
		//Extra jars need to be downloaded  scribejava-core and scribejava-apis
 		
		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
		
		
		
        Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
		queryParam("count", 1).
		when().get("/home_timeline.json").then().extract().response();
        
        String response = res.asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String tweet = js.get("text");
        System.out.println(tweet);
        
        //System.out.println(js.get());
		
	}

}
*/