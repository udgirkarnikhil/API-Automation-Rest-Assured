Feature: Validate Cart functionality

  @cart @getById
  Scenario: Fetch valid cart
    Given the Fake Store API is available
    When I send a GET request to "/carts/5"
    Then the response status code should be 200

  @cart @negative @invalidId
  Scenario: Fetch cart with invalid ID
    Given the Fake Store API is available
    When I send a GET request to "/carts/9999"
    Then the response status code should be 404

  @cart @create
  Scenario: Create cart with valid data
    Given the Fake Store API is available
    And I have a valid cart payload
    When I send a POST request to "/carts"
    Then the response status code should be 200

  @cart @negative @missingFields
  Scenario: Create cart with missing required fields
    Given the Fake Store API is available
    And I have a cart payload missing required fields
    When I send a POST request to "/carts"
    Then the response status code should be 400
