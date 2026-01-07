#Todo Project
ToDoProject is a simple backend application for task management (CRUD), developed with Java 17 and Spring Boot 3, using an in-memory H2 database. 
The project is designed to learn and demonstrate best practices in backend development with Spring Boot, including DTOs, mapping, JPA, and API testing.
Features:

Create a task with title, description, priority, and due date

Read all tasks or a specific task by ID

Partially update a task (UpdateTaskDTO)

Delete a task

Automatic auditing: creation and update dates are handled automatically

API testing via Swagger UI

In-memory H2 database for fast development without complex configuration

Tech Stack:

Language: Java 17

Framework: Spring Boot 3

Database: H2 (in-memory)

Mapper: TaskMapper (for converting entities to DTOs)

API documentation & testing: Swagger (Springdoc OpenAPI)

Dependency management: Maven
