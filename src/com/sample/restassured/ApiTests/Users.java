package com.sample.restassured.ApiTests;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONException;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;

public class Users extends Base{
	@Test
	public void testUsersCount() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("size()", equalTo(10)).when().get("/users");
	}

}
