package com.sample.restassured.ApiTests;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONException;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;

public class Photos extends Base{
	@Test
	public void testPhotosCount() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("size()", equalTo(5000)).when().get("/photos");
	}
	
	@Test
	public void testPhotsContainSpecificContent() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect()
        .body("url[0]", equalTo("http://placehold.it/600/92c952"))
        .body("url[4999]", equalTo("http://placehold.it/600/6dd9cb")).when().get("/photos");
	}

}
