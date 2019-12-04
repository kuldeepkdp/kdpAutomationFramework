@ActiveFeature
Feature: Login  feature


  @dev
  Scenario: Check that user can login successfully on passing valid login credentials
  When user navigates to the Login page
  And user sets the userName field as civica
  And user sets the password field as C!v!ca2
  And user clicks on the Login button
  And user is now on the Home page
  #And user waits until the newCase element is clickable
  #And user clicks on the New Case button
  And user clicks on the newCase element
  
  


  
  
