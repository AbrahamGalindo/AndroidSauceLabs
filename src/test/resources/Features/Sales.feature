Feature: sales

  @all @buyOneProduct
  Scenario: Complete buy one random product
    Given Open application on android device
    And Login on the app as "Standard"
    Then Validate products module
    And Add to cart some random product
    Then Validate the product was added to cart
    And Go to cart
    Then Validate your cart module
    And Checkout the cart
    And Enter the checkout information
    And Finish the buy
    Then Validate the order was created
    Then Finish test

  @all @backToProducts
  Scenario: Complete buy a random product and validate back to products
    Given Open application on android device
    And Login on the app as "Standard"
    Then Validate products module
    And Add to cart some random product
    Then Validate the product was added to cart
    And Go to cart
    Then Validate your cart module
    And Checkout the cart
    And Enter the checkout information
    And Finish the buy
    Then Validate the order was created
    And Back to home
    Then Validate products module
    Then Finish test

  @all @invalidUser
  Scenario: Validate try to login with invalid user
    Given Open application on android device
    And Login on the app as "Locked"
    Then Validate the user is locked
    Then Finish test