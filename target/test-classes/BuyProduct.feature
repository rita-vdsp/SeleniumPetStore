
Feature: Pet Store - buyProduct

  Scenario Outline: Make purchase on the website
    Given I have Selenium using "<browser>" to buy product
    And I am login in
    And I buy a product
    Then I should see an order confirmation

    Examples: 
      | browser | user  |   
      | chrome  | user2 |
      | firefox | user3 |
