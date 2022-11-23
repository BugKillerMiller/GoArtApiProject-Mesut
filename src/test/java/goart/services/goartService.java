package goart.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class goartService extends BaseService {

    /**
     * Template for GET request. More methods could be created based on needs
     * (ie. request_with_body or request_with_authentication)
     */
    public static Response getMethod() {
        return getRequest().get();

    }

}