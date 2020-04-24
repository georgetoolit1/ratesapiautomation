package com.bank.utils;

import io.restassured.response.Response;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ResponseHelper {
    //assert the value of the response returned
    public static void responseValidations(Response response, List<String> responseElements){
        for (String check:responseElements
        ) {
            Assert.assertNotNull(response.then().extract().path(check));
        }
    }

    //assert individual item in the response
    public static void pathValidations(Response response, String actualPath){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        actualPath = response.then().extract().path("date");
        Assert.assertEquals("objects do not match",actualPath,currentDate);
    }
}
