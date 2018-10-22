package com.inte.group4;

public class Scroll extends Item {
    private int maxApBuff;
    private int maxHpBuff;

    public Scroll(int maxApBuff, int maxHpBuff) {
        this.maxApBuff = maxApBuff;
        this.maxHpBuff = maxHpBuff;
    }

    public int getMaxApBuff() {
        return maxApBuff;
    }

    public int getMaxHpBuff() {
        return maxHpBuff;
    }

    private String determineType() {
        String type;
        if (maxApBuff <= 0) {
            type = "Health: +" + maxHpBuff + " Max HP";
        } else if (maxHpBuff <= 0) {
            type = "Strength: +" + maxApBuff + " AP";
        } else {
            type = "Power: +" + maxApBuff + " AP / +" + maxHpBuff + " Max HP";
        }
        return type;
    }

    @Override
    public String toString() {
        return "Scroll of " + determineType();
    }
}
