Feature: login functionality

  Scenario: Scenario login

    Given user on "https://automationexercise.com/"
    When user click Login or Sign in button
    And user login with the following credentials
      | username | denemexhasan@deneme.com |
      | password | Hasan.1234567           |
    Then login should be successfull