Feature: Bookcart Application test

@cleancart
  Scenario Outline: Add to cart
    Given user Clicks login button with the user "<name>" and "<Password>"
    And user search for "<book>"
    When user clicks add to cart
    Then the cart badge is updated

    Examples: 
      | name     | Password   | book   |
      | jeeva@19 | Ramujee@19 | Slayer |
