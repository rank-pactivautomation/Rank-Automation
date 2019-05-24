Feature: LoginAction

  @SmokeCPT
  Scenario Outline: Successful log into CPT application with Valid Credentials as Floater
    Given User launches the "CPT" application
    And User enters Username "<username>" and Password "<password>"
    Then User Clicks on Submit button
    And User verifies the Landing Screen is "PT"
    And User verifies the "Report" is present
    And User verifies the "PT" is present
    And User verifies the "<Plant>" Name
    And User verifies "<LineNo>" lines present in the plant
    And User verifies the plant works in "<Shift>" a day
    And User should logout successfully

    Examples: 
      | username   | password   | Plant   | LineNo | Shift   |
      | username_1 | password_1 | Plant_1 | line_1 | shift_1 |
      | username_2 | password_2 | Plant_2 | line_2 | shift_2 |
      | username_3 | password_3 | Plant_3 | line_3 | shift_3 |
      | username_4 | password_4 | Plant_4 | line_4 | shift_4 |

  @SmokeCPT
  Scenario Outline: Successful log into CPT application with Valid Credentials as Supervisor
    Given User launches the "CPT" application
    And User enters Username "<username>" and Password "<password>"
    Then User Clicks on Submit button
    And User verifies the Landing Screen is "PT"
    And User verifies the "Report" is present
    And User verifies the "PT" is present
    And User verifies the "CT" is present
    And User verifies the "<Plant>" Name
    And User verifies "<LineNo>" lines present in the plant
    And User verifies the plant works in "<Shift>" a day
    And User should logout successfully

    Examples: 
      | username   | password   | Plant   | LineNo | Shift   |
      | username_1 | password_1 | Plant_1 | line_1 | shift_1 |
      | username_2 | password_2 | Plant_2 | line_2 | shift_2 |
      | username_3 | password_3 | Plant_3 | line_3 | shift_3 |
      | username_4 | password_4 | Plant_4 | line_4 | shift_4 |

  @SmokeCPT
  Scenario Outline: Successful log into CPT application with Valid Credentials as Plant Leadership
    Given User launches the "CPT" application
    And User enters Username "<username>" and Password "<password>"
    Then User Clicks on Submit button
    And User verifies the Landing Screen is "PT"
    And User verifies the "PT" is present
    And User verifies the "CT" is present
    And User verifies the "<Plant>" Name
    And User verifies "<LineNo>" lines present in the plant
    And User verifies the plant works in "<Shift>" a day
    And User should logout successfully

    Examples: 
      | username   | password   | Plant   | LineNo | Shift   |
      | username_1 | password_1 | Plant_1 | line_1 | shift_1 |
      | username_2 | password_2 | Plant_2 | line_2 | shift_2 |
      | username_3 | password_3 | Plant_3 | line_3 | shift_3 |
      | username_4 | password_4 | Plant_4 | line_4 | shift_4 |
