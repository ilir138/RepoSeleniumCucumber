Feature: Search


Scenario: Verify the cheapest available hotel is less than $100
Given I am on Hotels landing page
When I enter 'bora' in search-box
And I select 'Bora Bora, French Polynesia' from auto-suggestion
  And I click on search button
  Then I hover the mouse on Sort by Price and select 'Price (low to high)'
  And I verify that the cheapest hotel is less than 100 USD