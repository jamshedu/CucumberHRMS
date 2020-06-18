$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Employee.feature");
formatter.feature({
  "name": "Add Employee",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add Employee by first and lastname",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter \"Admin\" and \"Hum@nhrm123\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cucumber.steps.Login.user_enter_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to addEmployee page",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.AddEmployeeSteps.user_navigate_to_addEmployee_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter employee \"Orzu\" and \"O\" and \"Smith\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.AddEmployeeSteps.user_enter_employee_and_and(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.AddEmployeeSteps.user_enter_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user successfully add employee",
  "keyword": "Then "
});
formatter.match({
  "location": "com.cucumber.steps.AddEmployeeSteps.user_successfully_add_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Add Employee by first and lastname");
formatter.after({
  "status": "passed"
});
});