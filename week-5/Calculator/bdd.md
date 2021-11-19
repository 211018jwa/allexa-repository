# Behavior Driven Development

BDD, or Behavior Driven Development, is an approach to developing software where we utilize "ubiquitous" language to bridge the gap between business and development teams.

Developers will implement features according to the point of view of non-technical stakeholders.

BDD is a superset of TDD (meaning, TDD is part of BDD)
- BDD takes this TDD concept further by more effectively encouraging communication between all parties such that everyone has a strong shared understanding of an application's behavior and not only the development and QA teams

# Steps of Developing Features
1. The Product Owner and Business Analysts (BAs) and other stakeholders will document expected behaviors in plain language ("English-like" syntax) ("Ubiquitous language")
2. Developers/testers write tests to validate the behaviors described
3. Developers then write code to pass the test

Note how steps 2 and 3 are traditional TDD. The first step is really where BDD makes its entrance into a development strategy.

# BDD Benefits
- Encourages documentation that is understandable to both technical and non-technical team members. BDD is commonly referred to as "living documentation" because it evolves with the software itself
- Emphasizes effective communication between non-technical and technical members
- BDD allows us to generate test cases very easily from the provided "scenarios"

# Implementing BDD
Behavior-driven development has become such an integral part of the Agile development process to the point where there are many dedicated BDD tools such as Cucumber.

Implementing BDD with Cucumber is easy since Cucumber follows a standard BDD formula. Cucumber utilizes a high-level language known as Gherkin, which allows BAs/Product Owners to create feature-files. The general workflow works as follows:
1. BAs/Product Owners first write feature files in Gherkin. The feature files define the various scenarios and steps that define a system's behavior
2. The feature file should be executed to generate "glue-code"
3. Once the glue-code has been generated, tests are implemented within the glue-code file
4. Application code is written to pass the tests
5. Once the tests pass, we can determine whether or not the feature is complete through our **definition of done**

# Gherkin
Gherkin is a business-readable, domain specific language that helps us to describe the behaviors of our software. We structure behaviors/features in the form of "scenarios", and write tests around these intended behaviors.

Gherkin is written within "feature files", which we can execute and generate "glue code". The glue code files are where we actually implement the tests. Glue code is called "glue code" because it is tightly coupled with the feature file scenarios themselves (specifically, the individual steps for each scenario)

# Scenarios
Scenarios contain steps that are equivalent to test steps. Scenario steps are described through the following keywords (which are case sensitive):
- Given
- When
- But
- And
- Then

Typically, at its core, we should be following Given... When... Then...

The `But` and `And` keywords are to add additional information beyond the Given, When, Then steps

```gherkin
Feature: Add Numbers

Scenario: Successful addition of numbers (positive test)
    Given That I am at the calculator page
    When I type in 10
    And I type in 25
    And I click add
    Then I should see the result of 35

Scenario: First number input blank, second non-blank
    Given That I am at the calculator page
    When I do I not type in anything in the first input for a number
    But I do type in 20 for the second input
    And I click add
    Then I should see a message that says "No number found for first input"
```

# Terminologies
- Feature file: A file with a `.feature` extension that contains Gherkin syntax in the form of different scenarios
- Glue code: Actual Java implementations for test steps based around those scenarios
    - Step Definition: the actual automation steps / test steps
- Test runner: a class that is "binded" to the testing framework (such as JUnit 5 aka "Jupiter") that will contain the configuration on where to find the feature files and glue-code. It will then treat the scenarios as individual tests and execute the steps in the scenarios that correspond to those particular scenarios/tests
    - Each scenario is treated as a single test by the Test Runner
        - Each step is a single method within our glue-code
        - So instead of "1 method, 1 test" like is typically the usual case for non Cucumber related tests, here it is "1 scenario, 1 test" because of the Test Runner

# Cucumber Parameterization
There are essentially 3 different forms of parameterization that we can use. What is meant by parameterization is the passing of data from the feature files over to the steps/methods in the glue-code. This allows us to clearly define parameters that are visible from the perspective of Gherkin itself, and couple it with our actual tests.

The 3 different forms of parameterization
1. The ability to pass parameters "inline"
2. The ability to pass parameters in a table
3. The ability to define a "scenario outline" that will run multiple times for each "row" of data
    - x rows, x times the scenario will run