package com.bank.stepdefinitions;

import com.bank.utils.PropertyReader;

import com.bank.utils.ResponseHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RatesSteps {
    private RequestSpecification request;
    private Response response;

    @Given("I use rate header")
    public void i_use_rate_header() {
        request = given().headers(PropertyReader.getFullHeader()).log().headers();
    }

    @When("I create get request to get the latest rates for all symbols")
    public void i_create_get_request_to_get_the_latest_rates_for_all_symbols() {
        String apiPath = PropertyReader.getLatesrUrl();
        response = request.when().get(apiPath);
    }

    @Then("I get status code {int} from database")
    public void i_get_status_code_from_database(Integer int1) {
        response.then().statusCode(int1).log().all();
    }

    @Then("The rates response body should contain")
    public void the_rates_response_body_should_contain(List<String> responseMap) {
     ResponseHelper.responseValidations(response, responseMap);
    }

    @When("I create get request to get the latest rates using an incomplete url")
    public void i_create_get_request_to_get_the_latest_rates_using_an_invalid_url() {
        String apiPath = PropertyReader.getbaseURL();
        response = request.when().get(apiPath);
    }

    @When("I create get request to get the latest rates for all symbols for {string}  date")
    public void i_create_get_request_to_get_the_latest_rates_for_all_symbols_for_date(String string) {
        String apiPath = PropertyReader.getbaseURL() + string;
        response = request.when().get(apiPath);
    }

    @Then("The response body should contain current date")
    public void responseBodyShouldContainCurrentDate(String date) {
        ResponseHelper.pathValidations(response, date);
    }
}