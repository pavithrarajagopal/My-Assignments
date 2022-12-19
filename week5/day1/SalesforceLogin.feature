Feature: To create contact in Salesforce Application

Background:
Given Launch browser and  Salesforce Url and Login

Scenario Outline:
When Click on toggle menu button from the left corner
And Click view All and click Sales from Application Launcher
And Click on Accounts tab
And Click on New button
And Enter account name <name>
And Select Public
And click save
Then verify message

Examples:
|name|
|'pavithra'|	
|'Devi'|