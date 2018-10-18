Feature: Search Feature
  Verify if user is able to search for a specific product

  Scenario: Register new user
    Given user is on HomePage
    When user enters Printed Summer Dress into search field
    And user clicks on Printed Summer Dress in suggestion
    Then Printed Summer Dress PDP is displayed
