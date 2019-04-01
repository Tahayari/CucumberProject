@Login
Feature: TR Login 	
	Scenario: Login with a valid username and pass in TR page
	Given Open browser and access TR page
	And Enter valid username/password
	When Click on Login button
	Then TR Dashboard page is displayed
	
	Scenario: Duplicate Login
	Given Open browser and access TR page
	And Enter valid username/password
	When Click on Login button
	Then TR Dashboard page is displayed