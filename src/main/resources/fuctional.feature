Feature: Functional
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks sales header visibility
    And User checks search field visibility
    And User checks cart icon visibility
    And User checks wish list icon visibility
    And User checks 'My account' button visibility
    When User clicks 'My account' button
    Then User checks signIn and join buttons visibility on sign in popup
    And User clicks 'Sign In' button on popup
    And User checks email field visibility
    And User checks password field visibility
    And User checks signIn field visibility
    Then User checks forgot password field visibility
    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |

  Scenario Outline: Check add product to shopping cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks 'Search' button
    And User clicks selected product
    And User clicks on the field with size
    And User clicks size
    When User clicks 'Add to cart' button on product
    And User checks that add to cart popup visibility
    And User checks 'View bag' button visibility
    And User checks 'Checkout' button visibility
    Then User checks that add to cart popup header is '<header>'
    Examples:
      | homePage                    | keyword  | header           |
      | https://www.asos.com/women/ | Dress    | My Bag,1 item    |

  Scenario Outline: Check add product to wish list
    Given User opens '<homePage>' page
    And User checks 'View all' button visibility
    And User clicks 'View all' button
    When User clicks 'Add to wish list' button on the first product
    And User checks that 'Wish list' button visibility
    And User clicks 'Wish list' button
    Then User checks the amount of product in wish list are '<amountOfProducts>'
    Examples:
      | homePage                    | amountOfProducts|
      | https://www.asos.com/women/ | 1               |

  Scenario Outline: Check url content after switching to another category
    Given User opens '<homePage>' page
    And User checks 'Men' button visibility
    When User clicks 'Men' button
    Then User checks that current url contains 'men' query
    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |

  Scenario Outline: Check the language on the page after changing the country
    Given User opens '<homePage>' page
    And User checks 'Change country' button visible
    And User clicks 'Change country' button
    And User clicks selected country
    When User clicks 'Update sittings' button
    Then User checks that language changed
    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |

  Scenario Outline: Check that search results contains search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User clicks 'Search' button
    Then User checks that results contains search word
    Examples:
      | homePage                    | keyword |
      | https://www.asos.com/women/ | Dress   |

  Scenario Outline: Check for an error when entering invalid data on login page
    Given User opens '<homePage>' page
    And User clicks 'My account' button
    Then User checks signIn and join buttons visibility on sign in popup
    And User clicks 'Sign In' button on popup
    And User enter text in email field '<keyword>'
    When User clicks 'Sign in' button
    Then User checks that he cannot log in without data

    Examples:
      | homePage                    | keyword |
      | https://www.asos.com/women/ | aaaa    |

  Scenario Outline:Check for an error when entering invalid data in the search field
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks 'Search' button
    Then User checks for an error message
    Examples:
      | homePage                    | keyword|
      | https://www.asos.com/women/ | !!!!   |


  Scenario Outline: Check for an error when adding a product to the cart without the selected size
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks 'Search' button
    And User clicks selected product
    When User clicks 'Add to cart' button on product
    And User checks that an error has occurred
    Examples:
      | homePage                    | keyword |
      | https://www.asos.com/women/ | Jeans  |

  Scenario Outline: Check for an error message when entering an invalid request in the help page
    Given User opens '<homePage>' page
    And User checks 'Help' button visibility
    And User clicks 'Help' button
    And User checks search for help field visibility
    And User makes search for help by keyword '<keyword>'
    When User clicks search for help button
    And User checks the search error message
    Examples:
      | homePage                   |  keyword|
      | https://www.asos.com/women/|  @@@@   |