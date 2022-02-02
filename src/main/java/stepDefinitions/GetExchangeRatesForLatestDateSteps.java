package main.java.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.get;
import io.restassured.response.Response;
import org.testng.Assert;
import static org.hamcrest.Matchers.*;
import main.java.utils.Utils;


public class GetExchangeRatesForLatestDateSteps {

    private String apiForLatestExchangeRate;
    private String incorrectApiForLatestExchangeRate;
    private Response response;
    private final Utils utils;

    //Getting utils with common methods using Cucumber's dependency injection
    public GetExchangeRatesForLatestDateSteps(Utils utils){

        this.utils = utils;
    }


    //Test exchange rate api service for current date with correct url
    @Given("^Rest api service for latest date is available$")
    public void rest_api_service_for_latest_date_is_available() {
        apiForLatestExchangeRate = utils.baseUri() + "latest";
    }

    @When("^Rest api service for latest date is called$")
    public void rest_api_service_for_latest_date_is_called()  {
        response = get(apiForLatestExchangeRate);
    }

    @Then("^Assert the status code for current date is 200$")
    public void assert_the_status_code_for_current_date_is_200() {

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("^Assert the response for the current date$")
    public void assert_the_response_for_the_current_date() {
        get(apiForLatestExchangeRate).then()
                .contentType("application/json")
                .body("base",equalTo("EUR"))
                .body("date",equalTo(utils.getCurrentDate()))
                .body("rates",notNullValue());
        for(int i=0;i<utils.getCurrencyList().length;i++){
            get(apiForLatestExchangeRate).then().body("rates",hasKey(utils.getCurrencyList()[i]));
        }
    }

    //Test exchange rate api service for current date with incorrect url
    @Given("^Rest api service for latest date is incorrect$")
    public void rest_api_service_for_latest_date_is_incorrect() {
        incorrectApiForLatestExchangeRate = utils.baseUri() + "late";
    }

    @When("^Incorrect rest api service for latest date is called$")
    public void incorrect_rest_api_service_for_latest_date_is_called()  {
        response = get(incorrectApiForLatestExchangeRate);
    }

    @Then("^Assert the status code for wrong url for current date is 400$")
    public void assert_the_status_code_for_wrong_url_for_current_date_is_400() {
        Assert.assertEquals(response.getStatusCode(), 400);

    }
}

