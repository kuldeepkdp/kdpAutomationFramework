@ActiveFeature
Feature: This feature file contain scenario related insightly application

  @Active
  Scenario: user can create new account
   Then user is now on the 'InsightlyLanding' page
   When user clicks on the 'tryCrmFree' element
   Then user is now on the 'InsightlyAccount' page
   And user fills out the current form as follows
      | Element         | Type    | Value                  | Alias |
      | firstName       | textbox    | Kuldeep             | kkk   |
      | lastName        |  textbox     | Kumar             | aaaaa   |
   And user clicks on the 'termsOfService' element
   
      