package com.inte.group4;

import java.awt.*;

abstract public class Monster extends Sprite {

    private Point currentMonsterCords = new Point();

    public Monster(int ap, int hp){
        super(ap,hp);
    }

    abstract public void moveMonster();


    public Point getCurrentMonsterCords() {
        return currentMonsterCords;
    }

    public void setCurrentMonsterCords(Point currentMonsterCords) {
        this.currentMonsterCords = currentMonsterCords;
    }
    @Override
    public String toString() {
        String str = super.toString() + " cords: "+ currentMonsterCords.x + ":"  + currentMonsterCords.y;
        return str;
    }

}
