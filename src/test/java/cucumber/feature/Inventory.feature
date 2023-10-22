Feature: Inventory Functionality

  Scenario: Ensure Inventory Page Images Loaded Correctly
    Given user is on logged in using standard_user
    When user is on inventory page
    And user can view images correctly

  Scenario: Ensure Inventory Page Images Loaded Incorrectly
    Given user is on logged in using problem_user
    When user is on inventory page
    And user can view images incorrectly
