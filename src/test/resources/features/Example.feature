Feature: Lates date Rates

  @smoke
  Scenario: Get the latest foreign exhange rates
    Given I use customer header
    When  I create get request to get the latest rates for all symbols
    Then I get status code 200 from database


