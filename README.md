### COP3060 Resources API (Spring Boot)

This project is a simple Spring Boot REST API that manages a list of campus resources in memory. It was built for a COP3060 assignment to demonstrate REST endpoints, in-memory data storage, and filtering without using a real database.

### Prerequisites

Before running this project, make sure you have:

Java Development Kit (JDK) 17 or higher

Git (optional, for cloning the repository)

One of the following:

Maven installed globally, or

Use of the Maven Wrapper included in this project (mvnw / mvnw.cmd)

To check your Java version:

java -version

### How to Run the Application
Option 1 — Using Maven Wrapper (Recommended)

mvn spring-boot:run

Running Tests

To run unit tests:

mvn test

### API Endpoints

Base URL:

http://localhost:8080/api/resources

1. Get All Resources
curl http://localhost:8080/api/resources

2. Get Resource by ID
curl http://localhost:8080/api/resources/res-001

3. Optional Filters

Filter by category:

curl "http://localhost:8080/api/resources?category=Lab"


Filter by search query (matches name or tags):

curl "http://localhost:8080/api/resources?q=tutor"

### Project Structure

```text
src/main/java/edu/famu/cop3060/resources/
├── ResourcesApplication.java
├── controller/
│   └── ResourcesController.java
├── service/
│   └── ResourcesService.java
├── store/
│   └── InMemoryResourceStore.java
└── dto/
    └── ResourceDTO.jav

```
Notes

This project does not use a database.

All data is stored in memory using InMemoryResourceStore.

Data is seeded when the application starts.

Build the Project

To create a packaged JAR:

mvn clean package


