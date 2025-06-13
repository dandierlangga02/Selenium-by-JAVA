Feature: Register_account

  @Register_Valid
  Scenario: Register Valid
    Given I open the Chrome browser 2
    When I navigate to website "https://www.automationexercise.com/login"
    And I input Name and Email
    And I Click Signup
    And I Choose Mr. in Radio Bottom
    And I Input Password
    And I Set Date Birth 02 December 1998
    And I Input First Name
    And I Input Last Name
    And I Input Company
    And I Input Address
    And I Input Address 2
    And I Choose Country
    And I Input State
    And I Input City
    And I Input Zipcode
    And I Input Mobile Number
    And I click Create Account Bottom
    Then I Verify wording Account Created!

