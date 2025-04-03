package com.step;


import com.firserv. VerificationRequest;
import com.global.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class StepDefinition  extends BaseClass {
    Response response;
    VerificationRequest cardNumberRequest;


    @Given("User have a valid API endpoint")
    public void user_have_a_valid_api_endpoint() {
        BaseClass.requestObject("http://localhost:8080/");
    }
    @And("User set the request header as {string} with value {string}")
    public void User_set_the_request_header_as_with_value(String headerName, String headerValue) {
        BaseClass.requestSpecification.header(headerName,headerValue);

    }
    @And("User set the request body with cardnumber    {string}")
    public void userSetTheRequestBodyWithCardnumber(String cardNumber) {


            cardNumberRequest = new  VerificationRequest (cardNumber);

            BaseClass.requestSpecification.body(cardNumberRequest);

        }
    @When("User send a POST request")
    public void User_send_a_post_request() {
        response = BaseClass.responseObject("POST","api/v3/verification/search");

    }

    @Then("The response status code should be {int}")
    public void The_response_status_code_should_be(Integer expectedStatusCode) {
       statusCode(response,expectedStatusCode);

//        statusCode(response,200);
        responseBody(response);


    }


}
