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
    public void useRateHeader() {
        request = given().headers(PropertyReader.getFullHeader()).log().headers();
    }

    @When("I create get request to get the latest rates for all symbols")
    public void createGetRequestToGetTheLatestRatesForAllSymbols() {
        String apiPath = PropertyReader.getLatesrUrl();
        response = request.when().get(apiPath);
    }

    @Then("I get status code {int} from database")
    public void getStatuscodeFromDatabase(Integer int1) {
        response.then().statusCode(int1).log().all();
    }

    @Then("The rates response body should contain")
    public void ratesResponseBodyShouldContain(List<String> responseMap) {
     ResponseHelper.responseValidations(response, responseMap);
    }

    @When("I create get request to get the latest rates using an incomplete url")
    public void createGetRequestToGetTheLatestatesUsingInvalidUrl() {
        String apiPath = PropertyReader.getbaseURL();
        response = request.when().get(apiPath);
    }

    @When("I create get request to get the latest rates for all symbols for {string}  date")
    public void createGetRequestToGetLatestRatesAllSymbolsForDate(String string) {
        String apiPath = PropertyReader.getbaseURL() + string;
        response = request.when().get(apiPath);
    }

    @Then("The response body should contain current date")
    public void responseBodyShouldContainCurrentDate(String date) {
        ResponseHelper.pathValidations(response, date);
    }
}