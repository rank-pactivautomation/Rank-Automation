Feature: LoginAction
  
  Background: Launch the Browser
  Given User launches the Pactiv application 
  
 #
 #Scenario Outline: Verify the No file error message
    #Given User enters Username "<username>" and Password "<password>"
    #When User Clicks on Submit button
    #And User Clicks on expand icon for Line 4 on plant view
    #And User should land to Line View for Line 4
    #And User selects the "<line>" from the Line dropdown in Line View 
    #And User clicks on Upload a Process sheet button
    #And User clicks on Upload New button
    #And User clicks on Upload button
    #And User verify the no file error message
    #And User Clicks on Close button on the popup
     #Then User should logout successfully 
     #
    #Examples:
    #	
     #| username        | password   | line    | 
     #| username_1		 	 | password_1 | line_1  | 
     #| username_2			 | password_2 | line_2  | 
     #| username_3			 |	password_3| line_3  | 
     #| username_4			 |	password_4| line_4  | 
     #| username_5			 |	password_5| line_5  | 
     #| username_6			 |	password_6| line_6  | 
     #| username_7			 |	password_7| line_7  | 
     #| username_8			 |	password_8| line_8  | 
     #| username_9			 |	password_9| line_9  |
     #| username_10		 |	password_10| line_10| 
     #| username_11		 |	password_11| line_11| 

#Scenario Outline: Upload the Process Sheet and verify the incorrect file message
    #Given User enters Username "<username>" and Password "<password>"
    #When User Clicks on Submit button
    #And User Clicks on expand icon for Line 4 on plant view
    #And User should land to Line View for Line 4
    #And User selects the "<line>" from the Line dropdown in Line View 
    #And User clicks on Upload a Process sheet button
    #And User clicks on Upload New button
    #And User clicks on Choose File and selects corresponding "<processSheet>" 
    #And User clicks on Upload button
    #And User verify the incorrect file error message 
    #
    #Examples:
    #	
     #| username        | password   | line    | processSheet |
     #| username_1		 	 | password_1 | line_1  | processSheet_1|
     #| username_2			 | password_2 | line_2  | processSheet_2|
     #| username_3			 |	password_3| line_3  | processSheet_3 |
     #| username_4			 |	password_4| line_4  | processSheet_4 |
     #| username_5			 |	password_5| line_5  | processSheet_5 |
     #| username_6			 |	password_6| line_6  | processSheet_6 |
     #| username_7			 |	password_7| line_7  | processSheet_7 |
     #| username_8			 |	password_8| line_8  | processSheet_8 |
     #| username_9			 |	password_9| line_9  | processSheet_9 |
     #| username_10		 |	password_10| line_10| processSheet_10|
     #| username_11		 |	password_11| line_11| processSheet_11|
     #| username_12		 |	password_12| line_12| processSheet_12|
  
  #Scenario Outline: Upload the Process Sheet
    #Given User enters Username "<username>" and Password "<password>"
    #When User Clicks on Submit button
    #And User Clicks on expand icon for Line 4 on plant view
    #And User should land to Line View for Line 4
    #And User selects the "<line>" from the Line dropdown in Line View 
    #And User clicks on Upload a Process sheet button
    #And User clicks on Upload New button
    #And User clicks on Choose File and selects corresponding "<processSheet>" 
    #And User clicks on Upload button
    #And User verify the message for successfull upload of file
    #And User Clicks on Save button
    #And User Clicks on Ok button
    
    
    #Examples:
    #	
     #| username        | password   | line    | processSheet |
     #| username_1		 	 | password_1 | line_1  | processSheet_1|
     #| username_2			 | password_2 | line_2  | processSheet_2|
     #| username_3			 |	password_3| line_3  | processSheet_3 |
     #| username_4			 |	password_4| line_4  | processSheet_4 |
     #| username_5			 |	password_5| line_5  | processSheet_5 |
     #| username_6			 |	password_6| line_6  | processSheet_6 |
     #| username_7			 |	password_7| line_7  | processSheet_7 |
     #| username_8			 |	password_8| line_8  | processSheet_8 |
     #| username_9			 |	password_9| line_9  | processSheet_9 |
     #| username_10		 |	password_10| line_10| processSheet_10|
     #| username_11		 |	password_11| line_11| processSheet_11|
     #| username_12     |  password_12| line_12| processSheet_12|
  
  #Scenario Outline: Upload the Process Sheet and verify the incorrect file upload message
    #Given User enters Username "<username>" and Password "<password>"
    #When User Clicks on Submit button
    #And User Clicks on expand icon for Line 4 on plant view
    #And User should land to Line View for Line 4
    #And User selects the "<line>" from the Line dropdown in Line View 
    #And User clicks on Upload a Process sheet button
    #And User clicks on Upload New button
    #And User clicks on Choose File and selects corresponding "<processSheet>" 
    #And User clicks on Upload button
    #And User verify the incorrect file upload message
    #Then User should logout successfully
    #
    #
    #Examples:
    #	
     #| username          | password   | line    | processSheet |
     #| username_1		 		 | password_1 | line_1  | processSheet_1|
     #| username_2			 | password_2 | line_2  | processSheet_2|
     #| username_3			 |	password_3| line_3  | processSheet_3 |
     #| username_4			 |	password_4| line_4  | processSheet_4 |
     #| username_5			 |	password_5| line_5  | processSheet_5 |
     #| username_6			 |	password_6| line_6  | processSheet_6 |
     #| username_7			 |	password_7| line_7  | processSheet_7 |
     #| username_8			 |	password_8| line_8  | processSheet_8 |
     #| username_9			 |	password_9| line_9  | processSheet_9 |
     #| username_10			 |	password_10| line_10| processSheet_10|
     #| username_11			 |	password_11| line_11| processSheet_11|
    #
    #Scenario Outline: Upload the Process Sheet and verify the duplicate file message
    #Given User enters Username "<username>" and Password "<password>"
    #When User Clicks on Submit button
    #And User Clicks on expand icon for Line 4 on plant view
    #And User should land to Line View for Line 4
    #And User selects the "<line>" from the Line dropdown in Line View 
    #And User clicks on Upload a Process sheet button
    #And User clicks on Upload New button
    #And User clicks on Choose File and selects corresponding "<processSheet>" 
    #And User clicks on Upload button
    #And User verify the duplicate file error message
   #
    #Examples:
    #	
     #| username          | password   | line    | processSheet |
     #| username_1		 		 | password_1 | line_1  | processSheet_1|
     #| username_2			 | password_2 | line_2  | processSheet_2|
     #| username_3			 |	password_3| line_3  | processSheet_3 |
     #| username_4			 |	password_4| line_4  | processSheet_4 |
     #| username_5			 |	password_5| line_5  | processSheet_5 |
     #| username_6			 |	password_6| line_6  | processSheet_6 |
     #| username_7			 |	password_7| line_7  | processSheet_7 |
     #| username_8			 |	password_8| line_8  | processSheet_8 |
     #| username_9			 |	password_9| line_9  | processSheet_9 |
     #| username_10			 |	password_10| line_10| processSheet_10|
     #| username_11			 |	password_11| line_11| processSheet_11|
  

 Scenario Outline: Upload the Process Sheet after renaming the files
    Given User enters Username "<username>" and Password "<password>"
    When User Clicks on Submit button
    And User Clicks on expand icon for Line 4 on plant view
    And User should land to Line View for Line 4
    And User selects the "<line>" from the Line dropdown in Line View 
    And User clicks on Upload a Process sheet button
    And User clicks on Upload New button
    And User renames the Process Sheet "<processSheet>"  
    And User clicks on Upload button
    And User verify the message for successfull upload of file
    And User Clicks on Save button
    And User Clicks on Ok button
    
    
    Examples:
    	
     | username          | password   | line    | processSheet |
     | username_1		 		 | password_1 | line_1  | processSheet_1|
     #| username_2			 | password_2 | line_2  | processSheet_2|
     #| username_3			 |	password_3| line_3  | processSheet_3 |
     #| username_4			 |	password_4| line_4  | processSheet_4 |
     #| username_5			 |	password_5| line_5  | processSheet_5 |
     #| username_6			 |	password_6| line_6  | processSheet_6 |
     #| username_7			 |	password_7| line_7  | processSheet_7 |
     #| username_8			 |	password_8| line_8  | processSheet_8 |
     #| username_9			 |	password_9| line_9  | processSheet_9 |
     #| username_10			 |	password_10| line_10| processSheet_10|
     #| username_11			 |	password_11| line_11| processSheet_11|
  
#Scenario Outline: Upload the Process Sheet after renaming the Product Name
    #Given User enters Username "<username>" and Password "<password>"
    #When User Clicks on Submit button
    #And User Clicks on expand icon for Line 4 on plant view
    #And User should land to Line View for Line 4
    #And User selects the "<line>" from the Line dropdown in Line View 
    #And User clicks on Upload a Process sheet button
    #And User clicks on Upload New button
    #And User renames the "<product>" in Process Sheet "<processSheet>"  
    #And User clicks on Upload button
    #And User verify the message for successfull upload of file
    #And User Clicks on Save button
    #And User Clicks on Ok button
    #
    #
    #Examples:
    #	
     #| username          | password   | line    | product  |processSheet  |
     #| username_1		 		 | password_1 | line_1  | product_1|processSheet_1| 
     #| username_2			   | password_2 | line_2    | product_2|processSheet_2|
      #| username_3			 |	password_3| line_3  | processSheet_3 |
     #| username_4			 |	password_4| line_4  | processSheet_4 |
     #| username_5			 |	password_5| line_5  | processSheet_5 |
     #| username_6			 |	password_6| line_6  | processSheet_6 |
     #| username_7			 |	password_7| line_7  | processSheet_7 |
     #| username_8			 |	password_8| line_8  | processSheet_8 |
     #| username_9			 |	password_9| line_9  | processSheet_9 |
     #| username_10			 |	password_10| line_10| processSheet_10|
     #| username_11			 |	password_11| line_11| processSheet_11|
     
     