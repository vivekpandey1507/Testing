Feature: Testing

Background:
Given Open application in browser

Scenario: Test1
Given User logins with username and password into application
When Order T Shirt
Then Verify in order history

Scenario: Test2
Given User logins with username and password into application
When Update Personal Information First Name in my account
Then Verify information is updated
