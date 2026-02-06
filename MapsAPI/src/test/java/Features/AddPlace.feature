Feature: Validating AddPlaceAPI's

@Addplace @regression 
Scenario Outline: Verify if place is been successfully added
	Given Add place payload with "<name>" "<address>" "<website>"
	When user calls "Addplace" APi with "Post" http request
	Then Place to be added successfully with status code 200 
	And "status" in the response should be "OK"
	And "scope" in the response should be "APP"
	And Verify ID generated maps with "<name>" with "Getplace"
	Examples:
	|name    |address       |website            |
	|Pranithi|8433 southside|http://pranithi.com |
	# |Nikhil  |8433 southside|http://nikhil.com   |
	
	
	
	
@UpdatePlace
Scenario: verify the update place functionality 
	Given Update place payload
	When user calls "Updateplace" APi with "Put" http request
	Then Place to be added successfully with status code 200 
	
	

@Deleteplace @regression 
Scenario: Verify the delete place functionality is working
	Given Delete place payload 
	When  user calls "Deleteplace" APi with "Post" http request
	Then  Place to be added successfully with status code 200 
	

