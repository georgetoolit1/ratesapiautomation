package com.bank.utils;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;

    private static PropertyReader reader = new PropertyReader();

    public static PropertyReader getInstance() {
        return reader;
    }

    private PropertyReader() {

        properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Headers getFullHeader() {

        Header payload1 = new Header("Content-Type",properties.getProperty("ContentType"));
        Header payload2 = new Header("Accept-Charset",properties.getProperty("AcceptCharset"));

        List<Header> headersList = new ArrayList<Header>();
        headersList.add(payload1);
        headersList.add(payload2);
        Headers headersTest = new Headers(headersList);

        return headersTest;
    }

    public static String getUserUrl(){
        return properties.getProperty("userEndPoint");
    }

}