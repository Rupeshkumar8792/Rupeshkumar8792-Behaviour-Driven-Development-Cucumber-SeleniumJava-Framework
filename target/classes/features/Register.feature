Feature: Rehistration Functionality

Scenario: Verify and Validate the Registration functionality with mandatory details
Given user should navigates to the registration page
When user enters the details into below fields
|firstName |rupeshkumar|
|lastName |Suryawanshi|
|email        |rupesh.surya62@gmail.com|
|telephone|12121212121|
|password |123456|
And user checks in user policy 
And user clicks on continue button
Then user should be able to view the successful registration message

Scenario: Verify and Validate the Registration functionality with all details
Given user should navigates to the registration page
When user enters the details into below fields
|firstName |rupeshkumar|
|lastName |Suryawanshi|
|email        |rupesh.surya62@gmail.com|
|telephone|12121212121|
|password |123456|
And user selects Yes for newsletter
And user checks in user policy 
And user clicks on continue button
Then user should be able to view the successful registration message