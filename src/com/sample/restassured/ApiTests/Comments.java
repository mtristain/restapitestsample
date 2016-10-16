package com.sample.restassured.ApiTests;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONException;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;

public class Comments extends Base{
	
	@Test
	public void testCommentsCount() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("size()", equalTo(500)).when().get("/comments");
	}
	
	@Test
	public void testCommentsContainSpecificContent() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("email[3]", equalTo("Lew@alysha.tv")).when().get("/comments");
	}

}
