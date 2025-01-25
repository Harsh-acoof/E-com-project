This project is a Spring Boot-based backend application that exposes a REST API 
for performing CRUD (Create, Read, Update, Delete) operations on data. 
The API is designed to manage resources (such as products, or any other entity you define) 
and can easily be extended to suit various use cases.

Features:
RESTful API: Exposes clean, HTTP-based API endpoints.
CRUD Operations: Supports create, read, update, and delete operations.
Spring Boot: Built using the Spring Boot framework for easy setup and deployment.
JPA & Hibernate: Uses Spring Data JPA and Hibernate for database interaction.
Validation: Includes input validation for incoming requests using annotations.
Exception Handling: Custom exception handling for better error responses.


Technologies Used
Spring Boot: Backend framework
Spring Web: To build RESTful services
Spring Data JPA: For database interaction
H2 Database: (or replace with any other relational DB)
Maven: Build and dependency management tool


Endpoints
GET /api/product: Fetch all resources
GET /api/product/{id}: Fetch a single resource by ID
POST /api/product: Create a new resource
PUT /api/product/{id}: Update an existing resource
DELETE /api/product/{id}: Delete a resource by ID
