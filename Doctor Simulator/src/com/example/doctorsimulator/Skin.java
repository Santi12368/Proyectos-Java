package com.example.doctorsimulator;

import java.util.Random;

public class Skin {
    Random random = new Random();

    public String condition = generateCondition();

    public String getName() {
        return "Skin";
    }

    private String generateCondition() {
        String[] possibleConditions = {"None", "Burned"};

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
