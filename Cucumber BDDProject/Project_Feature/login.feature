@endtoend
Feature: login page should allow user to login and add a new user
	As a user
	I want to login into the app
	So that I can see my iner page and add a new user
	
@validlogin
Scenario: user is able to login with valid credentials
  Given the user on login page
	When the user enter valid credentials
	Then user able to add a new user
 