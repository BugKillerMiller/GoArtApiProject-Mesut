package goart.services;

import goart.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
/**
 * This abstract class is similar to Base Class of UI Page Object Modal and
 * includes methods template for different endpoints and HTTP requests
 */
public abstract class BaseService {

    /**
     * Retrieves mockUrl from configuration.properties file and provide relaxes HTTP validation
     */
    protected static RequestSpecification requestSpecification(){
        RestAssured.baseURI = ConfigurationReader.get("mockUrl");
        return given()
                .config(RestAssuredConfig.newConfig().sslConfig(new SSLConfig().relaxedHTTPSValidation()));
    }
    /**
     * Template for GET request. More methods could be created based on needs
     * (ie. request_with_body or request_with_authentication)
     */
    protected static RequestSpecification getRequest(){
        return requestSpecification()
                .accept(ContentType.JSON);
    }
    /**
     * This method provides single parameter to request
     */
    protected static RequestSpecification assignQueryParamForGetRequest(final String key,final Object value){
        return getRequest()
                .queryParam(key,value);
    }
    /**
     * This method provides multiple query parameters to request
     */
    protected static RequestSpecification assignQueryParamsForGetRequest(final Map<String,Object> queryParams){
        return getRequest()
                .queryParams(queryParams);

    }
}

