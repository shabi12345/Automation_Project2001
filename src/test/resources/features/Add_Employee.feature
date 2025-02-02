Feature: Add Employee in PIM
  
  As a user of OrangeHRM
  I want to log in using valid credentials
  So that I can access the dashboard successfully
  First, I will click on PIM, and then create an employee.
  I will enter all the details related to the employee and click on the Save button to add the employee.
 
 
 @RegressionCases
  Scenario: Adding an Employee in the PIM Section
    Given I am logged in as an Administrator
    When I navigate to the PIM page
    And I click the Add button
    And I enter "John" in the FirstName field
    And I enter "Wick" in the LastName field
    And I enter "20141" in the Employee-id field
    Then I click on the Create Login Details toggle button
    And I enter "John20141" in the Username field
    And I enter "poiu@123" in the Password field
    
      Scenario: Adding an Employee in the PIM Section
    Given I am logged in as an Administrator
    When I navigate to the PIM page
    And I click the Add button
    And I enter "John" in the FirstName field
    And I enter "Wick" in the LastName field
    And I enter "20141" in the Employee-id field
    Then I click on the Create Login Details toggle button
    And I enter "John20141" in the Username field
    And I enter "poiu@123" in the Password field
    
    
      Scenario: Adding an Employee in the PIM Section
    Given I am logged in as an Administrator
    When I navigate to the PIM page
    And I click the Add button
    And I enter "John" in the FirstName field
    And I enter "Wick" in the LastName field
    And I enter "20141" in the Employee-id field
    Then I click on the Create Login Details toggle button
    And I enter "John20141" in the Username field
    And I enter "poiu@123" in the Password field
    
    
    @SmokeCases