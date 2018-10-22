package com.inte.group4;

public class Potion extends Item {
    private int hpIncrease;

    public Potion(int hpIncrease) {
        this.hpIncrease = hpIncrease;
    }

    private String determineType() {
        String type;
        if (hpIncrease == 200) {
            type = "Minor Healing: +" + hpIncrease + " HP";
        } else if (hpIncrease == 500) {
            type = "Major Healing: +" + hpIncrease + " HP";
        } else {
            type = "Massive Healing: +" + hpIncrease + " HP";
        }
        return type;
    }

    @Override
    public String toString() {
        return "Potion of " + determineType();
    }
}
