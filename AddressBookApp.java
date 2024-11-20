import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

class AddressBook {
    private final ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber, String email) {
        contacts.add(new Contact(name, phoneNumber, email));
    }

    public void viewAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Contact\n2. View All Contacts\n3. Search Contact\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    addressBook.addContact(name, phone, email);
                    break;
                case 2:
                    addressBook.viewAllContacts();
                    break;
                case 3:
                    System.out.print("Enter Name to Search: ");
                    String searchName = scanner.nextLine();
                    addressBook.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
