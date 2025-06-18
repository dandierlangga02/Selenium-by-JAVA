Feature: Scenario Login

  Scenario: Login Valid Username & Password
    Given user open web "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user Input Valid Username & Valid Password
    And user Click button Login
    Then user verify Home Page

  Scenario: Login Invalid Username & Valid Password
    Given user open web "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user Input invalid Username & Valid Password
    And user Click button Login
    Then user verify Error Message

  Scenario: Login valid Username & InvalidPassword
    Given user open web "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user Input valid Username & invalid Password
    And user Click button Login
    Then user verify Error Message