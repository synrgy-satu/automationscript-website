Feature: Info Saldo

  Scenario: Check balance and information about card and account
    Given user is on login page
    And user input email with "gilangzhanuardy3222@gmail.com"
    And user input password with "Testing123*"
    And user click on login button
    When user click tabungan page on sidebar
    Then user is on tabungan page