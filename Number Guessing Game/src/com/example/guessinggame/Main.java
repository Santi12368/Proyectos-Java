package com.example.guessinggame;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Number Guessing Game");
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Welcome, " + name);
        System.out.println("Do you want to start the game?");

        while (true) {
           String userGameStart = scanner.next().toLowerCase();
            if (userGameStart.equals("yes")) {
                break;
            } else if (userGameStart.equals("no")) {
                System.out.println("Ok. Goodbye!");
                // Stops the program
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please write \"yes\" or \"no\".");
            }
        }
        Random random = new Random() ;
        int number = random.nextInt(30) + 1;
        System.out.println("Guess a number between 1 and 30. You have 5 tries");

        for (int i = 0; i < 5; i++) {
            int userGuess = scanner.nextInt();
            if (userGuess == number) {
                System.out.println("Congratulations! You won.");
                // Stops the program for 5 seconds
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            } else if (userGuess < number) {
                System.out.println("Wrong! Hint: the number is higher");
            } else if (userGuess > number) {
                System.out.println("Wrong! Hint: the number is lower");
            }
        }
        System.out.println("Sorry " + name + ", " + "You lost! Try again. the number was: " + number);
    }
}