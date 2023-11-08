# microservices-demo-project
Welcome to a demonstration of my spring project.

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
To test the /retrieve/{id} request, please ensure the /save request is always triggered before the /retrieve/{id} request everytime the project is restarted. The UUID can be obtained by viewing the records in the database after it is saved to replace "{id}".

## About
This project is a simple demonstration of the application of Spring Framework. It was created for practising and demonstration purposes.