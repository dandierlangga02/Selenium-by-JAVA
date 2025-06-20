Feature: Create Read Update Delete

  Scenario: Create
    Given I Open Website "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I Login Website and Click Submit
    And I Click Sub Menu PIM
    And I Click +Add
    And I Input Photo Profile
    And I Fill Data First Name, Middle Name, & Last name
    And I Click Create Login Details
    And I Fill Username, Password, & Confirm Password
    And I click Bottom Save
    Then I Verify Data Add Employee

    Scenario: Read
      Given I Open Website "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
      When I Login Website and Click Submit
      And I Click Sub Menu PIM
      And I Click Button Down Fill
      And I Fill Field Employee Name
      And I Click Button Search
      Then I Verify Appears Name = Dandi

  Scenario: Read_2
    Given I Open Website "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I Login Website and Click Submit
    And I Click Sub Menu PIM
    And I Click Button Down Fill
    And I Fill Field Employee ID
    And I Click Button Search
    Then I Verify Appears ID

  Scenario: Update
    Given I Open Website "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I Login Website and Click Submit
    And I Click Sub Menu PIM
    And I Click Button Down Fill
    And I Fill Field Employee Name
    And I Click Button Search
    And I click button Edit
    And I Update Lastname
    And I Click Button Save
    Then I Verify Update LastName
