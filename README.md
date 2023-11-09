# microservices-demo-project
Welcome to a my Spring Boot project that aims to perform CRUD operations.

## Getting Started
1. Please install Postman before testing the project.
2. Simply start the application, and you're good to go!

## Prerequisites
1. jdk 11

## Preparation
1. Clone the repository using git bash and the command, "git clone https://github.com/BrendanSia/microservices-demo-project.git"
2. Ensure all dependencies are properly downloaded prior to running.
3. Start the application.
4. Open a browser and head to http://localhost:8080/h2-console.
5. Enter "jdbc:h2:mem:testdb" for JDBC URL.
6. Enter "sa" for User Name.
7. Press "Connect" and the database should be available for viewing.
8. To view records, click once on the "PERSON" table and click "Run".

## Postman
1. Locate the postman JSON file in "src/main/resources/postman".
2. Import the JSON file into Postman.
3. Begin testing with the prepared requests.

## Important
The database used in this project is an in-memory database. Everytime the project is restarted, steps 4 to 8 will have to be repeated in the "Preparation" section above, as the contents of the database will be erased. 
To test the /retrieve/{id} request, please ensure the /save request is always triggered first, at least once everytime the project is started. The UUID can be obtained by viewing the records in the database after it is saved, to replace "{id}".

## About
This project is a simple demonstration of the application of Spring Framework to perform CRUD operations. This project is for practising and demonstration purposes.
