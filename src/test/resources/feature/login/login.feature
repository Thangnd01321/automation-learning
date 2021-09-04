Feature: User can login successfully

  Background:
    Given Web browser is open
    And User open login page: "https://demo.anhtester.com/login"

  Scenario: As a user, I can login into dashboard
    When User enter email: "user01@anhtester.com"
    And User enter password: "123456"
    And User click on login button
    Then User is on Dashboard
      | url                                |
      | https://demo.anhtester.com/gui_pos |
    And User should see message "Welcome Back User 01"
