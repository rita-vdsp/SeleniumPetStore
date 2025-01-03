
Feature: Pet Store - UserSignUp
  
  Scenario Outline: User SignUp with valid data
    Given I have Selenium using "<browser>"
    Given I am at the Pet Store Register page
    When I enter valid user and account information
    And I click on Save Account
    Then I should be redirected from Register to the home page

    Examples: 
      | browser | user  |   
      | chrome  | user2 |
      | firefox | user3 |
