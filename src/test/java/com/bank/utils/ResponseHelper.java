package com.bank.utils;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class ResponseHelper {

    //assert the value of the response returned
    public static void responseValidations(Response response, List<String> responseElements){
        for (String check:responseElements
        ) {
            Assert.assertNotNull(response.then().extract().path(check));
        }
    }
}

