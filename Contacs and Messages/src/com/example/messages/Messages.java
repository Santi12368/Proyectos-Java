package com.example.messages;

import java.util.*;

public class Messages {

    Scanner scanner = new Scanner(System.in);
    Set<String> contactsKeys = Contacts.contactsKeys;
    public static Map<String, List<String>> messages = new HashMap<>();

    public Messages() {
        messages.put("Mark", null);
        messages.put("Mary", null);
        messages.put("Daniel", null);
        messages.put("Carlos", null);
        messages.put("Bonnie", null);
    }

    public void messagesHome() {
        label:
        while (true) {
            System.out.println("\nMessages.\nSelect an option:\n\t1. See the list of messages\n\t2. Send a new message\n\t3. Go back");
            String userSelection = scanner.nextLine();

            switch (userSelection) {
                case "1" -> this.getAllMessages();
                case "2" -> this.setNewMessage();
                case "3" -> {break label;}
                default -> System.out.println("Please enter a number between 1 and 5");
            }
        }
    }

    private void getAllMessages() {
        this.checkIfNull();
        System.out.println("Enter the name of the contact");
        String selectedContact = scanner.nextLine();

        if (messages.containsKey(selectedContact)) {
            if (messages.get(selectedContact) == null) {
                System.out.println("You currently have no messages.");
            } else {
                List<String> contactsMessages = messages.get(selectedContact);
                for (String contactsSingleMessages : contactsMessages) {
                    System.out.println("-- " + contactsSingleMessages);
                }
            }
        } else {
            System.out.println("The contact " + selectedContact + " has not been found.");
        }
    }

    private void setNewMessage() {
        this.checkIfNull();
        System.out.println("Enter the name of the contact you want to message");
        String messagedContact = scanner.nextLine();

        if (messages.containsKey(messagedContact)) {
            System.out.println("Write a message to " + messagedContact + ":");
            String userMessage = scanner.nextLine();
            messages.computeIfAbsent(messagedContact, k -> new ArrayList<>()).add(userMessage);
            System.out.println("Message sent.");
        } else {
            System.out.println("The contact " + messagedContact + " has not been found.");
        }
    }

    private void checkIfNull() {
        for (String s: contactsKeys) {
            messages.putIfAbsent(s, null);
        }
    }
}