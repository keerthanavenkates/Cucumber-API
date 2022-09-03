package com.google.stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.google.objectrepository.AddLocation;
import com.google.objectrepository.Location;
import com.google.resources.APIResources;
import com.google.resources.Commonutils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class GoogleSteps extends Commonutils {
	AddLocation loc;
	
	Commonutils c = new Commonutils();

@Given("I want to add payload")
public void i_want_to_add_payload() {
	
	loc = new AddLocation();
	
	Location l = new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	loc.setLocation(l);
	
	loc.setAccuracy(50);
	loc.setName("Keerthana");
	loc.setAddress("Karur");
	loc.setPhone_number("8248596819");
	
	List<String>types = new ArrayList<String>();
	types.add("Software");
	types.add("Tester");	
	loc.setTypes(types);
	
	loc.setWebsite("http://www.cgtech.com/");
	loc.setLanguage("English");
	
    
}

Response R1;
RequestSpecification request;

@When("user submit {string}")
public void user_submit(String string) throws FileNotFoundException {
	
	c.requestSpecDiff();

	 request = given().spec(requestdiffApproach).body(loc);

}

@Then("user validate the status code is {int}")	
public void user_validate_the_status_code_is(Integer int1) {
	
	ResponseSpecification newresponse = c.newresponse();
	APIResources resources = APIResources.valueOf("addPlaceapi");
	
	R1 =request.when().post(resources.getResource())
	.then().spec(newresponse).extract().response();
	
		
	int int2 = R1.getStatusCode();
	
	String s = String.valueOf(int2);
	
	Assert.assertEquals(int1.toString(),s);

}



}
