@activity3
Feature: Testing with Tags

  @SimpleAlert @SmokeTest
  Scenario: Test for Simple Alert
    Given User is on the page
    When User clicks the Simple Alert button
    Then Alert opens
    And Read the text from it and print it
    And Close the alert
    And Read the result text

  @ConfirmAlert
  Scenario: Test for Confirm Alert
    Given User is on the page
    When User clicks the Confirmation Alert button
    Then Alert opens
    And Read the text from it and print it
    And Close the alert with Cancel
    And Read the result text

  @PromptAlert
  Scenario: Test for Prompt Alert
    Given User is on the page
    When User clicks the Prompt Alert button
    Then Alert opens
    And Read the text from it and print it
    And Write a custom message in it
    And Close the alert
    And Read the result text

  # An alternate approach using Scenario outline
  Scenario Outline:
    Given User is on the page
    When User clicks the <Type> Alert button
    Then Alert opens
    And Read the text from it and print it
    And Close the alert
    And Read the result text
  Examples:
    | Type |
    | Simple |
    | Confirmation |
    | Prompt  |