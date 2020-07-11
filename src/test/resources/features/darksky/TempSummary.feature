Feature: TempSummary

  Scenario: Verify the temp value updates as per temp unit selected by user
    Given I am on Darksky landing page
    When I get the temp from feels like in ˚F
    And I click temp units dropdown menu
    And I select "˚C, mph" from the dropdown
    Then I verify that temp. conversion is happening correctly