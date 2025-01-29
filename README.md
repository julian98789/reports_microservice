# Reports Microservice

The **Reports** microservice is responsible for managing purchase reports in the database. Its main function is to register and manage reports for users who have made a purchase, providing an efficient and scalable API for report management.

This service follows a hexagonal architecture, ensuring a clear separation between business logic and infrastructure layers. Additionally, it integrates with other microservices, such as the **Transaction** service, to retrieve purchased items.

## Installation

To run the **Reports** microservice, follow these steps:

### 1. Clone the repository
```sh
git clone https://github.com/julian98789/reports_microservice.git
cd reports_microservice
```

### 2. Configure database connection
Add the database connection in the `application-dev.properties` file with the following fields:

```
spring.data.mongodb.uri=mongodb://<YOUR_CONNECTION_URL>
spring.data.mongodb.username=<YOUR_USERNAME>
spring.data.mongodb.password=<YOUR_PASSWORD>
```

### 3. Add JWT secret key
Add the JWT secret key in the following field of the `application-dev.properties` file:

```
JWT_SECRET_KEY=<YOUR_JWT_SECRET_KEY>
```

### 4. Run the microservice  
Run the microservice locally with the following command:

```sh
gradle bootRun
```

## Configure Docker 

### 1. Create the `.env` file 
Create a `.env` file in the root of the project and add the following fields:

```
JAVA_APP_PORT=<YOUR_SERVICE_PORT>
MONGO_INITDB_ROOT_PASSWORD=<YOUR_MONGO_PASSWORD>
MONGO_PORT=<YOUR_MONGO_PORT>
MONGO_INITDB_DATABASE=<YOUR_DATABASE_NAME>
MONGO_INITDB_ROOT_USERNAME=<YOUR_MONGO_USERNAME>
JWT_SECRET_KEY=<YOUR_JWT_SECRET_KEY>
```

### 2. Activate the `prod` profile
Activate the `prod` profile in the following field of the `application.properties` file: 
```
spring.profiles.active=prod
```

### 3. Build and run with Docker Compose  
Run the following commands to start the containers:

```sh
docker-compose up --build -d
```

To stop the containers:

```sh
docker-compose down
```

# Technologies Used

This project uses the following technologies for its development:

## Spring Boot

- **Description**: A framework for building Java applications quickly and easily.
- **Documentation**: [Spring Boot Documentation](https://spring.io/projects/spring-boot)

## Docker

- **Description**: A platform that allows packaging applications and their dependencies into containers.
- **Documentation**: [Docker Documentation](https://docs.docker.com/)

## MongoDB

- **Description**: A NoSQL database that uses a document-oriented data model, allowing for flexible and scalable data storage.
- **Documentation**: [MongoDB Documentation](https://docs.mongodb.com/)


# Project Microservices

This project consists of several microservices that work together. Below are the links to each of them:

- **Reports Microservice**: [reports_microservice](https://github.com/julian98789/reports_microservice.git)
- **Stock Microservice**: [stock_microservice](https://github.com/julian98789/stock_microservice.git)
- **User Microservice**: [user_microservice](https://github.com/julian98789/user_microservice.git)
- **Shopping Cart Microservice**: [shopping_cart_microservice](https://github.com/julian98789/shopping_cart_microservice.git)
- **Transaction Microservice**: [transaction_microservice](https://github.com/julian98789/transaction_microservice.git)
