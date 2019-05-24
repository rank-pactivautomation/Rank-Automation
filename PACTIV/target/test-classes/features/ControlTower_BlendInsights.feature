Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Pactiv application

  Scenario Outline: Verify the data on Control Tower Page
  Given User enters Username "<username>" and Password "<password>" 
  When User Clicks on Submit button
  Then User Clicks on Control Tower Icon
  Then User selects the shift filter
  Then User verify the Blend Insights header in Column One
  Then User verify the Blend Insights header in Column Three
  Then User Clicks on Dropdown Icon in Column One
  Then User selects the dropdown value
  Then User selects the dropdown value in Column Two
  Then User selects the second dropdown value in Column Two
  
  
  Examples:
  
  | username         | password   | line    |
  | username_1		 	 | password_1 | line_1  |
  | username_2			 | password_2 | line_2  |
  
  Scenario Outline: Verify the data on Control Tower Page for ProductionInsights
  Given User enters Username "<username>" and Password "<password>" 
  When User Clicks on Submit button
  Then User Clicks on Control Tower Icon
  Then User selects the shift filter
  Then User Clicks on Production Insights in Column Three
  Then User Clicks on Dropdown Icon in Column One
  Then user selects the dropdown value in Column One
  
  
  Examples:
  
  | username         | password   | line    |
  | username_1		 	 | password_1 | line_1  |
  | username_2			 | password_2 | line_2  |
  
  @RegressionTest
  Scenario Outline: Verify the data on Line Assignment Page
    Given User enters Username "<username>" and Password "<password>" 
    When User Clicks on Submit button
    Then User Clicks on Control Tower Icon
    Then User Clicks on Line Assignment button
    Then User selects the floater to assign all lines
    Then User verify all lines are assigned
    Then User Clicks on Clear All
    Then User Clicks on Few lines
    Then User verify few lines are assigned

    Examples: 
      | username   | password   | line   |
      | username_1 | password_1 | line_1 |
      | username_2			 | password_2 | line_2  |
