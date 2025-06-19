Feature: Create Read Update Delete

  Scenario: Create
    Given I Open Website "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I Login Website and Click Submit
    And I Click Sub Menu PIM
    And I Click +Add
    And I Fill Data First Name, Middle Name, & Last name
    And I Click Create Login Details
    And I Fill Username, Password, & Confirm Password
    And I click Bottom Save
    Then I Verify Data Add Employee