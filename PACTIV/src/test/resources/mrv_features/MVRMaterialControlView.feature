Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Moursville application

#@SmokeTest
  #Scenario Outline: Verify the expand icon navigation On Alarms section in Material Control View
    #And User enters moursville Username "<username>" and Password "<password>" 
    #Then User Clicks on the moursville Submit button
    #Then User Verifies the PlantView icon
    #Then User navigates to the Material Control View
    #Then User clicks on expand icon on Alarms Warning section
    #Then User is navigated to Activity Log Page
    #Then User should logout successfully from Mooresville
#
    #Examples: 
      #| username   | password   |
      #| username_1 | password_1 |
      #
#@SmokeTest
  #Scenario Outline: Verify user is able to navigate between lines in Material Control View
    #And User enters moursville Username "<username>" and Password "<password>" 
    #Then User Clicks on the moursville Submit button
    #Then User Verifies the PlantView icon
    #Then User navigates to the Material Control View
    #Then User verify the line dots "<line>" on Material Control View
    #Then User should logout successfully from Mooresville
#
    #Examples: 
      #| username   | password   | line   |
      #| username_1 | password_1 | line_1 |
      #| username_2 | password_2 | line_2 |
      #| username_3 | password_3 | line_3 |
      #| username_4 | password_4 | line_4 |
      #| username_5 | password_5 | line_5 |
      #| username_6 | password_6 | line_6 |
      #| username_7 | password_7 | line_7 | 
      #| username_8 | password_8 | line_8 |
      #| username_9 | password_9 | line_9    |
      #| username_10 | password_10 | line_10 |
      #| username_11 | password_11 | line_11 |
      #| username_12 | password_12 | line_12 |
      #| username_13 | password_13 | line_13 |
            
@SmokeTest1
  Scenario Outline: Verify the asset details on each line in Material Control View
    And User enters moursville Username "<username>" and Password "<password>" 
    Then User Clicks on the moursville Submit button
    Then User Verifies the PlantView icon
    Then User navigates to the Material Control View
    Then User verify the line number One on Material Control View
    Then User verify the Asset Details on Material Control View
    #Then User verify the line number twelve in Material Control View
    #Then User verify the Asset Details for line twelve in Material Control View
    #Then User verify the line number thirteen in Material Control View
    #Then User verify the Asset Details for line thirteen in Material Control View
    #Then User verify the line number fourteen in Material Control View
    #Then User verify the Asset Details for line fourteen in Material Control View
    #Then User verify the line number fifteen in Material Control View
    #Then User verify the Asset Details for line fifteen in Material Control View
    #Then User verify the line number sixteen in Material Control View
    #Then User verify the Asset Details for line sixteen in Material Control View
    #Then User verify the line number seventeen in Material Control View
    #Then User verify the Asset Details for line seventeen in Material Control View
    #Then User verify the line number eighteen in Material Control View
    #Then User verify the Asset Details for line eighteen in Material Control View
    #Then User verify the line number nineteen in Material Control View
    #Then User verify the Asset Details for line nineteen in Material Control View
    #Then User verify the line number twenty in Material Control View
    #Then User verify the Asset Details for line twenty in Material Control View
    #Then User verify the line number twenty one in Material Control View
    #Then User verify the Asset Details for line twenty one in Material Control View
    #Then User verify the line number twenty two in Material Control View
    #Then User verify the Asset Details for line twenty two in Material Control View
    #Then User verify the line number twenty three in Material Control View
    #Then User verify the Asset Details for line twenty three in Material Control View
    Then User should logout successfully from Mooresville

    Examples: 
      | username   | password      | 
      | username_1 | password_1    | 
     
   
