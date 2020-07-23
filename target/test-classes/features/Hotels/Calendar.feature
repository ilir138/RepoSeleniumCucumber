Feature: Calendar

  Scenario: Verify user can select date from Calendar
    Given I am on hotels landing page
    When I enter tomorrow as check in
    And I enter 4 days from tomorrow as checkout
    Then I verify 4 count on the briefcase


  Scenario Outline: Verify user can select date from any month
    Given I am on hotels landing page
    When I enter <checkIn>> as check in date
    And I enter <days> days from check in date
    Then I verify <days> count on the briefcase

    Examples:
      | checkIn     | days |
      | October 20  | 11   |
      | September 10| 20   |