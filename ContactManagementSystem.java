import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ContactManagementSystem {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    // Constructor
    public ContactManagementSystem() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add a new contact
    public void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        contacts.add(new Contact());
        System.out.println("Contact added successfully.");
    }

    // Update an existing contact
    public void updateContact() {
        System.out.print("Enter contact name or phone number to update: ");
        String identifier = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equals(identifier) || contact.getPhoneNumber().equals(identifier)) {
                System.out.print("Enter new phone number: ");
                contact.setPhoneNumber(scanner.nextLine());
                System.out.print("Enter new email address: ");
                contact.setEmail(scanner.nextLine());
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Delete a contact
    public void deleteContact() {
        System.out.print("Enter contact name or phone number to delete: ");
        String identifier = scanner.nextLine();
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equals(identifier) || contact.getPhoneNumber().equals(identifier)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // View all contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    // Main method
    public static void main(String[] args) {
        ContactManagementSystem system = new ContactManagementSystem();
        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = system.scanner.nextInt();
            system.scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    system.addContact();
                    break;
                case 2:
                    system.updateContact();
                    break;
                case 3:
                    system.deleteContact();
                    break;
                case 4:
                    system.viewContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}