Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Moursville application

@SmokeTest
  Scenario Outline: Verify the Headers for Floater
    And User enters moursville Username "<username>" and Password "<password>" 
    Then User Clicks on the moursville Submit button
    Then User Clicks on  Moursville Production Tracking Icon for Floater
    Then User verify the title on Moursville Production Tracking Page for Floater
    Then User Clicks On Download Production Tracking Scrapped Report
    Then User Clicks on Download Production Tracking Report Button
    And User Clicks on Moursville Report Icon for Floater
    Then User verify the Moursville title on Report Page

    Examples: 
      | username   | password   |
      | username_1 | password_1 |
     