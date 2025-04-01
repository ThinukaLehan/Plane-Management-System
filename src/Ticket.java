//Importing some Package Classes
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

//Creating a class name Ticket
public class Ticket {
    //Attributes
    private String row;
    private int seat;
    private double price;
    private Person person;

    //Constructor for Ticket Object
    public Ticket(String row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Getter method to retrieve the Row
    public String getRow() {
        return row;
    }

    //Setter method to modify the Row
    public void setRow(String row) {
        this.row = row;
    }

    //Getter method to retrieve the Seat
    public int getSeat() {
        return seat;
    }

    //Setter method to modify the Seat
    public void setSeat(int seat) {
        this.seat = seat;
    }

    //Getter method to retrieve the Price
    public double getPrice() {
        return price;
    }

    //Setter method to modify the Price
    public void setPrice(double price) {
        this.price = price;
    }

    //Getter method to retrieve the Person
    public Person getPerson() {
        return person;
    }

    //Setter method to modify the Person
    public void setPerson(Person person) {
        this.person = person;
    }

    //A method to print Ticket Information
    public void printTicketInfo (){
        System.out.println(" ");
        System.out.println("Row : " + row);
        System.out.println("Seat : " + seat);
        System.out.println("Price : $" + price);
        System.out.println("Person \n" + person);
    }

    //A method to save the Ticket as a Text File
    public void save(){
        String fileName = this.row + this.seat + ".txt";
        try (FileWriter file = new FileWriter(fileName)) {
            file.write("Information of the Ticket:\n");
            file.write("Row: " + row + "\n");
            file.write("Seat: " + seat + "\n");
            file.write("Price: $" + price + "\n");
            file.write("Person\n");
            file.write(person.toString());
        } catch (IOException e) {
            System.out.println("Error saving ticket");
        }
    }

    //A method to delete the Ticket file is user cancel it
    public void delete(){
        if (this.row == null || this.seat == 0){
            System.out.println("Row or Seat cannot be found...");
            return;
        }
        String fileName = this.row + this.seat + ".txt";
        File file = new File(fileName);
        if (file.exists()) {
            if (!file.delete()){
                System.out.println("There is an Error while deleting the file.");
            }
        }else {
            System.out.println("File doesn't exist");
        }
    }
}
