@Activity1

  Feature: First Test
    Scenario: Opening a web page using selenium
      Given User is on Google Home Page
      When User types in Cheese and hits ENTER
      Then Show how many search results were shown
      And Close the browser