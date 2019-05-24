Feature: LoginAction


  @SmokeTest
  Scenario Outline: Successful log into Production Tracking Tool with Valid Credentials
    Given User launches the Production Run Tool
    Then User selects the "<line>" in production tracking tool
    Then User enters the Product Name "<ProductName>" 
    Then User enters the Order Number "<OrderNumber>" 
    Then User enters the Start Date "<Start Date>" 
    Then User enters the End Date "<End Date>" 
    Then User enters the Golden output per hour "<GoldenOutputPerHour>" 
    Then User enters the Standard output per hour "<StandardOutputPerHour>" 
    Then User enters the Total number of cases
    Then User enters the Cases per pallet
    Then User enters the CPM
    Then User enters the Case Weight
    Then User selects the Table Size
    Then User clicks on Confirm button

    Examples: 
      | line   | ProductName  | OrderNumber  |
      | line_1 | ProductName_1| OrderNumber_1|
  