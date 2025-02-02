Feature: User Login


 @Smoke
  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters "user1" and "password123"
    Then user should be redirected to the homepage
    
    
      @Regression
  Scenario: Login with incorrect password
    Given user is on the login page
    When user enters "user1" and "wrongPass"
    Then an error message should be displayed