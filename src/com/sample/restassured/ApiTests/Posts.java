package com.sample.restassured.ApiTests;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;

public class Posts extends Base{
	
	@Test
	public void testPostCount() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect().body("size()", equalTo(100)).when().get("/posts");
	}
	
	@Test
	public void testPostsContainSpecificContent() throws JSONException {
		
        given()
        .contentType(ContentType.JSON)
        .expect()
        .body("id[99]", equalTo(100))
        .body("body[99]", containsString("cupiditate quo est")).when().get("/posts");
	}
	
	@Test
	public void postsAddedSuccessfully() throws JSONException {
		
		String title = "Hello";
		 String body = "I just wanted to say hello";
		String userId = "s1df1aksjbf2as";
		
		Map<String,String> token = new HashMap<>();
        
		token.put("title", title);       
		token.put("body", body);        
		token.put("userId", userId);

        given()
        .contentType(ContentType.JSON)
        .body(token)
        .when().post("/posts").then()        
        .body("title", equalTo(title))
        .body("body", equalTo(body))
        .body("userId", equalTo(userId))
        .body("id", notNullValue());

	}
	
	@Test
	public void postsUpdatedSuccessfully() throws JSONException {
		
		String newTitle = "Hello";
		String id = "1";
		
		String oldTitle = given().when().get("/posts/"+id).then().extract().path("title");
		
		Map<String,String> token = new HashMap<>();
        
		token.put("title", newTitle);  
		token.put("userId", id);

        given()
        .contentType(ContentType.JSON)
        .body(token)
        .when().put("/posts/"+id).then()  
        //.log().body()
        .statusCode(200)  
        .body("title", equalTo(newTitle))
        .body("title", not(equalTo(oldTitle)));

	}
	
	@Test
	public void postsCanBeDeletedSuccessfully() throws JSONException {
		
		String id = "1";
		
		Map<String,String> token = new HashMap<>();

        given()
        .contentType(ContentType.JSON)
        .body(token)
        .when().delete("/posts/"+id).then()  
        .statusCode(200); 

	}

}
