Feature: Web Login

  Scenario Outline: User should be able to login with valid credentials
    Given User is on home page
    When User clicks Sign In
    And User enters <email> and <password>
    And clicks Sign In
    Then User should be logged in successfully
    Examples:
      | email                   | password    |
      | logintest1020@gmail.com | Qwert12345_ |

  Scenario Outline: User should not be able to login with invalid credentials
    Given User is on home page
    When User clicks Sign In
    And User enters <email> and <password>
    And clicks Sign In
    Then User should see an error Authentication failed
    Examples:
      | email                   | password    |
      | example@example.com | Qwert12345_ |