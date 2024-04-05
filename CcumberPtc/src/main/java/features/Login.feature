Feature: Login to Application 

Background: when user launch the browser and enters the vtiger url
Given open the browser
When enter the url
Then Login page should be displayed


@smokeTest
Scenario: Login to vtiger application
#Given when user launch the browser and enters the vtiger url 
When user logining to application with valid username "admin" and valid password "admin" and click on login button
Then homePage should be displayed
And organisations, contacts, products links should be displayed

@regTest
Scenario Outline: login to vtiger with multiple data
#Given when user launch the browser and enters the vtiger url 
When user logining to application with valid username <username> and valid password <password> and click on login button
Then homePage should be displayed
And organisations, contacts, products links should be displayed
Examples:
|username|password|
|admin|manager|
|manager|admin|
|admin|admin|

@sanityTest
Scenario: CreateOrganisation
#Given when user launch the browser and enters the vtiger url
When user logining to application with valid "admin" username and valid "admin" password and click on login button
When user click on Organisations link
When user click on create organisation lookup image
When user enters the organisation name, enter the website name, enter the other email and click on saveBtn
|flipkart|www.flipkart.com|www.flipkart@gmail.com|
When organisation should be created

