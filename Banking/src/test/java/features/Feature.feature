Feature: To verify Banking Application

Scenario: Verify Login with valid credentials and generate authorization Token code
Given User has given valid username and Password
When  User calls login api with "post" method
Then  verify status code id 200 
And  User is having "Authorization" Token

Scenario: Get users accounts list
Given User is having "Authorization" Token
When User calls "Accountlist" api with "Get" method
Then verify status code id 200 
And User is having list of accounts 

Scenario: Verify the account balaance
Given User is having list of accounts and "Authorization" Token 
When User calls AccountBalance api with "Get" method
Then verify status code id 200 
And verify account balance displayed

Scenario: Verify account statement for a user account
Given User is having list of accounts and "Authorization" Token
When User calls AccountStatement api with "Get" method
Then verify status code id 200
And account statement is displayed with recent 10 transactions

Scenario: Verify account statement for specific date range
Given User is having list of accounts and "Authorization" Token
When User calls AccountStatement api with "post" method
Then verify status code id 200
And verify AccountStatement is displayed for specific data range

Scenario: Verify successful funds transfer between 2 accounts
Given User is having list of accounts and "Authorization" Token
When User calls funds transfer api with "post" method
Then verify status code id 200
And verify successful funds transfer message displayed


Scenario: Verify user submits feedback
Given User enters all mandatory details and "Authorization" Token
When User calls feedback api with "post" method
Then verify status code id 200
And view the Feedback details

Scenario: Verify new user addition
Given User adds all required details and "Authorization" Token
When  User calls AddUser api with "post" method
Then verify status code id 200
And verify user added all required details

Scenario: Verify user logout function
Given User is having "Authorization" Token
When User call logout api with "post" method
Then verify status code id 200
And verify user logout message is displayed
 










