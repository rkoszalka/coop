# Architecture
Since the goal of the project was keep as simple as it gets and avoid 
overengeeniring I used the good old Spring Boot package style avoiding more complex
structures like Hexagonal and DDD.

I also kept the database as simple as it gets, only containing and agenda and voting tables.
With as little columns as it was possible.

# Swagger
Swagger can be found at http:localhost:8080/swagger-ui/index.html

# Kafka
It's needed to have kafka installed on the local machine to run the project.

# Database
I am using an RDS Postgres on AWS, for the sake of this test it's allowing all inbound trafic
which I wouldn't  let happen if it was a production environment.

# Database Versioning
I am using Liquibase as a Database versioning tool.

# Third-Party Integration
The Heroku app is not working anymore, but if it were i would integrate with it using RestTemplate to make REST calls and validate user CPF

# Tests
Unfortunatelly I did not had the time to write the tests, between my work days,
a trip last week to get my new USA Visa, which was scheduled since January,
I had to work on this technical test last two days in the night and when I had
little time left on my nowadays work.

But if I had the time to write the tests I would use JUnit 5, Mockito and spring-starter-test.
Basically write the standard tests for a spring application which I am used to do on my work today.
