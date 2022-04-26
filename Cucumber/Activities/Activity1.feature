@activity1
  Feature: Google Search

    Scenario: Searching for something on the google homepage
      Given User is on the google homepage
      When user types in cheese and hit enter
      Then show how many search results were generated
      And Close the Browser