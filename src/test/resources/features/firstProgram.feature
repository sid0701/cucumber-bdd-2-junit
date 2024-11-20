Feature: This is to demo the features of Feature Files

  Scenario Outline: Mortgage User Page default login
    Given User is on NetBanking landing page
    When User login into application with "<Username>" and password "<Password>"
    Then Home Page is displayed
    And Cards are displayed

    Examples:
      | Username   | Password |
      | debituser  | Test123  |
      | credituser | Test456  |


  @SmokeTest
  Scenario: User Page default Sign Up
    Given User is on Practice landing page
    When User Signup into application
      | rahul             |
      | shetty            |
      | contact@email.com |
      | 253479987         |
    Then Home Page is displayed
    And Cards are displayed
