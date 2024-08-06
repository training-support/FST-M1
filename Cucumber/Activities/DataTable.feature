@DataTable

Feature: Data driven test with Example

  Scenario: Testing with DataTable from Scenario
    Given User is on Login page
    When User enters the following username and password
      | Usernames | Passwords |
      | admin     | password |
      | adminUser | Password |
      | adminUser | WrongPassword |
    Then Read the page title and confirmation message
    And Close the Browser
