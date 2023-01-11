Feature: Test FB Smoke Scenario


  Scenario: Check login is sucessful with valid credentials
    Given Open the Chrome and start the application
    When user enters valid username and valid password
    Then user is navigated to the home page

 