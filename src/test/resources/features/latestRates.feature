Feature: Latest date Rates

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
  Scenario: Get the latest foreign exchange rate using an invalid url
    Given I use rate header
    When  I create get request to get the latest rates using an invalid url
    Then  I get status code 400 from database