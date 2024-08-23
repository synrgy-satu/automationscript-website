Feature: Transfer

  Scenario: Transfer balance to other rekening
    Given user is on login page
    And user input email with "gilangzhanuardy3222@gmail.com"
    And user input password with "Testing123*"
    And user click on login button
    And user click on transfer sidebar button
    And user click on transfer button
    When user click on transfer to satu button
    Then user input information transfer