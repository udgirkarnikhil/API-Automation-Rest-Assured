Feature: Ecart API Validation

@positive @inquiry @products
Scenario: View all products available 
Given the API "getproducts" is available
When User sends "get" request
Then the response status code should be 200
And the response should display list of products

@negative @inquiry @products
Scenario: View all products available with incorrect request method
Given the API "getproducts" is available
When User sends "post" request
Then the response status code should be 405
And the response message should display

@positive @inquiry @brands
Scenario: View all available brands 
Given the API "getBrands" is available
When User sends "get" request
Then the response status code should be 200
And the response should display list of brands

@negative @inquiry @brands
Scenario: View all products available with incorrect request method
Given the API "getBrands" is available
When User sends "put" request
Then the response status code should be 405
And the response message should display

@positive @searchproduct
Scenario Outline: Search the products with serach key
Given the API "searchProduct" is available
When user sends "post" request with "<search_product>" key
Then the response status code should be 200
And the response should contain list of products for serached key
Examples:
	|search_product|
	|top		   |

@negative @searchproduct
Scenario: Search the products without serach key
Given the API "searchProduct" is available
When user sends "post" request without search_product key
Then the response status code should be 400
And the response message should display

@positive @login
Scenario Outline: To Verify Login with valid details
Given the API "login" is available
When user sends "post" request with "<email>" and "<password>"
Then the response status code should be 200
And the response message should display
Examples:
	|email             |password |
	|udgirkar@gmail.com|Test@123 |

@negative @login
Scenario Outline: To Verify Login without email
Given the API "login" is available
When user sends "post" request with "<email>" and "<password>"
Then the response status code should be 404
And the response message should display
Examples:
	|email             |password |
	|                  |Test@123 |	

@negative @login
Scenario Outline: To Verify Login with valid details
Given the API "login" is available
When user sends "delete" request with "<email>" and "<password>"
Then the response status code should be 405
And the response message should display
Examples:
	|email             |password |
	|udgirkar@gmail.com|Test@123 |

@negative @login
Scenario Outline: To Verify Login with invalid details
Given the API "login" is available
When user sends "post" request with "<email>" and "<password>"
Then the response status code should be 404
And the response message should display
Examples:
	|email             |password  |
	|udgirk@gmail.com  |Test@1123 |
	
@positive @Register
Scenario Outline: To Create/Register User Account
Given the API "registerUser" is available
When user sends "post" request with "<name>","<email>","<password>","<title>","<birth_date>","<birth_month>","<birth_year>","<firstname>","<lastname>","<company>","<address1>","<address2>","<country>","<zipcode>","<state>","<city>","<mobile_number>"
Then the response status code should be 201
And the response message should display
Examples:
	|name |email          |password    |title |birth_date|birth_month|birth_year|firstname|lastname|company|address1|address2|country|zipcode|state|city|mobile_number|
	|uydsg|mvjjbs@mail.com|jhghs@123   |Mrs.  |03        |10         |2000      |gfgfgfgss|hbjhbjhb|office |addr1   |addr2   |India  |345678 |TS   |HYD |9876543210   |

	
@positive @updateUser
Scenario Outline:  To Update User Account
Given the API "updateuser" is available
When user sends "put" request with "<name>","<email>","<password>","<title>","<birth_date>","<birth_month>","<birth_year>","<firstname>","<lastname>","<company>","<address1>","<address2>","<country>","<zipcode>","<state>","<city>","<mobile_number>"
Then the response status code should be 200
And the response message should display
Examples:
	|name |email          |password    |title |birth_date|birth_month|birth_year|firstname|lastname|company|address1|address2|country|zipcode|state|city|mobile_number|
	|uydsg|mvjjbs@mail.com|jhghs@123   |Mrs.  |03        |10         |2000      |gfgfgfgss|hbjhbjhb|office |addr1   |addr2   |India  |345678 |TS   |HYD |9876543210   |


@positive @inquiry
Scenario Outline: To view user account detail by email
Given the API "getUser" is available
When user sends "get" request with "<email>"
Then the response status code should be 200
And the response should display user details
Examples:
	|email           |
	|mvjjbs@mail.com |

@positive @deleteuser
Scenario Outline: To Delete User Account
Given the API "deleteUser" is available
When user sends "delete" request with "<email>" and "<password>"
Then the response status code should be 200
And the response message should display
Examples:
	|email          |password     |
	|mvjjbs@mail.com|jhghs@123    |


