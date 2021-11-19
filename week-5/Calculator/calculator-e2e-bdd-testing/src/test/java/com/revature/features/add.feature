Feature: Add numbers

Scenario: Adding numbers successfully (positive test)
	Given I am at the calculator page
	When I type in the number 10.0 into the left add input
	And I type in the number 20.0 into the right add input
	And I click the add button
	Then I should see an addition result of 30.0

Scenario: Only left input is missing (negative test)
	Given I am at the calculator page
	When I type in the number 34.3 into the right add input
	And I click the add button
	Then I should see an error message in the addition output area of "Left input is missing"
	
Scenario: Only right input is missing (negative test)
	Given I am at the calculator page
	When I type in the number 34.3 into the left add input
	And I click the add button
	Then I should see an error message in the addition output area of "Right input is missing"
	
Scenario: Both inputs are missing (negative test)
	Given I am at the calculator page
	And I click the add button
	Then I should see an error message in the addition output area of "Right input is missing"