Feature: Validate the login functionality
@auth @validlogin
Scenario Outline:: verify Login with valid credentials
	Given I am having valid "<username>" and "<password>"
	When I send "Post" request for "Login"
 	Then the response status code should be 201
    And the response should contain a JWT token
    Examples:
	|username|password|
	|johnd   |m38rmF$ |

@auth @invalidPassword
Scenario Outline:: verify Login with invalid credentials
	Given I am having valid "<username>" and "<password>"
	When I send "Post" request for "Login"
 	Then the response status code should be 401
    And the response should contain error message
    Examples:
	|username|password   |
	|johnd   |m38r467mF$ |

@auth @Missingusername @negative
Scenario Outline:: verify Login with missing credentials
	Given I am having valid "<username>" and "<password>"
	When I send "Post" request for "Login"
 	Then the response status code should be 400
    And the response should contain error message
    Examples:
	|username|password   |
	|        |m38r467mF$ |

    

