package com.example.doctorsimulator;

import java.util.Random;

public class LEye {
    static Random random = new Random();

    public String condition = generateCondition();
    public static String color = generateColor();

    public String getName() {
        return "Left Eye";
    }

    private String generateCondition() {
        String[] possibleConditions = {"None", "Blurry Vision"};

        return possibleConditions[random.nextInt(0, 2)];
    }

    private static String generateColor() {
        String[] possibleColors = {"Brown", "Blue", "Green"};

        return possibleColors[random.nextInt(0, 3)];
    }

    public String hasBeenFixed() {
        boolean fixedState = condition.equals("None");
        String hasBeenFixed;

        if (fixedState) {
            hasBeenFixed = "Yes";
        } else {
            hasBeenFixed = "No";
        }

        return hasBeenFixed;
    }
}
