
Feature: Pet Store - add product to cart

  Scenario Outline: Make purchase on the website
    Given I have Selenium using "<browser>" to add product
    And I am login into the website
    And I research my product
    And I add a product to my Cart
    Then I should have the product in my cart

    Examples: 
      | browser | user  |   
      | chrome  | user2 |
      | firefox | user3 |
