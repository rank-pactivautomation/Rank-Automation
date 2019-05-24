Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Pactiv application

	@RegressionTest
  Scenario Outline: Verify User is able to submit the report
    Given User enters Username "<username>" and Password "<password>" 
    When User Clicks on Submit button
    And User Clicks on Report Icon for Floater
    Then User verify the title on Report Page
    Then User verify the Line Level Reports Title on Report Page
    Then User verify Review & Submit Button is displayed
    Then User Clicks on Reveiw & Submit Button for first row 
    Then User verify Shift OEE text is displayed
    Then User verify the values for Shift OEE
    Then User verify Cases Produced text is displayed
    Then User verify the values for Cases Produced
    Then User verify Total Downtime text is displayed
    Then User verify the Total Downtime value is displayed
    And User Clicks on User Profile button for Floater
    And User Clicks on Clear Selection
    And User Verify the chosenLines "ChosenLines"
    And User Clicks on Manual Selection for floater
    And User Verify the chosenLines "ChosenLines" after Manual Selection 
    And User Clicks on Report Icon for Floater
    Then User sorts the reports by date filter
    Then User verify the incomplete reports
    
    Examples: 
      | username   | password   |
      | username_1 | password_1 |
