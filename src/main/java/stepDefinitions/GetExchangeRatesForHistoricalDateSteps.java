package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.DateUtils;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.get;


public class GetExchangeRatesForHistoricalDateSteps {

    private String apiForHistoricalExchangeRate;
    private String apiForFutureExchangeRate;
    private String incorrectApiForHistoricalExchangeRate;
    private Response response;
    static String BASE_URL = "https://api.ratesapi.io/api/";
    private DateUtils dateUtils;

    public GetExchangeRatesForHistoricalDateSteps(DateUtils dateUtils){
        this.dateUtils = dateUtils;
    }

//raj
//Test exchange rate api service for old date with correct url
    @Given("^Rest api service url with old date is given$")
    public void rest_api_service_url_with_old_date_is_given() {
        apiForHistoricalExchangeRate = BASE_URL + dateUtils.getOldDate();
    }
    @When("^Rest api service url with old date is called$")
    public void rest_api_service_url_with_old_date_is_called()  {
        response = get(apiForHistoricalExchangeRate);
    }
    @Then("^Assert the status code for old date is 200$")
    public void assert_the_status_code_for_old_date_is_200() {
        response.getStatusCode();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Then("^Assert the response for old date$")
    public void assert_the_response_for_old_date() {
        get(apiForHistoricalExchangeRate).then().body("base",equalTo("EUR"));
        get(apiForHistoricalExchangeRate).then().body("date",equalTo(dateUtils.getOldDate()));
    }


    //Test exchange rate api service for future date with correct url
    @Given("^Rest api service url with future date is given$")
    public void rest_api_service_url_with_future_date_is_given() {
        apiForFutureExchangeRate = BASE_URL + dateUtils.getFutureDate();
    }
    @When("^Rest api service url with future date is called$")
    public void rest_api_service_url_with_future_date_is_called()  {
        response = get(apiForFutureExchangeRate);
    }
    @Then("^Assert the status code for future date is 200$")
    public void assert_the_status_code_for_future_date_is_200() {
        response.getStatusCode();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Then("^Assert the date is equal to current date in response$")
    public void assert_the_date_is_equal_to_current_date_in_response() {
        get(apiForFutureExchangeRate).then().body("date",equalTo(dateUtils.getCurrentDate()));
    }


    //Test exchange rate api service for old date with incorrect url
    @Given("^Rest api service for old date is incorrect$")
    public void rest_api_service_for_old_date_is_incorrect() {
        incorrectApiForHistoricalExchangeRate = "https://api.ratesapi.io/ap/" + dateUtils.getCurrentDate();
    }

    @When("^Incorrect rest api service for old date is called$")
    public void incorrect_rest_api_service_for_old_date_is_called()  {
        response = get(incorrectApiForHistoricalExchangeRate);
    }

    @Then("^Assert the status code for incorrect url for future date is 404$")
    public void assert_the_status_code_for_incorrect_url_for_future_date_is_404() {
        Assert.assertEquals(response.getStatusCode(), 404);

    }

    }

