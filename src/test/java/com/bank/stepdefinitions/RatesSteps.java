package com.bank.stepdefinitions;

import com.bank.utils.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class RatesSteps {
    private RequestSpecification request;
    private Response response;



    @Given("^I use customer header$")
    public void useCustomHeader() throws Throwable {
        request = given().headers(PropertyReader.getFullHeader()).log().headers();
    }

    @When("^I create get request to get the latest rates for all symbols$")
    public void i_create_get_request_to_get_the_latest_rates_for_all_symbols() throws Throwable {
        String apiPath = PropertyReader.getUserUrl();
        response = request.when()
                .get(apiPath);
    }

    @Then("^I get status code (\\d+) from database$")
    public void i_get_status_code_from_database(int arg1) throws Throwable {
        response.then().statusCode(arg1).log().all();

    }
}