Feature: Login

Scenario: Invalid password, valid username (nagative test)
	Given I am at the login page
	When I type in a username of "bach_tran"
	But I type in a password of "wrongpassword"
	And I click the login button
	Then i should see a message of "Incorrect username and/or password"

Scenario: Invalid password, Invalid username (nagative test)
	Given I am at the login page
	When I type in a username of "wrongUsername"
	And I type in a password of "wrongpassword"
	And I click the login button
	Then i should see a message of "Incorrect username and/or password"

Scenario: valid password, Invalid username (nagative test)
	Given I am at the login page
	When I type in a username of "wrongUsername"
	And I type in a password of "password3"
	And I click the login button
	Then i should see a message of "Incorrect username and/or password"
	
Scenario Outline: Successful associate login
	Given I am at the login page
	When I type in a username of <username>
	And I type in a password of <password>
	And I click the login button
	Then I should be redirected to the associate homepage
	
	Examples:
	| username | password |
	| "JaneD" | "password1" |
	| "JDoe" | "password2" |
	| "bach_tran" | "password3" |
	
Scenario Outline: Successful trainer login
	Given I am at the login page
	When I type in a username of <username>
	And I type in a password of <password>
	And I click the login button
	Then I should be redirected to the trainer homepage
	