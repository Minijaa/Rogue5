package com.inte.group4;

import java.awt.*;

abstract public class Monster extends Sprite {
    private boolean isUpOrLeft;
    Point currentMonsterCords;
    char monsterChar;

    public void setMonsterChar(char monsterChar) {
        this.monsterChar = monsterChar;
    }

    public Monster(int ap, int hp, Point p) {
        super(ap, hp);
        currentMonsterCords = p;
    }

    abstract public Point moveMonster();


    public Point getCurrentMonsterCords() {
        return currentMonsterCords;
    }

    public void setCurrentMonsterCords(Point currentMonsterCords) {
        this.currentMonsterCords = currentMonsterCords;
    }

    @Override
    public String toString() {
        String str = super.toString() + " cords: " + currentMonsterCords.x + ":" + currentMonsterCords.y;
        return str;
    }

    public void setDirection(String left) {

    }

    public boolean getIsUpOrLeft() {
        return isUpOrLeft;
    }

    public void setUpOrLeft(boolean upOrLeft) {
        isUpOrLeft = upOrLeft;
    }

    public char getMonsterChar() {
        return monsterChar;
    }

}
