Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Moursville application

@SmokeTest
  Scenario Outline: Verify the details on the Notifications Page
    And User enters moursville Username "<username>" and Password "<password>" 
    Then User Clicks on the moursville Submit button
    Then User Verifies the PlantView icon
    Then User navigates to the Notifications page
    Then User verify the details on the Notifications page
    
    Examples: 
      | username   | password   |
      | username_1 | password_1 |