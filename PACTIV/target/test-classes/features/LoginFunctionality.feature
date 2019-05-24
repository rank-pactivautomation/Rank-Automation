Feature: LoginAction

  Background: Launch the Browser
    Given User launches the Pactiv application

 @DummyTest1
  Scenario Outline: Successful log into Pactiv application with Valid Credentials
    And User enters Username "<username>" and Password "<password>" 
    Then User Clicks on Submit button
    
    Examples: 
      | username   | password   |
      | username_1 | password_1 |
      | username_2 | password_2 |
      #| username_3 | password_3 |
      #| username_4 | password_4 |
      #| username_5 | password_5 |

  @RegressionTest
  Scenario Outline: User logins to the application with Incorrect Credentials
    Given User enters Username "<username>" and Password "<password>" 
    Then User Clicks on Submit button
    Then User should validate the error message

    Examples: 
      | username    | password    |
      | username_1  | password_1  |
      #| username_2  | password_2  |
      #| username_3  | password_3  |
      #| username_4  | password_4  |
      #| username_5  | password_5  |
      #| username_6  | password_6  |
      #| username_7  | password_7  |
      #| username_8  | password_8  |
      #| username_9  | password_9  |
      #| username_10 | password_10 |
      #| username_11 | password_11 |
      #| username_12 | password_12 |
      #| username_13 | password_13 |
      #| username_14 | password_14 |
      #| username_15 | password_15 |
      #
  #@RegressionTest
  #Scenario Outline: Navigate to Home Page and Logout
    #Given User enters Username "<username>" and Password "<password>"
    #Then User Clicks on Submit button
    #And User is able to navigate to Home Page ane verify the Title
    #Then User should logout successfully
#
    #Examples: 
      #| username   | password   |
      #| username_1 | password_1 |
      #| username_2 | password_2 |
      #| username_3 | password_3 |
      #| username_4 | password_4 |
#
  #@RegressionTest
  #Scenario Outline: Navigate to MaterialHandler Home Page and Logout
    #Given User enters Username "<username>" and Password "<password>"
    #Then User Clicks on Submit button
    #And User is able to navigate to MaterialHandler Home Page and verify the Title
    #Then User should logout successfully
#
    #Examples: 
      #| username   | password   |
      #| username_1 | password_1 |
