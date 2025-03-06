# Kata User Register With barebones CQRS

## Description
### First Part:
This is a simple user registration use case. As a User I want to register to the platform providing an email and
password.

Like an added value for the second part of this kata will be implementing a GetAll use case too to retrieve all users
in the current state of the application.

### Second Part:
Having the two use cases implemented, the second part consist on using the CQRS principle to manage this two use cases


## Requirements
### First Part: 
- It returns the newly created user
- The password should meet the security requirements:
    - Have more than 8 characters
    - Contains an underscore
- The userId should be random and unique
- The email should be a valid email
- The email cannot be used by another user
- A welcome email is sent to the newly registered user

### Second Part:

## Remember
You could approach this kata using inside-out or outside-in but TDD is a must!.

## Insights
Information about CQRS could be found by the hand of martin fowler in this [article](https://martinfowler.com/bliki/CQRS.html). <br/>
As a hint the easiest way to implement this pattern is using the command pattern (even for the queries)
an explanation can be found [here](https://refactoring.guru/design-patterns/command) thanks to refactoring guru.</br>