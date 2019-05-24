Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Pactiv application

  @RegressionTest
  Scenario Outline: User verify the data on the Asset Detailed View
    Given User enters Username "<username>" and Password "<password>" 
    When User Clicks on Submit button
    And User Clicks on expand icon for Line 4 on plant view
    And User should land to Line View for Line 4
    And User clicks on Blender Asset
    And User Clicks on expand icon for asset abridged view
    And User selects "<Line>" from Line dropdown
    And User selects the "<asset>" filter
    And User verifies the Process Sheet data for "<line>" and "<assetName>" 

    Examples: 
      | username   | password   | asset   | line   | assetName   | Line   |
      | username_1 | password_1 | asset_1 | line_1 | assetName_1 | Line_1 |
      | username_2 | password_2 | asset_2 | line_2 | assetName_2 | Line_2 |
      | username_3 | password_3 | asset_3 | line_3 | assetName_3 | Line_3 |
      | username_4 | password_4 | asset_4 | line_4 | assetName_4 | Line_4 |
      | username_5 | password_5 | asset_5 | line_5 | assetName_5 | Line_5 |

  