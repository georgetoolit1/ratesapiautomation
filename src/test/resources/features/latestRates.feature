Feature: Latest rates

  @smoke
  Scenario: Get the latest foreign exchange rates
    Given I use rate header
    When  I create get request to get the latest rates for all symbols
    Then  I get status code 200 from database

  @smoke
  Scenario: Get the latest foreign exchange rates and verify response
    Given I use rate header
    When  I create get request to get the latest rates for all symbols
    Then  I get status code 200 from database
    And   The rates response body should contain
        |base|
        |rates|

  @smoke
  Scenario: Get the latest foreign exchange rate when  an incomplete url is supplied
    Given I use rate header
    When  I create get request to get the latest rates using an incomplete url
    Then  I get status code 400 from database