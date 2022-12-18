Feature: Feature of Exploring the Google Page Search Functionality

  Scenario: Validate Google Search Functionality
    Given browser is open
    And user is on google search page
    When user enters the text in search box
    And hits enter
    Then user is navigated to search results