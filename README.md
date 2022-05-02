# Cinnamon Cinema

Console application that allocates seats based on a random integer “number of seats” between 1 and 3

Acceptance Criteria and Assumptions
- The program allocates the required number of seats from the available seats starting from seat A1 and filling the auditorium from
left to right, front to back
- All of the seats are available for sale when the program starts
- The program should continue to allocate a random number of seats until it finds there are not enough seats left to complete the request
- Once there are not enough seats available to be allocated then the program can halt

## Technologies
- Java 17.0.2
- Maven 3.8.5
- JUnit 5.8.2

## Running Application

To run application in terminal, run the following command

```bash
mvn exec:java -Dexec.mainClass="CinnamonCinemas"
```
## Running Tests

To run tests, run the following command

```bash
mvn test
```
