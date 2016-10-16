package com.sample.restassured.ApiTests;

import org.json.JSONException;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.RestAssured.given;

public class ResponseCodes extends Base{
	
	@Test
	public void testResponseCodeGettingComments() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .when().get("/comments").then()
        .statusCode(200);  
	}
	@Test
	public void testResponseCodeGettingPosts() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .when().get("/posts").then()
        .statusCode(200);  
	}
	
	@Test
	public void testResponseCodeGettingAlbums() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .when().get("/albums").then()
        .statusCode(200);  
	}
	
	@Test
	public void testResponseCodeGettingPhotos() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .when().get("/photos").then()
        .statusCode(200);  
	}
	
	@Test
	public void testResponseCodeGettingTodos() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .when().get("/todos").then()
        .statusCode(200);  
	}
	
	@Test
	public void testResponseCodeGettingUsers() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .when().get("/users").then()
        .statusCode(200);  
	}
	
	

	
}