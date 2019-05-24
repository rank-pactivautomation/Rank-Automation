Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Moursville application

@SmokeTest

Scenario Outline: Verify Floater is able to submit the report
    Given User enters moursville Username "<username>" and Password "<password>" 
    Then User Clicks on the moursville Submit button
  	And User Clicks on Moursville Report Icon for Floater
    Then User verify the Moursville title on Report Page
  	#Then User verify the incomplete reports for floater
    Then User verify Review & Submit Button is displayed for floater
   
    
    Examples: 
      | username   | password   |
      | username_1 | password_1 |
      
      
  Scenario Outline: Verify Supervisor to submit the report
    And User enters moursville Username "<username>" and Password "<password>" 
    Then User Clicks on the moursville Submit button
    And  User Clicks on Moursville Report Icon for Supervisor
    Then User verify the Moursville title on Report Page 
  
    Then User verify Review & Submit Button is displayed for supervisor
    #Then User verify the Total Downtime value is displayed for supervisor
    #Then User verify Shift OEE text is displayed for supervisor
    #Then User verify the values for Shift OEE for supervisor
    #Then User verify Cases Produced text is displayed for supervisor
    #Then User verify the values for Cases Produced for supervisor
    #Then User verify Total Downtime text is displayed for supervisor
    #Then User verify the Total Downtime value is displayed for supervisor
   #
   
     Examples: 
      | username   | password   |
      | username_1 | password_1 |
    
    
    
    
    
    