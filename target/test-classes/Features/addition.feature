Feature: Clas Ohlson's cart
  Put 2 item(s) of glue in the cart

  Scenario Outline: Add 2 glue(s) to the Clas Ohlson cart
    Given I have navigated to the item site on Clas Ohlson
    And I have selected <quantity> items to the cart
    When I click on add to the cart
    Then the result should be <quantity> item in the cart
    Examples:
      | quantity |
      | 2        |
      | 4        |



