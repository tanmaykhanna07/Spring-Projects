# Kanban Board REST API

A Spring Boot backend microservice for a Kanban-style task management system (e.g., Trello/Jira clone). This API manages the core relationship between Projects and their nested Tasks using a relational database.

## Tech Stack
*   **Java 25+**
*   **Spring Boot 3** (Spring Web, Spring Data JPA)
*   **MySQL** (Relational Database)
*   **Hibernate** (ORM)

## Core Architecture
Implemented a Code-First Database architecture with `@Entity` models.
*   **One-to-Many Relationship:** A `Project` can have multiple `Tasks`.
*   **Many-to-One Relationship:** A `Task` is strictly bound to a single `Project` via `@JoinColumn`.

## API Endpoints

### Projects
*   `GET /api/projects` - Fetch all projects
*   `GET /api/projects/{id}` - Fetch a specific project by ID
*   `POST /api/projects` - Create a new project
*   `DELETE /api/projects/{id}` - Delete a project

### Tasks
*   `GET /api/tasks` - Fetch all tasks
*   `GET /api/tasks/{id}` - Fetch a specific task
*   `POST /api/tasks` - Create a task (Requires linked Project ID)
*   `PUT /api/tasks/{id}` - Update a task's status (e.g., TODO -> DONE)
*   `DELETE /api/tasks/{id}` - Delete a task