# Customer Management System

This project is a full-stack web application for managing customer data. It provides CRUD operations (Create, Read, Update, Delete) for customer records and includes JWT-based authentication for secure access. The application is built with the following technologies:

- **Backend:** Spring Boot (Java) with Spring Security for authentication
- **Frontend:** React.js with HTML/CSS/JavaScript
- **Database:** MySQL

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Project](#running-the-project) 
- [API Endpoints](#api-endpoints)
 
 

## Features

- **User Authentication:** JWT-based authentication for secure login and signup.
- **CRUD Operations:** Create, read, update, and delete customer records.
- **Pagination, Sorting, and Searching:** Easily manage large datasets.
- **Responsive Design:** Frontend built with React.js for a smooth user experience.

## Project Structure

```bash
customer-management-system/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/customer/
│   │   │   ├── resources/
│   │   │       └── application.properties
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── Login.js
│   │   │   └── Signup.js
│   │   ├── App.js
│   │   └── index.js
│   └── package.json
└── README.md
```

## Requirements

- **Backend:**
- Java 17 or later
- Maven 3.6.0 or later
- MySQL 8.0 or later
- **Frontend:**
- Node.js 16 or later
- npm 7 or later
- reactjs

## Installation

- git clone https://github.com/your-username/customer-management-system.git
cd customer-management-system/backend
- Set up the MySQL database:
- Create a database named customer_db.
Update the src/main/resources/application.properties file with your MySQL credentials.
- Build the project with Maven: mvn clean install

## Configuration

- Configuration for Application.properties in Spring boot
- `spring.datasource.url=jdbc:mysql://localhost:3306/customer_db` for the connection with database
- `spring.datasource.username=your-username` username of database
- `spring.datasource.password=your-password` password of database

- `spring.jpa.hibernate.ddl-auto=update` Auto update for every run
- `spring.jpa.show-sql=true` show sql queries in terminal

## Running-the-project
- backend
- `mvn spring-boot:run`
- The backend server will run on `http://localhost:8080`.
- frontend
- `npm start `
- The frontend will run on `http://localhost:3000`. 

## Api-endpoints

- Authentication
- POST `/api/authenticate` - Authenticate a user and return a JWT token.
- Customers
- POST `/api/customers/create` - Create a new customer.
- GET `/api/customers/{id}` - Get a customer by ID.
- GET `/api/customers` - Get a list of customers with pagination, sorting, and searching.
- PUT `/api/customers/{id}` - Update an existing customer.
- DELETE `/api/customers/{id}` - Delete a customer by ID.
