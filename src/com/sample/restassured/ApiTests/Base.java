package com.sample.restassured.ApiTests;

import org.testng.annotations.BeforeClass;

import com.jayway.restassured.RestAssured;

public class Base {
	
	@BeforeClass
    public static void setup() {     

        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";

    }	
	
}