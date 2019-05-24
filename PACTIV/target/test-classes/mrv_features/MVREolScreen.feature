Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Moursville application

@SmokeTest
  Scenario Outline: Successful log into Moursville application with EOL Credentials
    And User enters moursville Username "<username>" and Password "<password>" 
    Then User Clicks on the moursville Submit button
    Then User Verifies the Text on EOL Screen
    Then User logs out of EOL

    Examples: 
      | username   | password   |
      | username_1 | password_1 |
    