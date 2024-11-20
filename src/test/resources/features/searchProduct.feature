Feature: Search Products

  @OffersPage
  Scenario Outline: Search Experience for product search in both Home and Offers page
    Given user is on GreenCart landing page
    When user search with shortname <Product Name> and extract actual name of product
    Then user search for <Product Name> in Offers page to check if product exist

    Examples:
      | Product Name |
      | Tom          |
      | App          |