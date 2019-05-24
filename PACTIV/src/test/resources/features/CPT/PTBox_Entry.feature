Feature: LoginAction

  @SmokeCPT
  Scenario Outline: Successful log into CPT application as Floater And Verify PT Hour Box Entry
    Given User launches the "CPT" application
    And User enters Username "<username>" and Password "<password>"
    Then User Clicks on Submit button
    And User verifies the Landing Screen is "PT"
    When User clicks on the "PENDING PT HOUR BOX" in Production Tracking screen
    And User enters Actual cases as "GOLDEN"
    And User clicks on the "SAVE" in Production Tracking screen
    Then User verifies the "PENDING PT HOUR BOX" is present
    When User clicks on the "PENDING PT HOUR BOX" in Production Tracking screen
    And User enters Actual cases as "LESS THAN GOLDEN"
    And User clicks on Add Scrapping Button
    And User enters Scrapping Details as "TEST1234"
    And User selects Downntime Reasons for "LEVEL 1"
    And User selects Downntime Reasons for "LEVEL 2"
    And User selects Downntime Reasons for "LEVEL 3"
    And User clicks on the "SAVE" in Production Tracking screen
    Then User should logout successfully

    Examples: 
      | username   | password   |
      | username_1 | password_1 |
      | username_2 | password_2 |
      | username_3 | password_3 |
      | username_4 | password_4 |

  @SmokeCPT
  Scenario Outline: Successful log into CPT application as Supervisor And Verify PT Hour Box Entry
    Given User launches the "CPT" application
    And User enters Username "<username>" and Password "<password>"
    Then User Clicks on Submit button
    And User verifies the Landing Screen is "PT"
    And User verifies the "PENDING PT HOUR BOX" is present
    And User clicks on the "PENDING PT HOUR BOX" in Production Tracking screen
    And User enters Actual cases as "LESS THAN GOLDEN"
    And User clicks on Add Scrapping Button
    And User enters Scrapping Details as "TEST1234"
    And User selects Downntime Reasons for "LEVEL 1"
    And User selects Downntime Reasons for "LEVEL 2"
    And User selects Downntime Reasons for "LEVEL 3"
    And User clicks on the "SAVE" in Production Tracking screen
    Then User should logout successfully

    Examples: 
      | username   | password   |
      | username_1 | password_1 |
      | username_2 | password_2 |
      | username_3 | password_3 |
      | username_4 | password_4 |
