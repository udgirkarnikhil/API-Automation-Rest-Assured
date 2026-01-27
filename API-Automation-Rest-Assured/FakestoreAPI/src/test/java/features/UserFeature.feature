Feature: Validate user details and creating new user

@users @createuser
Scenario Outline:: Creating new user
Given the Fake Store API is available for users
And  User is having valid "<id>" "<username>" "<email>" and "<password>"
When User sends "Post" method with "createUser" API
Then API call is success with status code 201
And id is generated
Examples: 
|id  |username|email           |password |
|3381|Nikhil  |nikhil@gmail.com|nikhil123|

@users @getAll
Scenario: Fetch all users
    Given the Fake Store API is available for users
    When User sends "GET" method with "getusers" API
    Then API call is success with status code 200
    And  Display user details of "<id>"
    Examples:
|id|
|9 |
|8 |
 @users @withid
Scenario Outline:: Fetch user with valid id
    Given the Fake Store API is available for users
    When I send a "GET" request to "getusersbyID" with "<id>"
    Then API call is success with status code 200
    Examples: 
	|id|
	|9 |
    
 @users @withinvalidid @negative
Scenario: Fetch user with valid id
    Given the Fake Store API is available for users
    When I send a "GET" request to "getusersbyID" with "<id>"
    Then API call is success with status code 400
    Examples: 
	|id|
	|ab|    
    





