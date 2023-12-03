// In this game you are a doctor, the patient and its condition is randomly generated every time you play.
// The goal is to look at all the available organs and cure them if they have a problem.
// You win when all the organs are healthy. You lose if you give the wrong medicine to the patient.


package com.example.doctorsimulator;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        LEye leftEye = new LEye();
        REye rightEye = new REye();
        Heart heart = new Heart();
        Stomach stomach = new Stomach();
        Skin skin = new Skin();

        String[] patients = {"Tom", "Robert", "Linda", "Carlos", "Abel"};
        String currentPatient = patients[random.nextInt(5)];
        System.out.println("Name: " + currentPatient);

        int patientAge = random.nextInt(18, 65);
        System.out.println("Age: " + patientAge);

        while (true) {
            System.out.println("Choose an organ: \n\t1. Left Eye\n\t2. Right Eye\n\t3. Heart\n\t4. Stomach\n\t5. Skin\n\t6. Quit");
            String organSelection = scanner.next();

            switch (organSelection) {
                case "1" -> {
                    // Left Eye
                    System.out.println("Organ: " + leftEye.getName() + "\nColor: " + LEye.color + "\nMedical Condition: " + leftEye.condition + "\nIs it healthy?: " + leftEye.hasBeenFixed());

                    while (leftEye.hasBeenFixed().equals("No")) {
                        System.out.println("The patient doesn't see very well with this eye. Your assistant recommends Eye drops. \nWhat do you want to do? \n\t1. Apply Eye drops\n\t2. Go back");
                        String userFixChoice = scanner.next();

                        if (userFixChoice.equals("1")) {
                            leftEye.condition = "None";
                            System.out.println("The patient says the blurry vision is gone");
                            break;
                        } else if (userFixChoice.equals("2")) {
                            break;
                        } else System.out.println("Enter a number between 1 and 2");
                    }
                }
                case "2" -> {
                    // Right Eye
                    System.out.println("Organ: " + rightEye.getName() + "\nColor: " + rightEye.color + "\nMedical Condition: " + rightEye.condition + "\nIs it healthy?: " + rightEye.hasBeenFixed());

                    while (rightEye.hasBeenFixed().equals("No")) {
                        System.out.println("The patient doesn't see very well with this eye. Your assistant recommends Eye drops. \nWhat do you want to do? \n\t1. Apply Eye drops\n\t2. Go back");
                        String userFixChoice = scanner.next();

                        if (userFixChoice.equals("1")) {
                            rightEye.condition = "None";
                            System.out.println("The patient says the blurry vision is gone");
                            break;
                        } else if (userFixChoice.equals("2")) {
                            break;
                        } else System.out.println("Enter a number between 1 and 2");
                    }
                }
                case "3" -> {
                    // Heart
                    System.out.println("Organ: " + heart.getName() + "\nHeart Rate: " + heart.heartRate + "\nMedical Condition: " + heart.condition + "\nIs it healthy?: " + heart.hasBeenFixed());

                    while (heart.hasBeenFixed().equals("No")) {
                        System.out.print("The patient has an abnormal heart rate. ");
                        if (heart.condition.equals("Bradycardia")) {
                            System.out.println("Your assistant says it might be a case of Bradycardia and recommends using Atropine to accelerate the heart rate.");
                        } else {
                            System.out.println("Your assistant says it might be a case of Tachycardia and recommends using Beta-blockers to lower the heart rate");
                        }
                        System.out.println("What do you want to do? \n\t1. Use Atropine \n\t2. Use Beta-blockers \n\t3. Go back");
                        String userFixChoice = scanner.next();

                        label1:
                        while (heart.condition.equals("Bradycardia")) {
                            switch (userFixChoice) {
                                case "1":
                                    System.out.println("The heart rate went back to normal.");
                                    heart.heartRate = random.nextInt(60, 110);
                                    heart.condition = "None";
                                    break label1;
                                case "2":
                                    System.out.println("The heart rate went even lower because of the Beta-blockers. The patient unfortunately passed away. \n Game Over.");
                                    System.exit(0);
                                case "3":
                                    break label1;
                                default:
                                    System.out.println("Please enter a number between 1 and 3");
                                    break;
                            }
                            break;
                        }
                        label:
                        while (heart.condition.equals("Tachycardia")) {
                            switch (userFixChoice) {
                                case "1":
                                    System.out.println("The heart rate went even higher because of the Atropine. The patient unfortunately passed away.\nGame Over");
                                    System.exit(0);
                                    break label;
                                case "2":
                                    System.out.println("The heart rate went back to normal");
                                    heart.condition = "None";
                                    heart.heartRate = random.nextInt(60, 110);
                                    break label;
                                case "3":
                                    break label;
                                default:
                                    System.out.println("Please enter a number between 1 and 3");
                                    break;
                            }
                            break;
                        }
                    }
                }
                case "4" -> {
                    // Stomach
                    System.out.println("Organ: " + stomach.getName() + "\nMedical Condition: " + stomach.condition + "\nIs it healthy?: " + stomach.hasBeenFixed());

                    while (stomach.hasBeenFixed().equals("No")) {
                        System.out.println("The patient is experiencing indigestion. Your assistant says this can be easily fixed with Alka-Seltzer. \nWhat do you want to do? \n\t1. Give Alka-Seltzer\n\t2. Go back");
                        String userFixChoice = scanner.next();

                        if (userFixChoice.equals("1")) {
                            stomach.condition = "None";
                            System.out.println("The patient says the indigestion is going away.");
                            break;
                        } else if (userFixChoice.equals("2")) {
                            break;
                        } else System.out.println("Enter a number between 1 and 2");
                    }
                }
                case "5" -> {
                    System.out.println("Organ: " + skin.getName() + "\nMedical Condition: " + skin.condition + "\nIs it healthy?: " + skin.hasBeenFixed());

                    while (skin.hasBeenFixed().equals("No")) {
                        System.out.println("You notice superficial burns on the patients skin. Your assistant recommends bandaging the burn. \nWhat do you want to do? \n\t1. Bandage the burn\n\t2. Go back");
                        String userFixChoice = scanner.next();

                        if (userFixChoice.equals("1")) {
                            skin.condition = "None";
                            System.out.println("The burn is now bandaged");
                            break;
                        } else if (userFixChoice.equals("2")) {
                            break;
                        } else System.out.println("Enter a number between 1 and 2");
                    }
                }
                // Skin
                case "6" -> {
                    System.out.println("Goodbye.");
                    System.exit(0);
                }
                default -> System.out.println("Please enter a number between 1 and 6.");
            }

            if (leftEye.condition.equals("None") && rightEye.condition.equals("None") && heart.condition.equals("None") && stomach.condition.equals("None") && skin.condition.equals("None")) {
                System.out.println("The patient is fully cured.\nYou Won!");
                System.exit(0);
            }
        }
    }
}
