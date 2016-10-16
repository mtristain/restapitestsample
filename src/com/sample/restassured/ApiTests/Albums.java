package com.sample.restassured.ApiTests;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONException;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;

public class Albums extends Base{
	
	@Test
	public void testAlbumsCount() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("size()", equalTo(100)).when().get("/albums");
	}
	
	@Test
	public void testAlbumsContainSpecificContent() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("title[3]", equalTo("non esse culpa molestiae omnis sed optio")).when().get("/albums");
	}
	
	@Test
	public void testAlbumsDoesNotContainSpecificContent() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("title[0]", not(equalTo("non esse culpa molestiae omnis sed optio"))).when().get("/albums");
	}

}
