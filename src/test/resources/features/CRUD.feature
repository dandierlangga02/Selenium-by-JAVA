Feature: CRUD

  @Create
  Scenario: Create Data
    Given I open the Chrome browser 3
    When I navigate to website 2 "https://demoqa.com/webtables"
    And I Click Button Add
    And I Input First Name 1
    And I Input Last Name 1
    And I Input email 1
    And I Input Age 1
    And I Input salary
    And I Input Department
    And I Click Button Submit
    Then  I verify Data