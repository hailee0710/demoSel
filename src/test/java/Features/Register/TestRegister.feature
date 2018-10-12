Feature: Register Feature
  Verify if user is able to Register in to the site

  Scenario: Register new user
    Given user is on Homepage
    When user goes to Login Page
    And user enters email and click on Sign Up button
    And user enters all required information
    Then success message is shown
    And Name is displayed on header