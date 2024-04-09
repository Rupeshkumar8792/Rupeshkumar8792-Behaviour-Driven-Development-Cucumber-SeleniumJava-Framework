Feature: Login Functionality

Scenario: Verify and Validate the login functionality with valid credentials
Given user should navigate to the login page
When user enters valid email address "rupesh.surya62@gmail.com"
And user enters valid password "test@1234"
And user clicks on login button
Then user should able to log into the app successfully

Scenario: Verify and Validate the login functionality with invalid credentials
Given user should navigate to the login page
When user enters invalid email address "rupesh.surya6212@gmail.com"
And user enters invalid password "test@123412"
And user clicks on login button
Then user should able to view appropriate error message

Scenario: Verify and Validate the login functionality with valid email and invalid password
Given user should navigate to the login page
When user enters valid email address "rupesh.surya62@gmail.com"
And user enters invalid password "test@123412"
And user clicks on login button
Then user should able to view appropriate error message

Scenario: Verify and Validate the login functionality with invalid email and valid password
Given user should navigate to the login page
When user enters valid email address "rupesh.surya62@gmail.com"
And user enters valid password "test@1234"
And user clicks on login button
Then user should able to view appropriate error message

Scenario: Verify and Validate the login functionality without entering any credentials
Given user should navigate to the login page
When user enters valid email address ""
And user enters valid password ""
And user clicks on login button
Then user should able to log into the app successfully


