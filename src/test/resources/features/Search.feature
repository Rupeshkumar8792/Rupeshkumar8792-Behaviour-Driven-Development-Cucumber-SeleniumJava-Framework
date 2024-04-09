Feature: Search Functionality
 
 Scenario: Verify and Validate the search functionality with valid details
 Given user should navigates to the dashboard page
 When User enter the valid product "HP" into the search bar
 And user clicks on the search Button
 Then user should be able to view the HP product
 
  Scenario: Verify and Validate the search functionality with Invalid details
 Given user should navigates to the dashboard page
 When User enter the valid product "HONDA" into the search bar
 And user clicks on the search Button
 Then user should be able to view the appropriate message
 
  Scenario: Verify and Validate the search functionality without entering any details
 Given user should navigates to the dashboard page
 When User does not enter the any product into the search bar
 And user clicks on the search Button
 Then user should be able to view the appropriate message 