# SkyPath - Flight Route Finder

SkyPath is a system designed for the aviation sector to calculate all possible routes between a point of origin (A) and
a destination (B) for flight reservations. The project is developed using Spring Boot and PostgreSQL.

---

## Features

- **Location Management**: Manage locations for "From" and "To" dropdowns.
- **Transportation Management**: Handle transportation details, including flights and other methods.
- **Route Calculation**: Calculate all possible routes between two locations based on specified constraints.
- **RESTful API**: Interact with the system via well-defined endpoints.

---

## Requirements

### Prerequisites

- **Java 17**
- **Maven**
- **PostgreSQL** (Preferred)

### Dependencies

The project uses the following major dependencies:

- **Spring Boot 3.x**
- **Hibernate**
- **Lombok**
- **PostgreSQL Driver**
- **Spring Data JPA**

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/YBA7/skypath.git
   cd skypath
   ```

2. Configure the database in `src/main/resources/application.yml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/skypath
       username: postgres
       password: 12345
   ```

3. Create the database:
   ```bash
   psql -U postgres -c "CREATE DATABASE skypath;"
   ```

4. Build and run the project:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. Access the application at `http://localhost:8080`.

---

## API Endpoints

### Location Management

- **GET** `/locations`
    - Retrieves all available locations.

- **POST** `/locations`
    - Adds a new location.

### Transportation Management

- **GET** `/transportations`
    - Lists all transportations.

- **POST** `/transportations`
    - Adds a new transportation option.

### Route Finder

- **GET** `/routes?fromLocationId={from}&toLocationId={to}`
    - Finds all valid routes between the specified locations.

---

## Constraints

- A route must include at least one flight.
- No more than three transportations per route.
- A route can have a maximum of:
    - One transportation before a flight.
    - One transportation after a flight.

---

## Example Data

### Locations

| ID | Name     |
|----|----------|
| 1  | Istanbul |
| 2  | Ankara   |
| 3  | Izmir    |

### Transportation

| ID | Origin   | Destination | Type   |
|----|----------|-------------|--------|
| 1  | Istanbul | Ankara      | Flight |
| 2  | Ankara   | Izmir       | Flight |
| 3  | Izmir    | Istanbul    | Other  |

---

## Development

### Project Structure

- **src/main/java**: Contains the Java source code.
- **src/main/resources**: Contains configuration files (e.g., `application.yml`).
- **pom.xml**: Maven configuration file.
- **target/**: Build outputs.

### How to Contribute

1. Fork the repository.
2. Create a new branch for your feature:
   ```bash
   git checkout -b feature/your-feature
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your feature"
   ```
4. Push the branch:
   ```bash
   git push origin feature/your-feature
   ```
5. Create a pull request.

---

## Contact

For any questions or support, please contact the project maintainer at [akbayry@gmail.com].
