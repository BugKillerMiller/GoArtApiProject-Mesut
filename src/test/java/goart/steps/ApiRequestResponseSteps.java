package goart.steps;

import goart.services.goartService;
import goart.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import javax.security.auth.login.Configuration;

import java.util.HashMap;
import java.util.Map;

import static goart.services.goartService.getMethod;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiRequestResponseSteps {

    public Response response;


    @Then("verify status code as {int}")
    public void verifyStatusCodeAs(int status) {

        assertEquals(status,response.statusCode());
    }

    @Then("verify user id created as response body")
    public void verifyUserIdCreatedAsResponseBody() {

        Assert.assertTrue(response.path("userId").equals("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
    }

    @Then("verify the users listed as expected")
    public void verifyTheUsersListedAsExpected() {
        assertEquals(response.contentType(), "application/json; charset=utf-8");

        String id =  response.path("id");
        String firstName = response.path("firstName");
        String lastName = response.path("lastName");
        String username = response.path("username");
        boolean isActive = response.path("isActive");

        assertEquals(id,"c4f6c088-f91b-494e-b7f0-a08f48df3180");
        assertEquals(firstName,"jane");
        assertEquals(lastName,"doe");
        assertEquals(username,"doejj");
        assertEquals(isActive,true);

    }

    @Then("verify the user remove from users list")
    public void verifyTheUserRemoveFromUsersList() {
    }

    @Given("the user send GET request")
    public void theUserSendGETRequest() {

        response = getMethod();
        response.prettyPrint();

    }

    @And("verifies the content type is {string}")
    public void verifiesTheContentTypeIs(String ContentType) {

        assertEquals(ContentType,response.contentType());

    }

    @Given("User send POST request with the body {string} {string} {string} {string}")
    public void userSendPOSTRequestWithTheBody(String firstName, String lastName, String username, String password) {

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("firstName", firstName);
        requestMap.put("lastName", lastName);
        requestMap.put("username", username);
        requestMap.put("password", password);

        response = given().accept("application/json").contentType("application/json").
                body(requestMap).when().post(ConfigurationReader.get("mockUrl"));
    }

    @Given("User send GET request with id {string}")
    public void userSendGETRequestWithId(String id) {

        response = given().accept(ContentType.JSON).
                and().pathParam("id", id).
                when().get(ConfigurationReader.get("mockUrl")+"/{id}");
    }

    @Given("User send DELETE request with id {string}")
    public void userSendDELETERequestWithId(String id) {

        response = given().accept(ContentType.JSON).
                and().pathParam("id", id).
                when().delete(ConfigurationReader.get("mockUrl")+"/{id}");

    }


    @Given("User send PATCH request to this endpoint {string} with {string}")
    public void userSendPATCHRequestToThisEndpointWith(String id, String requestBody) {

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("isActive", requestBody);

        response = given().accept(ContentType.JSON).
                and().pathParam("id", id).body(requestMap).
                when().patch(ConfigurationReader.get("mockUrl")+"/{id}/activity");

    }


    @Given("User send PUT request to this endpoint {string} with {string} {string}")
    public void userSendPUTRequestToThisEndpointWith(String id, String firstName, String lastName) {

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("firstName", firstName);
        requestMap.put("lastName", lastName);

        response = given().accept(ContentType.JSON).
                and().pathParam("id", id).body(requestMap).
                when().put(ConfigurationReader.get("mockUrl")+"/{id}");

    }
}
