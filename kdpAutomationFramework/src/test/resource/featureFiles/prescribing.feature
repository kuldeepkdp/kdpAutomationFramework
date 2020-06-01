@ActiveFeature
Feature: This feature file contain scenario related prescribing application

    
  @dev
  Scenario: aaa
    When user navigates to the 'PrescribingHome' page
    And fills out the current form as follows
      | Element  | Type    | Value    | Alias     |
      | surname  | textbox | $surname |           |
      | forename | textbox | Monday   | &forename |
      | postCode | textbox | WA14 1EP | &postCode |
    And user clicks on the 'search' element
    #And user check that processing bar is completed
    And user waits until page is loaded
    #And user waits for 5000 miliseconds
    And user clicks on the 'firstRecordFromSearchResult' element
    Then user is now on the 'Prescribing' page
    And user waits until page is loaded
    #And user waits for 5000 miliseconds
    And user clicks on the 'sensitivitiesAndAllergies' element
    And user waits until page is loaded
    #And user waits for 10000 miliseconds
    And user clicks on the 'recordAllergy' element
    Then user is now on the 'Allergy' page
    And fills out the current form as follows
      | Element     | Type    | Value                             | Alias        |
      | drug        | textbox | &forename                         |              |
      | dateOfOnset | textbox | test date of onset                |              |
      | sourceNotes | textbox | kdp source note for future script | &sourceNotes |
      
  @dev
  Scenario: bbb
    When user navigates to the 'PrescribingHome' page
    And fills out the current form as follows
      | Element  | Type    | Value     | Alias |
      | surname  | textbox | $surname  |       |
      | forename | textbox | &forename |       |
      | postCode | textbox | &postCode |       |
    And user clicks on the 'search' element
    And user waits until page is loaded
    And user clicks on the 'firstRecordFromSearchResult' element
    Then user is now on the 'Prescribing' page
    And user waits until page is loaded
    And user clicks on the 'sensitivitiesAndAllergies' element
    And user waits until page is loaded
    And user clicks on the 'recordAllergy' element
    Then user is now on the 'Allergy' page
    And fills out the current form as follows
      | Element     | Type    | Value              | Alias |
      | drug        | textbox | &forename          |       |
      | dateOfOnset | textbox | test date of onset |       |
      | sourceNotes | textbox | &sourceNotes       |       |