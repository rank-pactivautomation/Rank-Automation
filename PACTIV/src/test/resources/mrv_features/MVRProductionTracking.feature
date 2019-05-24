Feature: LoginAction

  Background: Launch the Browser
   Given User launches the Moursville application

  @SmokeTest1
  Scenario Outline: Verify the ProductionTracking Data
    Given User enters moursville Username "<username>" and Password "<password>"  
    When User Clicks on the moursville Submit button
    Then User Clicks on  Moursville Production Tracking Icon for Floater
    Then User checks if hourly boxes are visible for "<line>" box
    Then User selects the Moursville shift
    Then User Clicks on "<line>" on Moursville ProductionTracking for shift1
    Then User Clicks on "<line>" on Moursville ProductionTracking for shift2
    #
    #Then User Clicks On Download Production Tracking Scrapped Report
    #Then User Clicks on Download Production Tracking Report Button
    #
    #Then User selects the shift
    #Then User Clicks on Pending box
    #Then User Clicks on Add Diagnosis
    #Then User Clicks on Select Row
    #Then User Enters the Actual Cases
    #Then User Clicks on Select LevelOne
    #Then User Clicks on Select LevelTwo
    #Then User Clicks on Select LevelThree
    #Then User Clicks on Save button on ProductionTracking

    Examples: 
      | username   | password     | line  |
      | username_1 | password_1   | line_1|
     #| username_2 | password_2   | line_2|
     #| username_3 | password_3   | line_3|
     #| username_4 | password_4   | line_4|
      #| username_5 | password_5   | line_5|
      #| username_6 | password_6   | line_6|
      #| username_7 | password_7   | line_7|
    #  | username_8 | password_8   | line_8|
     # | username_9 | password_9   | line_9|
    #  | username_10 | password_10 | line_10|
     # | username_11 | password_11 | line_11|
     # | username_12 | password_12 | line_12|
     # | username_13 | password_13 | line_13|
      #| username_14 | password_14 | line_14|
      #| username_15 | password_15 | line_15|
      #| username_16 | password_16 | line_16|
      #| username_17 | password_17 | line_17|
      #| username_18 | password_18 | line_18|
      #
      
      
       #Scenario Outline: Verify the ProductionTracking Data 
   #	 Given User enters moursville Username "<username>" and Password "<password>"  
    #	When User Clicks on the moursville Submit button
    #	Then User Clicks on  Moursville Production Tracking Icon for Floater
    #	#Then User selects the Moursville shift
    #	Then User Clicks on "<line>" on Moursville ProductionTracking
     #Then User selects the shift 
     #
#
    #Examples: 
      #| username   | password     | line  |
      #| username_1 | password_1   | line_1|
     #| username_2 | password_2   | line_2|
     #| username_3 | password_3   | line_3|
     #| username_4 | password_4   | line_4|
      #| username_5 | password_5   | line_5|
    #  | username_6 | password_6   | line_6|
      #| username_7 | password_7   | line_7|
    #  | username_8 | password_8   | line_8|
     # | username_9 | password_9   | line_9|
    #  | username_10 | password_10 | line_10|
     # | username_11 | password_11 | line_11|
     # | username_12 | password_12 | line_12|
     # | username_13 | password_13 | line_13|