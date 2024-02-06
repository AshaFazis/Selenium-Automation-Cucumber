Feature: Login functionality

Background:
Given User launches the browser and application

Scenario Outline: Login with positive credentials

When User clicked on the SignIn link on homepage
Then Enter username <email> and password <password> and click on SignIn button
And Close the browser

Examples: 
|  email                   |  password   |
| 'ashafj11@gmail.com'     | 'Ashafj11!' | 
| 'carlpenet123@gmail.com' | 'Ashafj11!' |

 

Scenario Outline: Login with negative credentials

When User clicked on the SignIn link on homepage
Then Enter username <email> and password <password> and click on SignIn button
But Login page shows "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later." message
And Close the browser

Examples: 
|  email                   |  password   |
| 'ashafj11@gmail.com'     | 'Ashafj12!' | 
| 'carlpenet123@gmail.com' | 'Ashaj11!' |



