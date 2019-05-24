Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Moursville application

  #@SmokeTest
  #Scenario Outline: Verify the Mooresville PlantView data
    #Given User enters moursville Username "<username>" and Password "<password>"
    #When User Clicks on the moursville Submit button
    #Then User Verifies the PlantView icon
    #Then User Verifies the Plant View Title
    #And User is able to switch between plant view and material view
    #And User Verify the asset dot and asset for the line in mooresville
#
    #Examples: 
      #| username   | password   |
      #| username_1 | password_1  |
      #
  #
  #Scenario Outline: Verify the Plant OEE value
    #Given User enters moursville Username "<username>" and Password "<password>"
    #When User Clicks on the moursville Submit button
    #Then User Verifies the PlantView icon
    #And User Verifies Plant OEE
#
    #Examples: 
      #| username   | password   |
      #| username_1 | password_1 |
#
  @SmokeTest
  Scenario Outline: Verify the alarm widget data on Mooresville plant view
  
  Given User enters moursville Username "<username>" and Password "<password>"
  When User Clicks on the moursville Submit button
  Then User Verifies the PlantView icon
  Then User Verifies the Alarm Widget Column Headers
  Then User Verifies Total alarm and total warning value
  
  Examples:
  | username          | password    |
  | username_1		 		 | password_1  |
  
  #Scenario Outline: Verify the Navigation to Activity log Mooresville PlantView data
    #Given User enters moursville Username "<username>" and Password "<password>"
    #When User Clicks on the moursville Submit button
    #Then User Verifies the PlantView icon
    #Then User navigates to Activity Log upon expanding Alarm section
    #Then User should logout successfully from Mooresville
#
    #Examples: 
      #| username   | password   |
      #| username_1 | password_1  |
      #
