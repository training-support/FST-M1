@Test1
Feature: Feature is to login to the page
 @scenario1
 Scenario: scenario 1
 Given User is on the Login page
 When User enters the username and password
 Then Read the page title and confirmation message
 And Close the Browser

 @scenario2
 Scenario Outline: scenario 2
 Given User is on the Login page
 When User enters <username> and <password>
 Then Read the page title and confirmation message
 And Close the Browser
 Examples:
     |  username       |      password     |
     |     user1       |     password      |
     |      user2      |     password123   |


