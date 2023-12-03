package com.example.doctorsimulator;

import java.util.Random;

public class REye {
    Random random = new Random();

    public String color = LEye.color;
    public String condition = generateCondition();

    public String getName() {
        return "Right Eye";
    }

    private String generateCondition() {
        String[] possibleConditions = {"None", "Blurry Vision"};

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
