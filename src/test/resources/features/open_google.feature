Feature: Open Google Homepage

  Scenario: Open Google using Chrome browser
    Given I open the Chrome browser
    When I navigate to the Google homepage
    Then The Google homepage should be displayed