Feature: Login functionality

Background:
Given User launches the browser and application

Scenario Outline: Login with positive credentials

When User clicked on the SignIn link on homepage
Then Enter username <email> and password <password> and click on SignIn button

Examples: 
|  email                   |  password   |
| 'ashafj11@gmail.com'     | 'Ashafj11!' | 
| 'carlpenet123@gmail.com' | 'Ashafj11!' |

 




