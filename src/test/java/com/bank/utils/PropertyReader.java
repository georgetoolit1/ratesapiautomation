package com.bank.utils;

import com.bank.main.CucumberRunner;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertyReader {
    private static Logger logger = LoggerFactory.getLogger(PropertyReader.class);
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
        logger.info("Getting headers");
        Header payload1 = new Header("Content-Type",properties.getProperty("ContentType"));
        Header payload2 = new Header("Accept-Charset",properties.getProperty("AcceptCharset"));

        List<Header> headersList = new ArrayList<Header>();
        headersList.add(payload1);
        headersList.add(payload2);
        Headers headersTest = new Headers(headersList);

        return headersTest;
    }


    public static String getLatesrUrl(){
        return properties.getProperty("latestEndPoint");
    }

    public static String getbaseURL() { return  properties.getProperty("baseUrl");}

}