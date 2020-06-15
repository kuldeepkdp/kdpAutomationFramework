@ActiveFeature
Feature: This feature file contain scenario related prescribing application

  @dev
  Scenario: Verify that user can add allergy
    When user navigates to the 'PrescribingHome' page
    And fills out the current form as follows
      | Element     | Type    | Value           | Alias     |
      | searchUsing | dropbox | Patient Details |           |
      | surname     | textbox | smith           |           |
      | forename    | textbox | Monday          |           |
      | gender      | dropbox | $gender         |           |
      | postCode    | textbox | WA14 1EP        | &postCode |
    And user clicks on the 'Search' button
    And user waits until page is loaded
    Then user is shown a 'searchResults' list which is equal to following list
      | 317 975 3676 | 317 975 3676 | SMITH, Monday | $gender | 19-Aug-1999 | Station House, Altricnham, WA14 1EP |
    And user clicks on the 'firstRecordFromSearchResult' element
    Then user is now on the 'Prescribing' page
    And user waits until page is loaded
    And user navigates to the 'SensitivitiesAndAllergies' page
    And user waits until page is loaded
    Then user is shown 'header' element with 'Sensitivities And Allergies History' text
    And user clicks on the 'Record Allergy' button
    And fills out the current form as follows
      | Element      | Type    | Value                | Alias |
      | drug         | textbox | RANDOM_STRING        | &drug |
      | category     | dropbox | ALLERGIC REACTION    |       |
      | sourceOfInfo | dropbox | Patient              |       |
      | checkedBy    | lookup  | PATEL, Jitendra (Mr) |       |
      | checkedDate  | date    | CURRENT_DATE         |       |
      | sourceNotes  | textbox | &postCode            |       |
    And user clicks on the 'ok' element
    And user waits until page is loaded
    And user clicks on the 'yes' element
    And user waits until page is loaded
    Then user is shown 'sensitivitiesAndAllergiesHistory' table containing following columns
      | Substance | Category | Source of Info | Date of Onset | Checked By | Recorded On | End Date |
    Then user is shown 'sensitivitiesAndAllergiesHistory' table containing following row
      | &drug | ALLERGIC REACTION | Patient | PATEL, Jitendra (Mr)|

  @Active
  Scenario: Verify that user can add allergy
    When user navigates to the 'PrescribingHome' page
    Then user is shown 'header' element containing 'Find a Person' text
    And fills out the current form as follows
      | Element     | Type    | Value           | Alias |
      | searchUsing | dropbox | Patient Details |       |
      | surname     | textbox | smith           |       |
    And user clicks on the 'Search' button
    And user waits until page is loaded
    Then user is shown 'searchResultsTable' table containing following columns
      | NHS Number | External System ID | Name | Gender | Date of Birth | Address |
    Then user is shown 'searchResultsTable' table containing following row
      | 317 975 3676 | 317 975 3676 | SMITH, Monday | $gender | 19-Aug-1999 | Station House, Altricnham, WA14 1EP |
    Then user is shown 'searchResultsTable' element containing following text
      | 317 975 3676 | 317 975 3676 | SMITH, Monday | $gender | 19-Aug-1999 | Station House, Altricnham, WA14 1EP |

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
      | drug        | textbox |                                   |              |
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

  @Active
  Scenario: ccc
    When user navigates to the 'PrescribingHome' page
    And fills out the current form as follows
      | Element  | Type    | Value  | Alias |
      | surname  | textbox | smith  |       |
      | forename | textbox | Monday |       |
    And user clicks on the 'search' element
    And user waits until page is loaded
    Then user is shown a 'searchResults' list which is equal to following list
      | 317 975 3676 | 317 975 3676 | SMITH, Monday | $gender | 19-Aug-1999 | Station House, Altricnham, WA14 1EP |
