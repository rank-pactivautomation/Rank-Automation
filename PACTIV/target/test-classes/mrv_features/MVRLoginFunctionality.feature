Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Moursville application

@SmokeTest
  Scenario Outline: Successful log into Moursville application with Valid Credentials
    And User enters moursville Username "<username>" and Password "<password>" 
    Then User Clicks on the moursville Submit button
    Then User should logout successfully from Mooresville

    Examples: 
      | username   | password   |
      | username_1 | password_1 |
      | username_2 | password_2 |
      | username_3 | password_3 |
      | username_4 | password_4 |
      | username_5 | password_5 |

  