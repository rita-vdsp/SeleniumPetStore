
Feature: Pet Store - UserSignIn
  
  Scenario Outline: User SignUp with valid data
    Given I have Selenium using "<browser>" for login
    Given I am at the Pet Store Login page
    When I enter a valid username and password
    And I click on the Login button
    Then I should be redirected to the home page

    Examples: 
      | browser | user  |   
      | chrome  | user2 |
      | firefox | user3 |
