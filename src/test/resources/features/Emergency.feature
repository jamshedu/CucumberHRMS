#Author: jamshed1988@yahoo.com
Feature: Emergency Contacts

  Background: 
    Given user login with valid "Admin" and "Hum@nhrm123"
    And user navigate to employee list
    And user search with id and click on "14444"

  @mvn
  Scenario: employee emergency contact details
    And user click on emrgency contacts
    And user click on add button
    And user fill uot emergency contacts "Safar","Friend","333-222-4444","222-333-5555","111-222-3344"
    Then user click on save botton
