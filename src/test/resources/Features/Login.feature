Feature: Test login functionality

  Scenario Outline: With valid credentials
    Given user is on login page
    When user enters <email> and <password>
    And user clicks on login
    Then user is navigated to home page

    Examples: 
      | email              | password |
      | ivanIvanov1@abv.bg |    12345 |

  Scenario Outline: With invalid credetials
    Given user is on login page
    When user enters <email> and <password>
    And user clicks on login
    Then user is not navigated to home page

    Examples: 
      | email              | password |
      | ivanIvanov1@abv.bg |     1234 |

  Scenario Outline: Without providing any credetials
    Given user is on login page
    When user enters <email> and <password>
    And user clicks on login
    Then user receives an error message wrong credentials

    Examples: 
      | email | password |
      |       |          |
