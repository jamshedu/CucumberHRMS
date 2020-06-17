$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ContactDetails.feature");
formatter.feature({
  "name": "Contact Details",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "employee contacts details credential",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@mvn"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user login with valid \"Admin\" and \"Hum@nhrm123\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_login_with_valid_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to employee list",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_navigate_to_employee_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search with id and click on \"14444\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_search_with_id_and_click_on(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on contacts details",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_click_on_contacts_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user add \"3334 Artesia #41\",\"Torrance\",\"California\",\"90504\",\"United States\",\"333-223-2233\",\"319-222-3344\",\"james88@yahoo.com\",",
  "keyword": "When "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_add(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verified",
  "keyword": "Then "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_verified()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "employee contacts details credential");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/Emergency.feature");
formatter.feature({
  "name": "Emergency Contacts",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user login with valid \"Admin\" and \"Hum@nhrm123\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_login_with_valid_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to employee list",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_navigate_to_employee_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search with id and click on \"14444\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.ContactDetailsSteps.user_search_with_id_and_click_on(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "employee emergency contact details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@mvn"
    }
  ]
});
formatter.step({
  "name": "user click on emrgency contacts",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.EmargencyContactsSteps.user_click_on_emrgency_contacts()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on add button",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.EmargencyContactsSteps.user_click_on_add_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user fill uot emergency contacts \"Safar\",\"Friend\",\"333-222-4444\",\"222-333-5555\",\"111-222-3344\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumber.steps.EmargencyContactsSteps.user_fill_uot_emergency_contacts(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on save botton",
  "keyword": "Then "
});
formatter.match({
  "location": "com.cucumber.steps.EmargencyContactsSteps.user_click_on_save_botton()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "employee emergency contact details");
formatter.after({
  "status": "passed"
});
});