@ActiveFeature
Feature: This feature file contain scenario related cx2 application

  Background: 
    Given user login as 'Super' user

  @dev
  Scenario: Check that Description is mandatory
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
      | entityType  | multiSelectDropbox | Asset       |                  |
    And user clicks on the 'save' link
    And user waits for '2' seconds
    Then user is shown 'DescriptionValidationMessage' element with 'Please enter Description' text
    
  @dev
  Scenario: This is fourth scenario scenario this will fail
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
      | entityType  | multiSelectDropbox | Asset       |                  |
    And user clicks on the 'save' link
    And user waits for '2' seconds
    Then user is shown 'DescriptionValidationMessage' element with 'Please enter Descriptionk' text

