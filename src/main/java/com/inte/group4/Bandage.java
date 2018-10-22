package com.inte.group4;

import java.util.Random;

public class Bandage extends Item {
    private int hpIncreaseValue;

    public Bandage() {
        Random rnd = new Random();
        int baseValue = 100;
        hpIncreaseValue = baseValue + rnd.nextInt(400);
    }

    private String determineType() {
        String type;
        if (hpIncreaseValue <= 250) {
            type = "Dirty ";
        } else if (hpIncreaseValue <= 350) {
            type = "Cleanish ";
        } else {
            type = "Sterile ";
        }
        return type;
    }

    @Override
    public String toString() {
        return determineType() + "Bandage: +" + hpIncreaseValue + " HP";
    }
}
