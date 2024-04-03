# Architecture
Since the goal of the project was keep as simple as it gets and avoid 
overengeeniring I used the good old Spring Boot package style avoiding more complex
structures like Hexagonal and Domain Driven design.

# Swagger
Swagger can be found at http:localhost:8080/swagger-ui/index.html

# Kafka
It's needed to have kafka installed on the local machine to run the project.

# Database
I am using an RDS Postgres on AWS, for the sake of this test it's allowing all inbound trafic
which I wouldn't  let happen if it was a production environment.