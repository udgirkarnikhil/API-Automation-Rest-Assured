Feature: End to end library APi's verification

Scenario: Verify addition of book details into the library 
Given valid payload related to add book
When client calls "AddBook" API with "post" method 
Then successful status code 200 displayed
And verify ID is generated

Scenario: Deletion of book details from library
Given valid payload related to delete book
When client calls "DeleteBook" API with "delete" method
Then successful status code 200 displayed
And verify book deletion message is displayed

