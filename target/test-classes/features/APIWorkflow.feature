@workflow
Feature: Syntax HRMS API End to End Workflow
  
  Description: This feature tests and verifies Syntax HRMS Web Services 
  The workflow consists of the following sequential calls

  Background: 
    Given a JWT is generated

  Scenario: Creating an employee
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee is created and response contains key "Message" and value "Entry Created"
    And the employee ID "Employee[0].employee_id" is stored as a global variable to be used for other calls

  Scenario: Retrieving created employee
    Given a request is prepared to retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for retrieving the created employee is 200
    And the retrieved employee ID at "employee[0].employee_id" matches the globally stored employee ID
    And the retrieved data at "employee" matches the data used created an employee "employee[0].employee_id"
      | emp_firstname   | emp_middle_name  | emp_lastname   | emp_birthday | emp_gender | emp_job_title   | emp_status |
      | syntaxFirstName | syntaxMiddleName | syntaxLastName | 2000-07-11   | Female     | Cloud Architect | Employee   |

      
      
      #Scenario: Get all employee from database
      #Given a request is prepared to retrieve all the employees
      #When a Get call is made to retrieve all the employees
      #And a rertrieved employees ID match 