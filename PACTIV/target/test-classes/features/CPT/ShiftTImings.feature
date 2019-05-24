Feature: LoginAction

  @RegressionCPT
  Scenario Outline: Validate the correct number of shifts and the shift timings in which the plant operates as Floater
    Given User launches the "CPT" application
    And User enters Username "<username>" and Password "<password>"
    Then User Clicks on Submit button
    And User verifies the plant works in "<Shift>" a day
    And User verifies the ShiftTimings "<ShiftTimings>" for the Plant
    And User should logout successfully

    Examples: 
      | username   | password   | Shift   | ShiftTimings   |
      | username_1 | password_1 | shift_1 | ShiftTimings_1 |
      | username_2 | password_2 | shift_2 | ShiftTimings_2 |
      | username_3 | password_3 | shift_3 | ShiftTimings_3 |
      | username_4 | password_4 | shift_4 | ShiftTimings_4 |
