Feature: LoginAction
  
  Background: Launch the Browser
  Given User launches the Pactiv application 

  @RegressionTest
  Scenario Outline: User verify the data on the Line View
    Given User enters Username "<username>" and Password "<password>" 
    When User Clicks on Submit button
    And User Clicks on expand icon for Line 4 on plant view
    And User should land to Line View for Line 4
    And User verify the assets in the Line view
    And User verify the asset abridged view data for Blender Asset 
    And User verify the asset abridged view data for Extruder Asset
    And User verify the asset abridged view data for Haul off Asset
    And User verify the asset abridged view data for Thermoformer Asset
    And User verify the asset abridged view data for Trim Press Asset
    And User verify the asset abridged view data for Grinder Asset
    
     Examples:
    	
     | username          | password   |  
     | username_1		 		 | password_1 |  
     | username_2			   | password_2 | 
     | username_3			   | password_3 | 
     | username_4			   | password_4 | 