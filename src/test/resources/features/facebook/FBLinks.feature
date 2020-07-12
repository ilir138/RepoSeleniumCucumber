Feature: FBLinks
  Scenario: Verify Terms link takes goes to correct web page
    Given 1. I am on facebook landing page
    When 1. I click on Terms link
    Then 1. I verify user is on 'Terms of Service' page title
    And 1. I verify facebook landing page is open
    And 1. I close all facebook window

  Scenario: Verify Data Policy link takes goes to correct web page
    Given 2. I am on facebook landing page
    When 2. I click on Data Policy link
    Then 2. I verify user is on 'Data Policy' page title
    And 2. I verify facebook landing page is open
    And 2. I close all facebook window

  Scenario: Verify Cookie Policy link takes goes to correct web page
    Given 3. I am on facebook landing page
    When 3. I click on Cookie Policy link
    Then 3. I verify user is on 'Cookie Policy' page title
    And 3. I verify facebook landing page is open
    And 3. I close all facebook window