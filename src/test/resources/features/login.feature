Feature: Login

  Scenario: Login with valid username and password
    Given user is on login page
    And user input email with "gilangzhanuardy3222@gmail.com"
    And user input password with "Testing123*"
    When user click on login button
    Then user is on home page