
Feature: Hotel Login Functionality
  Scenario: Username Password not entered
    Given User is on login page
    When username password is blank
    Then Display Error Message: 'Please enter Username'
    
    
     Scenario: password is blank
    Given User is on login page
    When username is given but password is blank
    Then Display Error Message: 'Please enter Password'
    
    

   Scenario: Invalid Username password entered
    Given User is on login page
    When Invalid username password is entered
    Then Display alert : 'Invalid Login'
    
    
     Scenario: valid Username password entered
    Given User is on login page
    When  username password is correct entered
    Then Redirect the user to hotelBooking page
    
    
    
    
    