#Author: James

Feature: Add Employee

Background:
Given user enter "Admin" and "Hum@nhrm123"
And user navigate to addEmployee page 

@smoke
Scenario: Add Employee by first and lastname

And user enter employee "Orzu" and "O" and "Smith"
And user enter save button 
Then user successfully add employee

Scenario: Add Employee without employee id
When user enters employee "John" and "Umarov"
And user deletes employee id 
And user clicks save button
Then "John Umarov" is added successfully
 