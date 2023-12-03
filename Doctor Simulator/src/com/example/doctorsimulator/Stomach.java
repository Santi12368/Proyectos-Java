package com.example.doctorsimulator;

import java.util.Random;

public class Stomach {
    Random random = new Random();

    public String condition = generateCondition();

    public String getName() {
        return "Stomach";
    }

    private String generateCondition() {
        String[] possibleConditions = {"None", "Indigestion"};

        return possibleConditions[random.nextInt(0, 2)];
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
