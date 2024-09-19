@activity6
Feature: DataTable Test Validation
  @Scenario1
  Scenario: Testing with Data from data table
    Given User is on Login page
    When User enters the following username and password
      | admin | password |
    Then Read the page title and confirmation message
    And Close the Browser
  @Scenario2
  Scenario: Testing the todo loop
    Given User is ToDo list page
    When User enters the following task
      | task1 |
      | task2 |
      | task3 |
    Then tasks are added and verify results