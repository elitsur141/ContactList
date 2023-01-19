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
        int choice = input.nextInt();
        input.nextLine();
        System.out.println("Please fill in the following information");
        System.out.println("First name:");
        String fname = input.nextLine();
        System.out.println("Last name:");
        String lname = input.nextLine();
        System.out.println("Phone number:");
        String pn = input.nextLine();
        if (choice == 1)
        {
            Student s;
            System.out.println("Grade:");
            int grade = input.nextInt();
            input.nextLine();
            s = new Student(fname, lname, pn, grade);
            contacts.add(s);
        }
        else
        {
            Athlete a;
            System.out.println("Sport:");
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
        for (Person p : contacts)
        {
            System.out.println(p);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        // Sort by first name
        if (sortBy == 0)
        {
            for (int i = 0; i < contacts.size() - 1; i++)
            {
                for (int j = 0; j < contacts.size() - 1 - i; j++)
                {
                    Person current = contacts.get(i);
                    Person next = contacts.get(i + 1);
                    // If the people's first names are out of order
                    if (current.getFirstName().compareTo(next.getFirstName()) > 0)
                    {
                        // Swap the two people
                        contacts.set(i, next);
                        contacts.set(i + 1, current);
                    }
                }
            }
        }
        // Sort by last name
        else if (sortBy == 1)
        {
            for (int i = 0; i < contacts.size() - 1; i++)
            {
                for (int j = 0; j < contacts.size() - 1 - i; j++)
                {
                    Person current = contacts.get(i);
                    Person next = contacts.get(i + 1);
                    // If the people's last names are out of order
                    if (current.getLastName().compareTo(next.getLastName()) > 0)
                    {
                        // Swap the two people
                        contacts.set(i, next);
                        contacts.set(i + 1, current);
                    }
                }
            }
        }
        // Sort by phone number
        else
        {
            for (int i = 0; i < contacts.size() - 1; i++)
            {
                for (int j = 0; j < contacts.size() - 1 - i; j++)
                {
                    Person current = contacts.get(i);
                    Person next = contacts.get(i + 1);
                    // If the people's phone numbers are out of order
                    if (current.getPhoneNumber().compareTo(next.getPhoneNumber()) > 0)
                    {
                        // Swap the two people
                        contacts.set(i, next);
                        contacts.set(i + 1, current);
                    }
                }
            }
        }
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String fName)
    {
        for (Person person : contacts)
        {
            // If the first name is found
            if (person.getFirstName().equals(fName))
            {
                return person;
            }
        }
        return null;
    }
    // TODO: Write searchByLastName
    public Person searchByLastName(String lName)
    {
        for (Person person : contacts)
        {
            // If the last name is found
            if (person.getLastName().equals(lName))
            {
                return person;
            }
        }
        return null;
    }
    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String pn)
    {
        for (Person person : contacts)
        {
            // If the phone number is found
            if (person.getPhoneNumber().equals(pn))
            {
                return person;
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (Person p : contacts)
        {
            if (p instanceof Student)
            {
                System.out.println(p);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();
        int choice = input.nextInt();
        while (choice != 0)
        {
            // Add a contact
            if (choice == 1)
            {
                addContact();
            }
            // Sort by first name
            else if (choice == 2)
            {
                sort(0);
                printContacts();
            }
            // Sort by last name
            else if (choice == 3)
            {
                sort(1);
                printContacts();
            }
            // Sort by phone number
            else if (choice == 4)
            {
                sort(2);
                printContacts();
            }
            // List all Students
            else if (choice == 5)
            {
                listStudents();
            }
            // Search by first name
            else if (choice == 6)
            {
                Scanner theName = new Scanner(System.in);
                System.out.println("Enter a name:");
                String fname = theName.nextLine();
                // If the name is not in the list
                Person p = searchByFirstName(fname);
                if (p == null)
                {
                    System.out.println(fname + " is not in the list.");
                }
                // Else return the person's info
                else
                {
                    System.out.println(p);
                }
            }
            // Search by last name
            else if (choice == 7)
            {
                Scanner theName = new Scanner(System.in);
                System.out.println("Enter a name:");
                String lname = theName.nextLine();
                // If the last name is not in the list
                if (searchByFirstName(lname) == null)
                {
                    System.out.println(lname + " is not in the list.");
                }
                // Else return the person's info
                else
                {
                    searchByLastName(lname);
                }
            }
            // Search by phone number
            else if (choice == 8)
            {
                Scanner theNum = new Scanner(System.in);
                System.out.println("Enter a phone number:");
                String pn = theNum.nextLine();
                // If the phone number is not in the list
                if (searchByFirstName(pn) == null)
                {
                    System.out.println(pn + " is not in the list.");
                }
                // Else return the person's info
                else
                {
                    searchByPhoneNumber(pn);
                }
            }
            // If the user wants to exit
            System.out.println("Please pick from the following menu options");
            printMenuOptions();
            choice = input.nextInt();
        }
        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
