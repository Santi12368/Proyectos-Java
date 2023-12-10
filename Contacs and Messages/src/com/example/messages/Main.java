// Basic contacts and messages app. You start by entering you name and selecting a service.
// In "Contacts", you can see your contacts, add a new one, search for one by name (you receive the contacts name and number), and delete a contact.
// Each contact stores (Map) a name (key, String) and a number (value, int).
// In "Messages", you can see the messages you have sent to a contact, and write a new message to a contact.
// The messages are stored in a list inside a map with the contacts name as the key.

package com.example.messages;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contacts contacts = new Contacts();
        Messages messages = new Messages();

        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
        System.out.println("Welcome, " + userName);

        while (true) {
            System.out.println("What do you want to do?\n\t1. Manage contacts\n\t2. Messages\n\t3. Quit");
            String userSelection = scanner.next();
            switch (userSelection) {
                case "1" -> contacts.contactsHome();
                case "2" -> messages.messagesHome();
                case "3" -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Please enter a number between 1 and 3");
            }
        }
    }
}