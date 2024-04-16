@OrangeHRM @HomePage
Feature: Validating HomePage

@HomeValidation @Regression @Smoke 
Scenario Outline: Validating  Homepage
Given User open url and on login page login  
When User enters valid username and password with file "PropertyFile"
And Clicks on login Button
When Successful logged in click on profile menu
Then Click on logout

