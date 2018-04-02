package TestFramework;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestFramework.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Basic6 
{
	Properties prop = new Properties();
	@BeforeTest
	public void getData() throws IOException 
	{
		
		FileInputStream fis=new FileInputStream("C:/Users/ajinkya.bh/workspace/RestAPI/src/filess/env2.properties");
		prop.load(fis);
	}
	
	@Test
	public void JiraAPICreateIssue() 
	{
		RestAssured.baseURI= "http://localhost:8100"; 
		Response res = given().header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getsessionkey()).
		body("{"+
 "\"fields\": {"+
        "\"project\": {"+
            "\"key\": \"REST\""+
        "},"+
        "\"summary\": \"Finance card issue\","+
        "\"description\": \"Creating first Issue\","+
        "\"issuetype\": {"+
            "\"name\": \"Task\""+
        "}"+
 "}}").when().post("/rest/api/2/issue").then().statusCode(201).extract().response();
		
		JsonPath x = ReusableMethods.rawtojson(res);
		String id= x.get("id");
		System.out.println(id);
		
	}
}
