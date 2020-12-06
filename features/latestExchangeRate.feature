Feature: Test currency exchange rates api service for current date with correct and incorrect service url

  Scenario: Test exchange rate api service for current date with correct url
    Given Rest api service for latest date is available
    When Rest api service for latest date is called
    Then Assert the status code for current date is 200
      And Assert the response for the current date

  Scenario: Test exchange rate api service for current date with incorrect url
    Given Rest api service for latest date is incorrect
    When Incorrect rest api service for latest date is called
    Then Assert the status code for wrong url for current date is 400
