Feature: Basic Syntax

  Scenario: Scenario 1
    Given User opens Training Support Site
    When the user clicks About Us button
    Then the About Us page opens
    And Close the browser


    Scenario Outline: Scenario 2
      Given user is on Login Page
      When user enters "<username>" and "<passwords>"
      And user clicks submit button
      Then confirmation appears
      And Close the browser


      Examples:
      | username | passwords |
      | admin    | password  |
      | Seema    | password  |
