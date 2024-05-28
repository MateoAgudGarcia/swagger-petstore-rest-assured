# Cucumber Test Cases for Petstore API
This README outlines four different workflows added to the [Petstore API](https://petstore3.swagger.io/) for validating the creation, verification, update, and deletion of a pet. These tests are implemented using Cucumber with Java and managed under **Gradle 8.7** and **Java 21**.

![Status](https://github.com/MateoAgudGarcia/swagger-petstore-rest-assured/actions/workflows/swagger-petstore-rest-assured-github-actions.yml/badge.svg)

## Running the Tests
The cucumber task defined in the __build.gradle__ file can be executed from the command line using `gradlew cucumber`, eliminating the need for an IDE. Additionally, Scenario Outlines have been employed to run two different examples.

#### Notes
No tests were implemented for the store or users as both features consistently returned 500 errors, even when invoked directly from Swagger.
Feature Files
The feature files are located in the ***src\test\java\Features*** directory and cover the following scenarios:

### Creating a Pet:
- Verifies successful pet creation with a valid request body.

### Verifying a Created Pet:
- Retrieves the details of the newly created pet and asserts the response data.

### Updating a Pet:
- Modifies the name of the created pet and verifies the updated information.

### Deleting a Pet:
- Removes the created pet and confirms its successful deletion.

***
### Scenario Outlines
Scenario Outlines are utilized in the Create a Pet and Update a Pet features to execute multiple test cases with different data sets.
### Gradle Configuration
The build.gradle file defines the Gradle configuration for the project, including dependencies, tasks, and test configurations.

***

### Conclusion
These Cucumber test cases effectively validate the CRUD operations for pets in the Petstore API. The tests are designed to be executed from the command line, enhancing ease of use. Scenario Outlines further streamline the testing process by enabling the execution of multiple test cases with varying data. While store and user features could not be tested due to consistent 500 errors, the implemented tests thoroughly cover the pet management functionalities of the API.