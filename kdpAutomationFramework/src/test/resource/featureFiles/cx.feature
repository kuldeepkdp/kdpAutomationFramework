@ActiveFeature
Feature: This feature file contain scenario related cx application

  Background: 
    Given user login as 'Super' user

  @dev
  Scenario: Verify that user can Create Generic Case Type
    Then user is now on the 'CxHome' page
    And user clicks on the 'quickMenu' element
    And user clicks on the 'Generic Case' link
    And user clicks on the 'Configuration' link
    And user clicks on the 'Generic Case Types' link
    Then user is now on the 'GenericCaseTypeConfiguration' page
    When user fills out the current form as follows
      | Element     | Type               | Value         | Alias            |
      | companies   | multiSelectDropbox | $companies    |                  |
      | category    | multiSelectDropbox | VZgenCategory       |                  |
      | description | textbox            | RANDOM_STRING | &genericCaseType |
      | entityType  | multiSelectDropbox | Asset       |                  |
    And user clicks on the 'save' link
    And user waits for '2' seconds
    When user fills out the current form as follows
      | Element     | Type               | Value         | Alias            |
      | searchCaseType   | textbox | &genericCaseType    |                  |
    Then user is shown 'header' element containing '&genericCaseType' text
    
 @dev
  Scenario: This scenario will fail
    Then user is now on the 'CxHome' page
    And user clicks on the 'quickMenu' element
    And user clicks on the 'Generic Case' link
    And user clicks on the 'Configuration' link
    And user clicks on the 'Generic Case Types' link
    Then user is now on the 'GenericCaseTypeConfiguration' page
    When user fills out the current form as follows
      | Element     | Type               | Value         | Alias            |
      | companies   | multiSelectDropbox | $companies    |                  |
      | category    | multiSelectDropbox | VZgenCategory       |                  |
      | description | textbox            | RANDOM_STRING | &genericCaseType |
      | entityType  | multiSelectDropbox | Asset       |                  |
    And user clicks on the 'save' link
    And user waits for '2' seconds
    When user fills out the current form as follows
      | Element     | Type               | Value         | Alias            |
      | searchCaseType   | textbox | &genericCaseType    |                  |
    Then user is shown 'header' element containing 'test' text
