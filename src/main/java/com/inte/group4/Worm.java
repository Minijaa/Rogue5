package com.inte.group4;

import java.awt.*;
import java.util.Random;

public class Worm extends Monster {
    //private Point monsterPosition;

    public Worm() {
        super(10, 14);
    }

    @Override
    public Point moveMonster() {
        Random rnd = new Random();
        Point oldPosition = currentMonsterCords;
        int x, y;
        Point newPosition;
        do {
            x = rnd.nextInt(10);
            y = rnd.nextInt(10);
            newPosition = new Point(x, y);
        } while (oldPosition != null && oldPosition.equals(newPosition));
        currentMonsterCords = newPosition;
        return newPosition;
    }

    @Override
    public void attack() {

    }

    @Override
    public void decreaseHp() {

    }

    public Point getMonsterPosition() {
        return currentMonsterCords;
    }
    public String toString() {
        String str = "Worm " + super.toString();
        return str;
    }
}
