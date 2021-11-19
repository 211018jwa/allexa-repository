Feature: Multiply numbers

Scenario: Multiply numbers successfully (positive test)
	Given I am at the calculator page
	When I type in the number 10.0 into the left add input
	When I type in the number 20.0 into the right add input
	And I click the multiply button
	Then I should see a multiplication result of 30.0
	
Scenario: Only left input missing (negative test)
	Given I am at the calculator page
	When I type in the number 34.3 into the right add input
	And I click the multiply button
	Then I should see an error message in the multiplication output area of "Left input is missing"

Scenario: Only right input missing (negative test)
	Given I am at the calculator page
	When I type in the number 7.5 into the left add input
	And I click the multiply button
	Then I should see an error message in the multiplication output area of "Right input is missing"
	
Scenario: Both inputs missing (negative test)
	Given I am at the calculator page
	And I click the multiply button
	Then I should see an error message in the multiplication output area of "Both inputs are missing"