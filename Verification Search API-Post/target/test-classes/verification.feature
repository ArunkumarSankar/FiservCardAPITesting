Feature: Verification Search - Cards API

  @cardnumber
  Scenario Outline: Search with a valid card number
    Given User have a valid API endpoint
    And User set the request header as "Content-Type" with value "application/json"
    And User set the request body with cardnumber    "<cardNumber>"
    When User send a POST request
    Then The response status code should be 200

    Examples:
      | cardNumber      |
      | 4532015112830366 |


