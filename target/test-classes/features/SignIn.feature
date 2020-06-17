
@sign
Feature: Sign in


  Scenario: Login admin
    Given user enter "Admin" and "Hum@nhrm123"
    When user enter login button
    #And user see "Welcome Admin"
    Then user successfully loged in
    
