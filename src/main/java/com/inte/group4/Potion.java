package com.inte.group4;

public class Potion extends Item {
    private static final int MASSIVE_POTION_VALUE = 90000000;
    private static final int MAJOR_POTION_VALUE = 500;
    private static final int MINOR_POTION_VALUE = 200;
    private int currentHpIncrease;

    public Potion(int currentHpIncrease) {
        if (currentHpIncrease != MINOR_POTION_VALUE && currentHpIncrease != MAJOR_POTION_VALUE && currentHpIncrease != MASSIVE_POTION_VALUE) {
            throw new IllegalArgumentException();
        }
        this.currentHpIncrease = currentHpIncrease;
    }

    private String determineType() {
        String type;
        if (currentHpIncrease == MINOR_POTION_VALUE) {
            type = "Minor Healing: +" + currentHpIncrease + " HP";
        } else if (currentHpIncrease == MAJOR_POTION_VALUE) {
            type = "Major Healing: +" + currentHpIncrease + " HP";
        } else {
            type = "Massive Healing: +" + currentHpIncrease + " HP";
        }
        return type;
    }

    @Override
    public String toString() {
        return "Potion of " + determineType();
    }
}
