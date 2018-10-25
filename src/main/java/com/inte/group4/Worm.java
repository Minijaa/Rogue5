package com.inte.group4;

import java.awt.*;
import java.util.Random;


public class Worm extends Monster {
    //private Point monsterPosition;
    private static final int WORMHP= 100;
    private static final int WORMAP= 300;

    public Worm(Point p) {
        super(10, 14,p);
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

    public Point getMonsterPosition() {
        return currentMonsterCords;
    }
    public String toString() {
        String str = "Worm " + super.toString();
        return str;
    }
}
