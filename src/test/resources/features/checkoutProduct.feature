Feature: Place the order for Products

  @PlaceOrder
  Scenario Outline: Product is successfully checked out
    Given user is on GreenCart landing page
    When user search with shortname <Product Name> and extract actual name of product
    And user adds <Quantity> items to the cart
    And user proceeds to checkout
    Then user can successfully see the <Product Name> in the checked out items
    And user can apply <Promocode>
    And user can place order

    Examples:
      | Product Name | Quantity | Promocode |
      | Tom          | 3        |3          |
