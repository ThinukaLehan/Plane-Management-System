//Creating a class named Person
public class Person {

    //Attributes
    private String name;
    private String surname;
    private String email;

    // Constructor to initialize a Person object
    public Person (String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Getter method to retrieve the person's name
    public String getName() {
        return name;
    }

    //Setter method to modify the person's name
    public void setName(String name) {
        this.name = name;
    }

    //Getter method to retrieve the person's surname
    public String getSurname() {
        return surname;
    }

    //Setter method to modify the person's surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Getter method to retrieve the person's email
    public String getEmail() {
        return email;
    }

    //Setter method to modify the person's email
    public void setEmail(String email) {
        this.email = email;
    }

    //A method named printPersonInfo to print the information of the Person.
    public void printPersonInfo() {
        System.out.println("Information of the Person :");
        System.out.println("Name : " + name);
        System.out.println("Surname : " + surname);
        System.out.println("Email : " + email);
    }

    //A method to provide a string representation of the Person Object
    public String toString() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Email: " + email;
    }
}
