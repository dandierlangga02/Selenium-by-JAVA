Feature: Login

  @login_valid
  Scenario: Login practice test automation
    Given I open the Chrome browser 1
    When I navigate to web practice test automation
    When I Input Username and Password
    When I Click Submit
    Then I Verify appears wording successfully logged in

  @login_not_valid_username
  Scenario: Login practice test automation Not Valid Username
    Given I open the Chrome browser 1
    When I navigate to web practice test automation
    When I Input Not Valid Username and Valid Password
    When I Click Submit
    Then I Verify error massage 'Your username is invalid!'

  @login_not_valid_password
  Scenario: Login practice test automation Not Valid Password
    Given I open the Chrome browser 1
    When I navigate to web practice test automation
    When I Input Valid Username and Not Valid Password
    When I Click Submit
    Then I Verify error massage 'Your password is invalid!'