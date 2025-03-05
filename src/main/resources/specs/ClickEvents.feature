#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Click Events

      @tag1
  Scenario: Click Events Animals
    Given I am in page click events
    When I click for the animal
    Then I verify the sound displayed
    
    @tag2
  Scenario: Click Events Animals
    Given I am in page click events
    When I click for the Cat
    Then I verify the sound displayed
    
    @tag3
  Scenario: Click Events Animals
    Given I am in page click events
    When I click for the Dog
    Then I verify the sound displayed
    
    @tag4
  Scenario: Click Events Animals
    Given I am in page click events
    When I click for the Pig
    Then I verify the sound displayed
 
 @ready
Scenario Outline: Click Events Animals Without DDT
    Given I am in page click evens
    When I click for the <animal>
    Then I verify the <sound> displayed
    Examples:
      | animal | sound |
      | cat    | Meow! |
      | dog    | Woof! |
      | pig    | Oink! |
      | cow    | Moo!  |