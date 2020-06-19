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
    When user enters employee "Orzu" and "Smith"
    And user deletes employee id
    And user clicks save button
    Then "Orzu Smith" is added successfully

  Scenario Outline: Adding multiple employee
    When user enter employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user click save button
    Then "<FirsName>", "<MiddleName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName |
      | James     | J          | Smith    |
      | Orzu      | O          | Muminov  |
      | Navruz    | N          | Smith    |
      | John      | J          | Terry    |
