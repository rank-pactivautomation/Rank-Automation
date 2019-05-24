Feature: LoginAction

  @SmokeCPT
  Scenario Outline: Successful log into DMG application and verify Add New Plant
    Given User launches the "CPT-DMG" application
    And User enters Username "<username>" and Password "<password>"
    Then User Clicks on Submit button
    And User verifies the Landing Screen is "DMG HOME"
    And User clicks on the "Add Plant" Button
    And User verifies the Landing Screen is "DMG ADDPLANT HOME"
    And User verifies the "DMG Plant Details" is present
    And User verifies the "DMG Shift Details" is present
    And User verifies the "DMG Production Details" is present
    And User verifies the "DMG User Config" is present
    And User verifies the "DMG Publish Button" is present
    And User verifies the "DMG Save Draft Button" is present
    And User clicks on the "Back" Button
    And User should logout successfully

    Examples: 
      | username   | password   |
      | username_1 | password_1 |