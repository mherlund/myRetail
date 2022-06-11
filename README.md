# Overview
myRetail is RESTful service that allows a user to view and save product information.

# Prerequisites
A local MongoDB install is required to run this application.
See MongoDB documentation on how to install and set up https://www.mongodb.com/docs/manual/installation/

# Design
This application utilizes Spring Boot since you can quickly create RESTful services.  MongoDB was
chosen as the backend noSql data store since it can be run easily on most machines.

If this was a production system, other noSQL repositories could be available and should be used if available.
Something that has multiple instances would ensure availability in case one crashes.  Instances
of this application should also be >1 for redundancy.  

# Running myRetail Application
1. Start your MongoDB server
```For Windows: run "C:\Development\mongodb\mongodb-5.0.9\bin\mongod.exe" --dbpath="C:\Development\mongodb\data\db"```
2. Run application via gradle task `run`
3. Use Swagger to access endpoints or other tools like **Postman**

# Testing
Tests can be run from the project directory using the gradle test task `gradlew test`

# Swagger
API documentation is done through Swagger.  Endpoints can be viewed and used through the Swagger-UI by accessing the page
`/swagger-ui/index.html` ex: `http://localhost:8080/swagger-ui/index.html`

# Future Enhancements
1. Add logging (usage, performance and error)
2. More error handling and edge case testing.
3. Security - require at least Basic Auth to access endpoints.