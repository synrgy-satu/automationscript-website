Feature: Register

  Scenario: Register an account to login
    Given user is on register page
    And user input information about card
    And user input information about email and phone number
    And user input information about kata sandi or password
    When user input information about PIN
    Then user success register an account