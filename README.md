# Spring Kafka CRUD Operations

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations using Spring, Kafka, PostgreSQL, and Docker.

## Technologies Used

- Spring Framework: For building the application.
- Apache Kafka: For handling asynchronous messaging between microservices.
- PostgreSQL: For storing data persistently.
- Docker: For containerizing the application and its dependencies.

## Getting Started

To run this project locally, make sure you have Docker installed on your machine.

1. Clone the repository:

```bash
git clone https://github.com/your-username/spring-kafka-crud.git

2. Configure your database credentials in `enviroment in docker-compose.yml`.
3. Set up Maven:
   ```bash
   mvn clean install
4. Set up Docker and run Docker Compose:
   ```bash
   docker-compose up -d

## Usage

The application provides REST endpoints for performing CRUD operations on the data.
Kafka is used for asynchronous communication between different parts of the application.
PostgreSQL database stores the data persistently.
