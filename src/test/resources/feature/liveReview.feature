Feature: Check other functionalities of SwagLab Application

  Scenario: Check add to cart function
    When User navigates to login page of swaglabs native application on "local"
    And User logins with valid username and password
    And User clicks on Add To Cart button "local"
    Then Verifies product is added to cart
  @wip
  Scenario: Check privacy policy statement
    When User navigates to login page of swaglabs native application on "local"
    And User logins with valid username and password
    And User scrolls down to "Terms of Service | Privacy Policy" at "local"
    Then User verifies that "Terms of Service | Privacy Policy" visible