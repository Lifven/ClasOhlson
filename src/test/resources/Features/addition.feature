Feature: Clas Ohlson's cart
  Put 2 item(s) of glue in the cart

  Scenario: Add 2 glue(s) to the Clas Ohlson cart
    Given I have navigated to the item site on Clas Ohlson
    And I have selected 2 items to the cart
    When I click on add to the cart
    Then the result should be 2 item in the cart




