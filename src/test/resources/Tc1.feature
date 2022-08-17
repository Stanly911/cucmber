@tag
Feature: Login 

  @tag1
  Scenario: Login with valid credentials
    Given Open the browser and enter the valid URL
    When user enters valid username
    And user enters valid password
    When click on login button 
    Then homepage of the application should be displayed

      

