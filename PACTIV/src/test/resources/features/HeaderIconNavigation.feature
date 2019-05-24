Feature: LoginAction
  
  Background: Launch the Browser
  Given User launches the Pactiv application 

  
  Scenario Outline: Verify the Headers for PlantManager
    Given User enters Username "<username>" and Password "<password>"
    When User Clicks on Submit button
    Then User verify the title on Dashboard Page
    Then User Clicks on Production Tracking Icon
    Then User verify the title on Production Tracking Page
    Then User Clicks on Activity Log Icon
    Then User verify the title on Activity Log Page
    Then User Clicks on Notifications Icon
    Then User verify the title on Notifications Page
    And User Clicks on User Profile button
    Then User verify the title on User Profile Page
    
     Examples: 
      | username   | password   | 
      | username_1 | password_1 | 
      
 Scenario Outline: Verify the Headers for Supervisor
    Given User enters Username "<username>" and Password "<password>"
    When User Clicks on Submit button 
    Then User verify the title on Dashboard Page 
    Then User Clicks on Production Tracking Icon 
    Then User verify the title on Production Tracking Page for Supervisor
    Then User Clicks on Activity Log Icon
    Then User verify the title on Activity Log Page 
    Then User Clicks on Notifications Icon
    Then User verify the title on Notifications Page 
    And User Clicks on Report Icon
    Then User verify the title on Report Page
    And User Clicks on User Profile button for Supervisor
    Then User verify the title on User Profile Page 
    
     Examples: 
      | username   | password   | 
      | username_1 | password_1 | 
      
      
      
 Scenario Outline: Verify the Headers for Maintenance
    Given User enters Username "<username>" and Password "<password>" 
    When User Clicks on Submit button 
    Then User verify the title on Dashboard Page
    Then User Clicks on Activity Log Icon for Maintenance
    Then User verify the title on Activity Log Page 
    Then User Clicks on Notifications Icon for Maintenance
    Then User verify the title on Notifications Page 
    And User Clicks on User Profile button for MaterialHandler
    Then User verify the title on User Profile Page 
    
     Examples: 
      | username   | password   | 
      | username_1 | password_1 | 
      
   Scenario Outline: Verify the Headers for Floater
    Given User enters Username "<username>" and Password "<password>" 
    When User Clicks on Submit button
    Then User verify the title on Dashboard Page 
    Then User Clicks on Production Tracking Icon for Floater
    Then User verify the title on Production Tracking Page
    Then User Clicks on Activity Log Icon for Floater
    Then User verify the title on Activity Log Page 
    Then User Clicks on Notifications Icon for Floater
    Then User verify the title on Notifications Page 
    And User Clicks on Report Icon for Floater
    Then User verify the title on Report Page
    And User Clicks on User Profile button for Floater
    Then User verify the title on User Profile Page 
    
     Examples: 
      | username   | password   | 
      | username_1 | password_1 |
      
    Scenario Outline: Verify the Headers for MaterialHandler
    Given User enters Username "<username>" and Password "<password>"
    When User Clicks on Submit button 
    Then User verify the title on Dashboard Page for MaterialHandler
    Then User Clicks on Activity Log Icon for Maintenance
    Then User verify the title on Activity Log Page for MaterialHandler
    Then User Clicks on Notifications Icon for Maintenance
    Then User verify the title on Notifications Page for MaterialHandler
    And User Clicks on User Profile button for MaterialHandler
    Then User verify the title on User Profile Page 
    
     Examples: 
      | username   | password   | 
      | username_1 | password_1 | 
    
    