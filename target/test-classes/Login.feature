Feature: Login functionality for OrangeHRM

  As a user of OrangeHRM
  I want to log in using valid credentials
  So that I can access the dashboard successfully

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials "Admin" and "admin123"
    And clicks on the login button
    Then the user should be redirected to the dashboard page

  Scenario: Login attempt with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials "InvalidUser" and "wrongpass"
    And clicks on the login button
    Then an error message should be displayed

  Scenario: Login attempt with empty username and password
    Given the user is on the login page
    When the user leaves the username and password fields blank
    And clicks on the login button
    Then an error message should be displayed indicating required fields

    
    