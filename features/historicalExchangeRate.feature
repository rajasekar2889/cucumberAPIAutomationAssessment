Feature: Test historical exchange rates api service for old date with correct and incorrect service url

  Scenario: Test exchange rate api service for old date with correct url
    Given Rest api service url with old date is given
    When Rest api service url with old date is called
    Then Assert the status code for old date is 200
    And Assert the response for old date

  Scenario: Test exchange rate api service for future date with correct url
    Given Rest api service url with future date is given
    When Rest api service url with future date is called
    Then Assert the status code for future date is 200
      And Assert the date is equal to current date in response

  Scenario: Test exchange rate api service for old date with incorrect url
    Given Rest api service for old date is incorrect
    When Incorrect rest api service for old date is called
    Then Assert the status code for incorrect url for future date is 404
