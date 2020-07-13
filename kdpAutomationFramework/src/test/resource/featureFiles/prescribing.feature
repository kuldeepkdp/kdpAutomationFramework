@ActiveFeature
Feature: This feature file contain scenario related prescribing application

  @Active
  Scenario: Verify that user can add allergy
    When user navigates to the 'PrescribingHome' page
    And user waits for '2' seconds
    And user fills out the current form as follows
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
    And user fills out the current form as follows
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
      | &drug | ALLERGIC REACTION | Patient | PATEL, Jitendra (Mr) |

  @Active
  Scenario: Verify that user can add allergy
    When user navigates to the 'PrescribingHome' page
    Then user is shown 'header' element containing 'Find a Person' text
    Then user is shown 'findAPerson' form containing following fields
      | field1       | field2 | field3  | field4   | field5    | field6        |
      | Search Using | Gender | Surname | Forename | Post Code | Date of Birth |
    Then user is shown 'findAPerson' element containing following text
      | text1        | text2  | text3   | text3    | text5     | text6         |
      | Search Using | Gender | Surname | Forename | Post Code | Date of Birth |
    And user fills out the current form as follows
      | Element     | Type    | Value           | Alias |
      | searchUsing | dropbox | Patient Details |       |
      | surname     | textbox | smith           |       |
      | forename    | textbox | Monday          |       |
    Then user is shown a 'search' element which is enabled
    And user clicks on the 'Search' button
    And user waits until page is loaded
    Then user is shown 'searchResultsTable' table containing following columns
      | NHS Number | External System ID | Name | Gender | Date of Birth | Address |
    Then user is shown 'searchResultsTable' table containing following row
      | 317 975 3676 | 317 975 3676 | SMITH, Monday | $gender | 19-Aug-1999 | Station House, Altricnham, WA14 1EP |
    And user clicks on the 'firstRecordFromSearchResult' element
    And user waits until page is loaded
    Then user is now on the 'Prescribing' page
    When user stores 'born' element text with alias '&born' for future reference
    And user waits until page is loaded
    And user clicks on the 'Sensitivities & Allergies' link
    #And user navigates to the 'SensitivitiesAndAllergies' page
    Then user is now on the 'SensitivitiesAndAllergies' page
    And user waits until page is loaded
    Then user is shown 'header' element with 'Sensitivities And Allergies History' text
    And user clicks on the 'Record Allergy' button
    And user fills out the current form as follows
      | Element      | Type    | Value                | Alias |
      | drug         | textbox | RANDOM_STRING        | &drug |
      | category     | dropbox | ALLERGIC REACTION    |       |
      | sourceOfInfo | dropbox | Patient              |       |
      | checkedBy    | lookup  | PATEL, Jitendra (Mr) |       |
      | checkedDate  | date    | CURRENT_DATE         |       |
      | sourceNotes  | textbox | &born                |       |
    And user clicks on the 'OK' button
    And user waits until page is loaded
    And user clicks on the 'Yes' button
    And user waits until page is loaded
    Then user is shown 'sensitivitiesAndAllergiesHistory' table containing following columns
      | Substance | Category | Source of Info | Date of Onset | Checked By | Recorded On | End Date |
    Then user is shown 'sensitivitiesAndAllergiesHistory' table containing following row
      | &drug | ALLERGIC REACTION | Patient | PATEL, Jitendra (Mr) |

  @Active
  Scenario: aaa
    When user navigates to the 'PrescribingHome' page
    And user fills out the current form as follows
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
    And user fills out the current form as follows
      | Element     | Type    | Value                             | Alias        |
      | drug        | textbox |                                   |              |
      | dateOfOnset | textbox | test date of onset                |              |
      | sourceNotes | textbox | kdp source note for future script | &sourceNotes |

  @Active
  Scenario: bbb
    When user navigates to the 'PrescribingHome' page
    And user fills out the current form as follows
      | Element  | Type    | Value     | Alias |
      | surname  | textbox | $surname  |       |
      | forename | textbox | &forename |       |
      | postCode | textbox | &postCode |       |
    Then user is shown a 'search' element which is enabled
    And user clicks on the 'search' element
    And user waits until page is loaded
    And user clicks on the 'firstRecordFromSearchResult' element
    Then user is now on the 'Prescribing' page
    And user waits until page is loaded
    And user clicks on the 'sensitivitiesAndAllergies' element
    And user waits until page is loaded
    And user clicks on the 'recordAllergy' element
    Then user is now on the 'Allergy' page
    And user fills out the current form as follows
      | Element     | Type    | Value              | Alias |
      | drug        | textbox | &forename          |       |
      | dateOfOnset | textbox | test date of onset |       |
      | sourceNotes | textbox | &sourceNotes       |       |

  @Active
  Scenario: ccc
    When user navigates to the 'PrescribingHome' page
    And user fills out the current form as follows
      | Element  | Type    | Value  | Alias |
      | surname  | textbox | smith  |       |
      | forename | textbox | Monday |       |
    And user clicks on the 'search' element
    And user waits until page is loaded
    Then user is shown a 'searchResults' list which is equal to following list
      | 317 975 3676 | 317 975 3676 | SMITH, Monday | $gender | 19-Aug-1999 | Station House, Altricnham, WA14 1EP |
