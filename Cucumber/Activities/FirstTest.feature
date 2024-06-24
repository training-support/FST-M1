@FirstFeature
Feature: Basic Syntax
  @FirstScenario @SmokeTest
  Scenario: Basic Test For Selenium
    Given the user is on the TS homepage
    When the user clicks on the About Us Link
    Then the user is redirected to About page


@activity1
Scenario: Opening a webpage using Selenium
  Given User is on Google Home Page
  When User types in Cheese and hits ENTER
  Then Show how many search results were shown
  And Close the browser

@activity2
Scenario: Testing Login
  Given User is on Login page
  When User enters username and password
  Then Read the page title and confirmation message
  And Close the Browser