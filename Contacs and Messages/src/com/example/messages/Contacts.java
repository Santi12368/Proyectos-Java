package com.example.messages;

import java.util.*;

public class Contacts extends Messages{

    Scanner scanner = new Scanner(System.in);
    private static final Map<String, Integer> contacts = new HashMap<>();
    public static Set<String> contactsKeys = contacts.keySet();
    public Contacts() {
        contacts.put("Mark",   3410983);
        contacts.put("Mary",   3525478);
        contacts.put("Daniel", 3124532);
        contacts.put("Carlos", 3435680);
        contacts.put("Bonnie", 3578190);
    }

    public void contactsHome() {
        label:
        while (true) {
            System.out.println("\nContacts.\nSelect an option:\n\t1. Show all contacts\n\t2. Add a new contact\n\t3. Search for a contact\n\t4. Delete a contact\n\t5. Go back");
            String userSelection = scanner.nextLine();

            switch (userSelection) {
                case "1" -> this.getAllContacts();
                case "2" -> this.setNewContact();
                case "3" -> this.searchContacts();
                case "4" -> this.deleteContacts();
                case "5" -> {break label;}
                default -> System.out.println("Please enter a number between 1 and 5");
            }
        }
    }

    private void getAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("You currently have 0 contacts");
        } else {
            System.out.println("All Contacts:");

            int currentContact = 1;
            for (String s: contactsKeys) {
                System.out.println("\t" + currentContact + ": " + s);
                currentContact++;
            }
        }
    }

    private void setNewContact() {
        System.out.println("Enter the new contact's name");
        String newName = scanner.nextLine();

        if (messages.containsKey(newName)) {
            System.out.println("The contact " + newName + " already exists.");
        } else {
            System.out.println("Enter " + newName + "'s number");

            try {
                String textInput = scanner.nextLine();
                textInput = textInput.replaceAll("\\s+","");
                int newNumber = Math.abs(Integer.parseInt(textInput));
                contacts.put(newName, newNumber);
                System.out.println("New contact created: " + newName);
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }
    }

    private void searchContacts() {
        System.out.println("Enter the name of the contact you want to search");
        String searchedContactName = scanner.nextLine();

        if (contacts.containsKey(searchedContactName)) {
            int searchedContactNumber = contacts.get(searchedContactName);
            System.out.println("Name: " + searchedContactName + "\nNumber: " + searchedContactNumber);
        } else {
            System.out.println("The name " + searchedContactName + " has not been found.");
        }
    }

    private void deleteContacts() {
        System.out.println("Enter the name of the contact you want to delete");
        String deletedContactName = scanner.nextLine();

        if (contacts.containsKey(deletedContactName)) {
            contacts.remove(deletedContactName);
            messages.remove(deletedContactName);
            System.out.println("The contact " + deletedContactName + " has been deleted.");
        } else {
            System.out.println("The name " + deletedContactName + " has not been found.");
        }
    }
}