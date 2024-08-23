Feature: Mutation

  Scenario: Check and see the mutation
    Given user is on login page
    And user input email with "gilangzhanuardy3222@gmail.com"
    And user input password with "Testing123*"
    And user click on login button
    And user click on transaksi mutasi rekening sidebar button
    When user input information mutation
    Then user can see the mutation