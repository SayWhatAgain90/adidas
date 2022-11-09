Feature: Customer navigation through product categories and purchase

  @wip
  Scenario: Verification of purchase amount
    Given user is on the "Home" page
    When user navigates to "Laptops" section, adds "Sony vaio i5" to the cart and accepts pop up confirmation
    And user is on the "Home" page
    And user navigates to "Laptops" section, adds "Dell i7 8gb" to the cart and accepts pop up confirmation
    And user navigates to "Cart" and deletes "Dell i7 8gb" from cart
    And user clicks on "Place order"
    Then user fill in all web form fields and clicks on "Purchase"
    And user sees purchase amount 790 and clicks Ok