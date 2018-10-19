Feature: Login Feature
  Verify if user is able to Login in to the site

    @DoAfterLoginSuccess
  Scenario: Login as a authenticated user
    Given user is on homepage
    When user navigates to Login Page
    And user enters username and Password
    Then success message is displayed
    
	  @DoAfterLoginSuccess    
  Scenario: Login fail as user is not exist
  	Given user is on homepage
  	When user navigates to Login Page
  	And user enters non existing username and Password
  	Then error message is displayed
  	