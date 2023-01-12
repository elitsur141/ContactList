/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */
import java.util.ArrayList;
import java.util.Scanner;
public class ContactList
{
    // TODO: Create your array contacts
    private ArrayList<Person> contacts;
    // TODO: Write a Constructor
    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact()
    {
        // TODO: Complete the addContact method
        Scanner input = new Scanner(System.in);
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student");
        System.out.println("2. Athlete");
        System.out.println("Please fill in the following information");
        System.out.println("First name:");
        String fname = input.nextLine();
        System.out.println("last name");
        String lname = input.nextLine();
        System.out.println("Phone number");
        String pn = input.nextLine();
        if (input.nextInt() == 1)
        {
            Student s;
            input.nextLine();
            int grade = input.nextInt();
            input.nextLine();
            s = new Student(fname, lname, pn, grade);
            contacts.add(s);
        }
        else
        {
            Athlete a;
            input.nextLine();
            String sport = input.nextLine();
            a = new Athlete(fname, lname, pn, sport);
            contacts.add(a);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        //for (Person)
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
    }

    // TODO: Write searchByFirstName

    // TODO: Write searchByLastName

    // TODO: Write searchByPhoneNumber

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
