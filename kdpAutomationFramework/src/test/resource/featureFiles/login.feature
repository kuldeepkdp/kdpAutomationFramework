@ActiveFeature
Feature: Login  feature

  @Active
  Scenario: Check that user can login successfully on passing valid login credentials
    When user navigates to the 'Login' page
    And user sets the 'userName' field as 'civica'
    And user sets the 'password' field as 'Spr!ng17'
    And user clicks on the 'Login' button
    And user is now on the 'Home' page
    And user clicks on the 'newCase' element
    And user select 'Visit' from dropbox 'caseType'
    And user clicks on the 'Next' button
    And user is now on the 'VisitCase' page
    And fills out the current form as follows
      | Element         | Type    | Value                  | Alias |
      | companies       | dropbox | Civica Housing         | abc   |
      | visitType       | dropbox | Visit03                |       |
      | targetVisitDate | date    | Thu, Feb 06 2020       |       |
      | notes           | textbox | this is automated test |       |
    And user clicks on the 'Next' button
    Then user is shown 'createVisitCasePopup' element with 'Create Visit Case - Select Entity' text
