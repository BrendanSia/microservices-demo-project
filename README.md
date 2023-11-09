# microservices-demo-project
Welcome to a my Spring Boot project that aims to perform CRUD operations.

## Getting Started
1. Please install Postman before testing the project.
2. Simply start the application, and you're good to go!

## Prerequisites
1. jdk 11

## Installation
1. Clone the repository using git bash and the command, "git clone https://github.com/BrendanSia/microservices-demo-project.git"
2. Ensure all dependencies are properly downloaded prior to running.

## Usage
1. Start the application.
2. Open a browser and head to http://localhost:8080/h2-console.
3. Enter "jdbc:h2:mem:testdb" for JDBC URL.
4. Enter "sa" for User Name.
5. Press "Connect" and the database should be available for viewing.
6. To view records, click once on the "PERSON" table and click "Run".

## Important
The database used in this project is an in-memory database. Everytime the project is restarted, steps 2 to 6 will have to be repeated in the "Usage" section above, as the contents of the database will be erased. 
To test the /retrieve/{id} request, please ensure the /save request is always triggered first, at least once everytime the project is started. The UUID can be obtained by viewing the records in the database after it is saved to replace "{id}".

## About
This project is a simple demonstration of the application of Spring Framework to perform CRUD operations. For now, only Create and Retrieve operations have been included. Update and Delete operations will be included at a later date. This project is for practising and demonstration purposes.
