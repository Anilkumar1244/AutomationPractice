Feature: Test Login Functionality

  Scenario Outline: Check login is successfull with credentials
    Given User is on browser
    And login page is opened
    When user enters <Username> and <Password>
    And user clicks on login button
    Then user is navigated to Home page

    Examples: 
      | Username | Password |
      | Admin    | admin123 |
      | Admin12  | admin34  |
