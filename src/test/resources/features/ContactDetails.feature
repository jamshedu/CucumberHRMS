#Author: Dzhamshed Umarov
Feature: Contact Details

  @mvn
  Scenario: employee contacts details credential
    Given user login with valid "Admin" and "Hum@nhrm123"
    And user navigate to employee list
    And user search with id and click on "14444"
    And user click on contacts details
    When user add "3334 Artesia #41","Torrance","California","90504","United States","333-223-2233","319-222-3344","james88@yahoo.com",
    Then user verified
