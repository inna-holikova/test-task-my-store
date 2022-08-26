Feature: Purchase

  Scenario: Check discount applied to the purchase
    Given User is on home page
    When User enters an item into the search bar
    And User clicks on item
    And User checks item price
    And User increases item quantity by one
    And User adds the item to cart
    And User sees the expected item quantity
    And User goes to checkout
    And User sees the expected unit price
    And User clicks Proceed to checkout
    Then User should be on the login page