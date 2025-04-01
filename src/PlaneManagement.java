//Importing some Package Classes
import java.util.InputMismatchException;
import java.util.Scanner;

//PlaneManagement class
public class PlaneManagement {
    private static String[][] seatsGrid;
    private static final Ticket[] ticketsSold = new Ticket[52];
    private static int numSoldTickets = 0;

    //Main Method
    public static void main(String[] args) {
        //Creating a 2D array named seatsGrid
        seatsGrid = new String[][]{
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}
        };

        System.out.print("\nWelcome to the Plane Management Application\n\n");
        Scanner userInput = new Scanner(System.in);

        boolean not_quit = true;
        int menuNum;
        //Looping until user quit
        while (not_quit) {
            System.out.println("**************************************************\n*                  MENU OPTIONS                  *\n**************************************************");
            System.out.println("\t1) Buy a Seat\n\t2) Cancel a seat\n\t3) Find first available seat\n\t4) Show seating plan\n\t5) Print tickets information and total sales\n\t6) Search ticket\n\t0) Quit\n**************************************************");

            try {
                System.out.print("Please Select an Option : ");
                menuNum = userInput.nextInt();
                userInput.nextLine();

            System.out.println("**************************************************");

            //Using a switch case to call methods when the user enter numbers according to the menu
            switch (menuNum) {
                case 0:
                    not_quit = false;
                    break;
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                default:
                    System.out.println("Invalid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Valid number...");
                userInput.nextLine();
            }
        }
        System.out.println("Thank You...");
    }

    //A method named buy_seat for buy tickets.
    public static void buy_seat() {
        Scanner userInput = new Scanner(System.in);
        Scanner pause = new Scanner(System.in);
        boolean correct = false;
        int seatLetterIndex = 0;

        //Looping till user enter a Valid Row Letter & Seat Number
        while (!correct){
            try {
                System.out.print("Enter a Row Letter : ");
                String seatLetter = userInput.next();
                seatLetter = seatLetter.toUpperCase();

                //Checking the inputs
                if (seatLetter.equals("A") || seatLetter.equals("B") || seatLetter.equals("C") || seatLetter.equals("D")){
                    correct = true;
                    //Using a switch case to give a value for seatLetter
                    switch (seatLetter) {
                        case "A":
                            break;
                        case "B":
                            seatLetterIndex = 1;
                            break;
                        case "C":
                            seatLetterIndex = 2;
                            break;
                        case "D":
                            seatLetterIndex = 3;
                            break;
                        default:
                            System.out.println("Please Enter a Valid Seat Letter...");
                    }

                    while (true){
                        System.out.print("Enter a Seat Number : ");
                        if (userInput.hasNextInt()){
                            int seatNumber = userInput.nextInt();
                            userInput.nextLine();

                            //Checking Row A & D which contains 14 seats
                            if ((seatLetter.equals("A") || seatLetter.equals("D")) && (seatNumber == 0 || seatNumber > 14)){
                                System.out.println("Seat Number is out of Limit");

                            //Checking Row B & C which contains 12 seats
                            } else if ((seatLetter.equals("B") || seatLetter.equals("C")) && ( seatNumber ==0 || seatNumber > 12 )){
                                System.out.println("Seat Number is out of Limit");

                            } else {
                                //Checking the seatsGrid whether this seat is Available or not
                                if ((seatsGrid[seatLetterIndex][seatNumber - 1]).equals("X")) {
                                    System.out.println("Sorry... This seat is not available right now. (already booked)\n");

                                } else {
                                    //Mark the chair as a non-available seat
                                    (seatsGrid[seatLetterIndex][seatNumber - 1]) = "X";
                                    System.out.println("This seat is available(free)\n");

                                    userInput = new Scanner(System.in);
                                    System.out.print("Enter Your Name : ");
                                    String name = userInput.nextLine();

                                    System.out.print("Enter your Surname : ");
                                    String surname = userInput.nextLine();

                                    System.out.print("Enter your Email : ");
                                    String email = userInput.nextLine();

                                    System.out.println("Your booking is confirmed\n");

                                    Person person = new Person(name, surname, email);

                                    double price = calculatePrice(seatNumber);

                                    Ticket ticket = new Ticket(seatLetter, seatNumber, price, person);

                                    //Calling the save method to create a File for the particular seat
                                    ticket.save();

                                    ticketsSold[numSoldTickets] = ticket;
                                    numSoldTickets++;
                                }
                                System.out.print("Press Enter to Back to Main Menu...");
                                pause.nextLine();
                                break;
                            }
                        } else {
                            userInput.next();
                            System.out.println("Please Enter a Valid Seat Number...");
                            userInput.nextLine();
                        }
                    }
                } else
                    System.out.println("Please Enter a Valid Seat Letter...");

            } catch (InputMismatchException e){
                System.out.println("Seat Number must be a Number...");
            }
        }
    }

    //A method named calculatePrice for calculate the price of the seat
    private static double calculatePrice(int seatNumber) {
        if (seatNumber <= 5) {
            return 200.00;
        } else if (seatNumber <= 9) {
            return 150.00;
        } else {
            return 180.00;
        }
    }

    //A method named cancel_seat for cancel a booked seat when user cancel it
    public static void cancel_seat() {
        Scanner userInput = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;
        int seatLetterIndex = 0;

        //Looping till user enter a Valid Row Letter & Seat Number
        while (!correct){
            try{
                System.out.print("Enter the Row Letter : ");
                String seatLetter = userInput.next();
                seatLetter = seatLetter.toUpperCase();

                //Checking the inputs
                if (seatLetter.equals("A") || seatLetter.equals("B") || seatLetter.equals("C") || seatLetter.equals("D")){
                    correct = true;
                    //Using a switch case to give a value for seatLetter
                    switch (seatLetter) {
                        case "A":
                            break;
                        case "B":
                            seatLetterIndex = 1;
                            break;
                        case "C":
                            seatLetterIndex = 2;
                            break;
                        case "D":
                            seatLetterIndex = 3;
                            break;
                        default:
                            System.out.println("Please Enter a Valid Seat Letter...");
                    }
                    while (true){
                        System.out.print("Enter the Seat Number : ");
                        if (userInput.hasNextInt()){
                            int seatNumber = userInput.nextInt();
                            userInput.nextLine();

                            //Checking Row A & D which contains 14 seats
                            if ((seatLetter.equals("A") || seatLetter.equals("D")) && (seatNumber == 0 || seatNumber > 14)){
                                System.out.println("Seat Number is out of Limit");

                                //Checking Row B & C which contains 12 seats
                            } else if ((seatLetter.equals("B") || seatLetter.equals("C")) && ( seatNumber ==0 || seatNumber > 12 )){
                                System.out.println("Seat Number is out of Limit");

                            } else {
                                if ((seatsGrid[seatLetterIndex][seatNumber - 1]).equals("X")) {
                                    (seatsGrid[seatLetterIndex][seatNumber - 1]) = "O";

                                    for (int i = 0; i < numSoldTickets; i++) {
                                        Ticket ticket = ticketsSold[i];
                                        if (ticket.getRow().equals(seatLetter) && ticket.getSeat() == seatNumber) {
                                            for (int j = i; j < (numSoldTickets - 1); j++) {
                                                ticketsSold[j] = ticketsSold[j + 1];
                                            }
                                            //Calling the delete method to delete the created File for the particular seat
                                            ticket.delete();
                                            numSoldTickets--;
                                            System.out.println("Done... Booking has been Canceled.\n");
                                        }
                                    }
                                } else {
                                    System.out.println("This seat is not booked yet");
                                    userInput.nextLine();
                                    break;
                                }
                            }
                            System.out.print("Press Enter to Back to Main Menu...");
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Please Enter a Valid Seat Number...");
                            userInput.next();
                        }
                    }
                } else {
                    System.out.println("Please Enter a Valid Seat Letter...");
                }
            } catch (InputMismatchException e){
                System.out.println("Seat Number must be a Number...");
                userInput.next();
            }
        }
    }

    //A method named find_first_available to find the first available seat
    public static void find_first_available() {
        Scanner pause = new Scanner(System.in);
        String seatsLetter = "";
        //Loops for checking seat by seat
        for (int x = 0; x < seatsGrid.length; x++) {
            for (int y = 0; y < seatsGrid[x].length; y++) {
                if (seatsGrid[x][y].equals("O")) {
                    switch (x) {
                        case 0:
                            seatsLetter = "A";
                            break;
                        case 1:
                            seatsLetter = "B";
                            break;
                        case 2:
                            seatsLetter = "C";
                            break;
                        case 3:
                            seatsLetter = "D";
                            break;
                        default:
                            break;
                    }
                    System.out.println(seatsLetter + (y + 1) + " is the First Available Seat Right Now\n");
                    System.out.print("Press Enter to Back to Main Menu...");
                    pause.nextLine();
                    return;
                }
            }
        }
        System.out.print("Press Enter to Back to Main Menu...");
        pause.nextLine();
    }

    //A method named show_seating_plan to show the seat plan
    public static void show_seating_plan() {
        Scanner pause = new Scanner(System.in);
        //Loops for print the seatGrid
        for (int x = 0; (x < seatsGrid.length); x++) {
            for (int y = 0; y < seatsGrid[x].length; y++) {
                System.out.print(seatsGrid[x][y] + " ");
            }
            if (x==1){
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("\nPress Enter to Back to Main Menu...");
        pause.nextLine();
    }

    //A method named print_tickets_info for print the information of tickets
    public static void print_tickets_info() {
        Scanner pause = new Scanner(System.in);
        double totalPrice = 0.00;

        if (numSoldTickets == 0) {
            System.out.println("No Tickets have been sold yet...\n");
        } else {
            System.out.println("Information of Sold Tickets");
            for (int i = 0; i < numSoldTickets; i++) {
                Ticket ticket = ticketsSold[i];
                ticket.printTicketInfo();
                totalPrice += ticket.getPrice();
            }
            System.out.println("\nTotal Price of Sold Tickets : £" + totalPrice + "\n");
        }
        System.out.print("Press Enter to Back to Main Menu...");
        pause.nextLine();
    }

    //A method named search_ticket for print the information of the ticket when user inputs the seat Row and Number
    public static void search_ticket() {
        Scanner userInput = new Scanner(System.in);
        Scanner pause = new Scanner(System.in);
        boolean correct = false;

        while (!correct){
            try{
                System.out.print("Enter the Row : ");
                String seatLetter = userInput.next().toUpperCase();
                //Checking the inputs for Row
                if (seatLetter.equals("A") || seatLetter.equals("B") || seatLetter.equals("C") || seatLetter.equals("D")) {
                    correct = true;

                    while (true){
                        System.out.print("Enter the Seat : ");
                        if (userInput.hasNextInt()){
                            int seatNum = userInput.nextInt();
                            userInput.nextLine();

                            boolean foundTicket = false;
                            for (int i = 0; i < numSoldTickets; i++) {
                                Ticket ticket = ticketsSold[i];
                                if (ticket.getRow().equals(seatLetter) && ticket.getSeat() == seatNum) {
                                    ticket.printTicketInfo();
                                    foundTicket = true;
                                    break;
                                }
                            }
                            if (!foundTicket) {
                                System.out.println("This seat is available...");
                            }
                            System.out.print("Press Enter to Back to Main Menu...");
                            pause.nextLine();
                            break;
                        } else {
                            System.out.println("Please Enter a Valid Seat Number...");
                            userInput.next();
                        }
                    }
                } else {
                    System.out.println("Please Enter a Valid Seat Letter...");
                }
            }catch (InputMismatchException e){
                System.out.println("Seat Number must be a Number...");
                userInput.next();
            }
        }
    }
}
