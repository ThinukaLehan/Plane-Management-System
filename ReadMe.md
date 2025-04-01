# Plane Management Application

## Overview
The Plane Management Application is a Java-based console application that simulates an airline seat reservation system. The application allows users to buy and cancel seats, view available seating, search for tickets, and manage ticket information.

## Project Structure
```
W2052786_PLANEMANAGEMENT/
├── .idea/
├── out/
├── src/
│   ├── Person.java
│   ├── PlaneManagement.java
│   ├── Ticket.java
├── .gitignore
└── w2052786_PlaneManagement.iml
```

## Features
- Buy a seat on the plane
- Cancel an existing seat reservation
- Find the first available seat
- Display the seating plan
- Print information about sold tickets and total sales
- Search for ticket information by seat number

## Class Descriptions

### PlaneManagement.java
This is the main class of the application that contains the user interface and core functionality.

- `seatsGrid`: 2D array representing the seating layout of the plane
- `ticketsSold`: Array to store sold ticket objects
- `numSoldTickets`: Counter for the number of tickets sold

Methods:
- `main()`: Entry point of the application with menu interface
- `buy_seat()`: Handles the seat purchasing process
- `calculatePrice()`: Calculates ticket price based on seat location
- `cancel_seat()`: Handles the cancellation of a booked seat
- `find_first_available()`: Finds and displays the first available seat
- `show_seating_plan()`: Displays the current seating arrangement
- `print_tickets_info()`: Displays information about all sold tickets and total sales
- `search_ticket()`: Searches for a specific ticket by row and seat number

### Ticket.java
This class represents a ticket in the system.

Attributes:
- `row`: The row letter of the seat (A, B, C, or D)
- `seat`: The seat number
- `price`: The price of the ticket
- `person`: Reference to the Person object who purchased the ticket

Methods:
- Getters and setters for all attributes
- `printTicketInfo()`: Displays the ticket information
- `save()`: Saves the ticket information to a text file
- `delete()`: Deletes the ticket file when a booking is canceled

### Person.java
This class represents a customer who books a ticket.

Attributes:
- `name`: First name of the person
- `surname`: Last name of the person
- `email`: Email address of the person

Methods:
- Getters and setters for all attributes
- `printPersonInfo()`: Displays the person's information
- `toString()`: Returns a string representation of the Person object

## Seating Layout
The plane has 4 rows (A, B, C, and D) with varying numbers of seats:
- Rows A and D have 14 seats each
- Rows B and C have 12 seats each

In the seating plan:
- 'O' represents an available seat
- 'X' represents a booked seat

## Pricing Structure
Ticket prices vary based on seat location:
- Seats 1-5: $200.00
- Seats 6-9: $150.00
- Seats 10 and above: $180.00

## File Management
When a ticket is purchased, the application creates a text file named with the row letter and seat number (e.g., A1.txt). This file contains all the ticket information including customer details. When a seat is canceled, the corresponding file is deleted.

## How to Run
1. Compile the Java files:
   ```
   javac Person.java Ticket.java PlaneManagement.java
   ```
2. Run the application:
   ```
   java PlaneManagement
   ```

## Usage Instructions
When the application starts, a menu with the following options is displayed:
1. Buy a Seat
2. Cancel a seat
3. Find first available seat
4. Show seating plan
5. Print tickets information and total sales
6. Search ticket
0. Quit

Select the desired option by entering the corresponding number.

## Input Validation
The application includes robust input validation to handle:
- Invalid menu selections
- Invalid row letters (only A, B, C, and D are valid)
- Out-of-range seat numbers
- Non-numeric input for seat numbers

## Error Handling
The application includes error handling for:
- Input mismatch exceptions
- File I/O operations
- Invalid seat selections

## License
Educational Purposes only.

## Author
Name : Thinuka Lehan
Student ID: W2052786

