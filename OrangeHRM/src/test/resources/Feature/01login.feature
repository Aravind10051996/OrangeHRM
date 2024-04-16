@OrangeHRM @LoginPage
Feature: Login Page Automation of OrangeHRM App

@Login @Regression @Smoke 
Scenario Outline: Check login is successful with valid creds 
Given User open url and on login page login  
When User enters valid username and password with file "PropertyFile"
And Clicks on login Button
Then User should navigate to home page 






