Feature: Verification Search - Cards API

<<<<<<< Updated upstream
=======
  Background:
    Given User have a valid API endpoint
    And User set the request header as "Content-Type" with value "application/json"

>>>>>>> Stashed changes
  @cardnumber
  Scenario Outline: Search with a valid card number
    Given User have a valid API endpoint
    And User set the request header as "Content-Type" with value "application/json"
    And User set the request body with cardnumber    "<cardNumber>"
    When User send a POST request
    Then The response status code should be 200

    Examples:
<<<<<<< Updated upstream
      | cardNumber      |
      | 4532015112830366 |
=======

      | cardNumber          | statusCode |
      |   4532015112830366   | 200        |


  @nontranstoken
  Scenario Outline: Search with a valid Non-Trans Token (NTT)

      And User set the request body with NonTransToken  "<nonTransToken>"
      When User send a POST request
      Then The response status code should be <statusCode>

    Examples:

      | nonTransToken       | statusCode |
      | a1b2c3d4e5f6g7h8     | 200        |


@cardnumberError
  Scenario Outline: Validation Error - Min value for card number

    And User set the request body with cardnumber  "<cardNumber>"
    When User send a POST request
    Then The response status code should be <statusCode>

    Examples:

      | cardNumber | statusCode |
      | 12         | 400        |

@nttError
  Scenario Outline: Validation Error - Missing  NTT

    And User set the request body with NonTransToken  "<nonTransToken>"
    When User send a POST request
    Then The response status code should be <statusCode>

    Examples:
      | nonTransToken       | statusCode |
      |                     | 400        |

@idnotfound
  Scenario Outline: Max value for card number Error - ID Not Found

    And User set the request body with cardnumber  "<cardNumber>"
    When User send a POST request
    Then The response status code should be <statusCode>

    Examples:

      | cardNumber           | statusCode |
      | 1234567890987654111  | 404        |


@notallowed
  Scenario Outline: Error - Method Not Allowed

   When  User send a GET request
    Then The response status code should be <statusCode>

    Examples:

       | statusCode |
       | 405        |

@internalservererror
  Scenario Outline: Error - Internal Server Error

    And User set an empty request body
    When User send a POST request
    Then The response status code should be <statusCode>

    Examples:

     |  statusCode |
     | 500         |


>>>>>>> Stashed changes


