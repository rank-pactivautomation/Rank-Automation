Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Pactiv application
   
  @RegressionTest
  Scenario Outline: Verify the PlantView data
    Given User enters Username "<username>" and Password "<password>" 
    When User Clicks on Submit button
    And User Verify the asset dot and asset for the line
    Then User should logout successfully
     
    
     Examples:
    	
     | username          | password    | 
     | username_1		 		 | password_1  | 
     #| username_2        | password_2  | 
     #| username_3		 		 | password_3  | 
     #| username_4        | password_4  | 
    
     