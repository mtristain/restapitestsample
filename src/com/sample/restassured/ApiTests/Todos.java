package com.sample.restassured.ApiTests;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONException;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;

public class Todos extends Base{

	@Test
	public void testTodosCount() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("size()", equalTo(200)).when().get("/todos");
	}
}
