@smoke
Feature: Get rates for a specified date
  Scenario Outline: Get the  foreign exchange rates for a past and verify response code
    Given I use rate header
    When  I create get request to get the latest rates for all symbols for "<date>"  date
    Then  I get status code 200 from database

    Examples:
    |date          |
    | 2015-05-12   |
    | 2016-11-12   |
    | 2017-07-12   |

  Scenario Outline: Get foreign exchange rates for a past date
    Given I use rate header
    When  I create get request to get the latest rates for all symbols for "<date>"  date
    Then  I get status code 200 from database
    And   The rates response body should contain
      |base|
      |rates|

    Examples:
      |date          |
      | 2015-05-12   |
      | 2016-11-12   |
      | 2017-07-12   |

   Scenario Outline: Get foreign exchange rates for a future date
     Given I use rate header
     When  I create get request to get the latest rates for all symbols for "<date>"  date
     Then  I get status code 200 from database
     And   The response body should contain current date
          |date|

     Examples:
     |date          |
     | 2020-05-12   |
