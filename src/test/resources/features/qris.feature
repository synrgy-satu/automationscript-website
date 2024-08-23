Feature: QRIS

  Scenario: Show QRIS
    Given user is on login page
    And user input email with "gilangzhanuardy3222@gmail.com"
    And user input password with "Testing123*"
    And user click on login button
    And user click on satu portal qris sidebar button
    When user input information qris
    Then user can see the qris