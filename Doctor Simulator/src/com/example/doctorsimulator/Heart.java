package com.example.doctorsimulator;

import java.util.Random;

public class Heart {
    Random random = new Random();

    public int heartRate = generateHeartRate();
    public String condition = generateCondition();

    public String getName() {
        return "Heart";
    }

    private int generateHeartRate() {
        return random.nextInt(40, 140);
    }

    private String generateCondition() {
        String[] possibleConditions = {"None", "Tachycardia", "Bradycardia"};

        if (heartRate < 60) {
            return "Bradycardia";
        } else if (heartRate <= 110) {
            return "None";
        } else {
            return "Tachycardia";
        }
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
