import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Contact class to hold contact details
class Contact {
    String name;
    String phoneNumber;

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

// Phonebook class to manage contacts
public class Phonebook {
    private List<Contact> contacts;

    public Phonebook() {
        contacts = new ArrayList<>();
    }

    // Function to insert a contact
    public String insertContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);
        return "Contact added successfully.";
    }

    // Function to search for a contact
    public Contact searchContact(String searchTerm) {
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(searchTerm) || contact.phoneNumber.equals(searchTerm)) {
                return contact;
            }
        }
        return null; // Contact not found
    }

    // Function to display all contacts
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.name + ", Phone Number: " + contact.phoneNumber);
        }
    }

    // Function to delete a contact
    public String deleteContact(String searchTerm) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.equalsIgnoreCase(searchTerm) || contacts.get(i).phoneNumber.equals(searchTerm)) {
                contacts.remove(i);
                return "Contact deleted successfully.";
            }
        }
        return "Contact not found.";
    }

    // Function to update a contact
    public String updateContact(String searchTerm, String newName, String newPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(searchTerm) || contact.phoneNumber.equals(searchTerm)) {
                contact.name = newName;
                contact.phoneNumber = newPhoneNumber;
                return "Contact updated successfully.";
            }
        }
        return "Contact not found.";
    }

    // Optional function to sort contacts
    public void sortContacts() {
        Collections.sort(contacts, Comparator.comparing(contact -> contact.name));
        System.out.println("Contacts sorted successfully.");
    }

    // Function to analyze search efficiency
    public String analyzeSearchEfficiency() {
        int n = contacts.size();
        if (n == 0) {
            return "Efficiency: O(1) (best case, empty phonebook)";
        } else {
            return "Efficiency: O(n) (worst case, need to check every contact)";
        }
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Insert Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Analyze Search Efficiency");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println(phonebook.insertContact(name, phoneNumber));
                    break;
                case 2:
                    System.out.print("Enter name or phone number to search: ");
                    String searchTerm = scanner.nextLine();
                    Contact foundContact = phonebook.searchContact(searchTerm);
                    if (foundContact != null) {
                        System.out.println("Found: Name: " + foundContact.name + ", Phone Number: " + foundContact.phoneNumber);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    phonebook.displayAllContacts();
                    break;
                case 4:
                    System.out.print("Enter name or phone number to delete: ");
                    String deleteTerm = scanner.nextLine();
                    System.out.println(phonebook.deleteContact(deleteTerm));
                    break;
                case 5:
                    System.out.print("Enter name or phone number to update: ");
                    String updateTerm = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.println(phonebook.updateContact(updateTerm, newName, newPhoneNumber));
                    break;
                case 6:
                    phonebook.sortContacts();
                    break;
                case 7:
                    System.out.println(phonebook.analyzeSearchEfficiency());
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
