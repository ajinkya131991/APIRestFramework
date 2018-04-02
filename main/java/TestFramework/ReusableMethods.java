package TestFramework;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods 
{
	public static XmlPath rawtoxml(Response r)
	{
		String respon=r.asString();
		System.out.println(respon); 
		//Now convert string into XML (As above data is stored as string format)
		XmlPath x=new XmlPath(respon);
		return x;
	}
	
	public static JsonPath rawtojson(Response r)
	{
		String respon=r.asString();
		System.out.println(respon); 
		//Now convert string into XML (As above data is stored as string format)
		JsonPath x= new JsonPath(respon);
		return x;
	}

	public static String getsessionkey()
	{
		RestAssured.baseURI= "http://localhost:8100"; 
		Response res =given().header("Content-Type","application/json").
		body("{ \"username\": \"ajinkyabhobad.t\", \"password\": \"@jinkyA99\" }").
		when().
		post("/rest/auth/1/session").
		then().statusCode(200).
		extract().response();
		
		JsonPath x = ReusableMethods.rawtojson(res);
		String session = x.get("session.value");
		System.out.println(session);
		return session;
	}
}
