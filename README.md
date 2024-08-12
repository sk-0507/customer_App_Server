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
- [Contributing](#contributing)
- [License](#license)

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
