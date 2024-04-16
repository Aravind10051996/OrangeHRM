@OrangeHRM @AdminPage
Feature: Validating Adminpage 

@CreateAdmin @Regression @Smoke 
Scenario Outline: Validati
Given User open url and on login page login  
When User enters valid username and password with file "PropertyFile"
And Clicks on login Button
Then Click on admin in main menu
And Take the count of the admin user before creation 
Then Click on the add admin user button
Then Enter the detials of new admin 
And Click on submit
Then Take the count of the admin user after creation
Then Validate newly created user record
Then Edit the record 
Then Search user - Validate the data