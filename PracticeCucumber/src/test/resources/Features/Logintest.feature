Feature: Test Login Functionality

  Scenario: Validate Login Page
    Given User is on login page
    When Enter Username and Passowrd
    And User Clicks on Login button
    Then User Navigate to Home Page

  #Scenario Outline: Validate Login Page
   # Given User is on login page1
   # When Enter <Username> and <Passowrd>
   # And User Clicks on Login button2
    #Then User Navigate to Home Page3

   # Examples: 
    #  | Username | Passowrd |
     # | name1    |        5 |
     # | name2    |        7 |
  