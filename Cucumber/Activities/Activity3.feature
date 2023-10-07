@Activity3
Feature: Testing with Tags

  @SimpleAlert @SmokeTest
  Scenario: Testing with Simple Alert
    Given User is on the page
    When User clicks the Simple Alert button
    Then Alert opens
    And Read the text from it and print it
    And Close the alert
    And Close Browser

  @ConfirmAlert
  Scenario: Testing with Confirm Alert
    Given User is on the page
    When User clicks the Confirm Alert button
    Then Alert opens
    And Read the text from it and print it
    And Close the alert with Cancel
    And Close Browser

  @PromptAlert
  Scenario: Testing with Prompt Alert
    Given User is on the page
    When User clicks the Prompt Alert button
    Then Alert opens
    And Read the text from it and print it
    And Write a custom message in it
    And Close the alert
    And Close Browser