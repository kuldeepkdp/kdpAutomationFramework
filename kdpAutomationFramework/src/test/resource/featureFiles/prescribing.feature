@ActiveFeature
Feature: This feature file contain scenario related prescribing application

  @Active
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

  @Active
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

  @dev
  Scenario: ccc
    When user navigates to the 'PrescribingHome' page
    And fills out the current form as follows
      | Element  | Type    | Value  | Alias |
      | surname  | textbox | smith  |       |
      | forename | textbox | Monday |       |
    And user clicks on the 'search' element
    And user waits until page is loaded
    Then user is shown a 'searchResults' list which is equal to following list
      | 317 975 3676 | 317 975 3676 |SMITH, Monday | $gender    | 19-Aug-1999 | Station House, Altricnham, WA14 1EP |
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
