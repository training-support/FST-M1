@activity2_5
Feature: Login Test

@tag1
Scenario Outline: Testing Login with Examples    
    Given User is on Login page
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message
    And Close the browser



    Examples: 
      | Usernames  | Passwords |
      | admin      | password | 
      | adminUser  | password | 
