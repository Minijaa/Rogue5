package com.inte.group4;

public class Scroll extends Item implements Comparable<Scroll> {
    private static final int HEALTH_SCROLL_HP_VALUE = 500;
    private static final int STRENGTH_SCROLL_AP_VALUE = 300;
    private static final int POWER_SCROLL_AP_VALUE = 200;
    private static final int POWER_SCROLL_HP_VALUE = 400;
    private int maxApBuff;
    private int maxHpBuff;

    //Konstruktorn borde eg ta booleans istället men det skulle sabba nuvarande tester i PlayerTest.
    public Scroll(int maxApBuff, int maxHpBuff) {
        if (maxApBuff <= 0) {
            this.maxApBuff = 0;
            this.maxHpBuff = HEALTH_SCROLL_HP_VALUE;
        } else if (maxHpBuff <= 0) {
            this.maxApBuff = STRENGTH_SCROLL_AP_VALUE;
            this.maxHpBuff = 0;
        } else {
            this.maxApBuff = POWER_SCROLL_AP_VALUE;
            this.maxHpBuff = POWER_SCROLL_HP_VALUE;
        }
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

    @Override
    public int compareTo(Scroll other) {
        if ((maxApBuff + maxHpBuff) > (other.maxApBuff + other.maxHpBuff) || maxHpBuff > other.maxHpBuff) {
            return 1;
        } else if ((maxApBuff + maxHpBuff) < (other.maxApBuff + other.maxHpBuff) || maxHpBuff < other.maxHpBuff) {
            return -1;
        }
        return 0;
    }

    public int getMaxApBuff() {
        return maxApBuff;
    }

    public int getMaxHpBuff() {
        return maxHpBuff;
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof Scroll){
            Scroll o = (Scroll)other;
            return maxApBuff == o.maxApBuff && maxHpBuff==o.maxHpBuff;
        }
        else
            return false;
    }


}
//  Gamla compareTo-koden. Den funkar men va lite svårtestad eftersom den inte jämför med other)
//        if (maxApBuff == 0 && maxHpBuff > 0) {
//            return -1;
//        } else if (maxHpBuff == 0 && maxApBuff > 0) {
//            return 0;
//        } else {
//            return 1;
//        }
//    }

