package com.inte.group4;

import java.awt.*;

public class Worm extends Monster {
    private static final int WORMHP = 200;
    private static final int WORMAP = 400;
    private int wormGrowth;

    public Worm(Point p) {
        super(WORMAP, WORMHP, p);
        setMonsterChar('W');
    }

    @Override
    public Point generatePointForMonsterMovement() {
        Point oldPosition = currentMonsterCords;
        Point newPosition;
        checkForBoundaries(oldPosition);
        if (isUpOrLeft()) {
            newPosition = new Point(oldPosition.x, (oldPosition.y + 1));
        } else {
            newPosition = new Point(oldPosition.x, (oldPosition.y - 1));
        }
        return newPosition;
    }

    protected void checkForBoundaries(Point oldPosition) {
        if (oldPosition.y == 0) {
            setUpOrLeft(true);
        } else if (oldPosition.y == 9) {
            setUpOrLeft(false);
        }
    }

    public void grow() {
        wormGrowth++;
        if (wormGrowth == 5) {
            this.setCurrentAp(600);
        } else if (wormGrowth == 10) {
            this.setCurrentAp(800);
        }
    }


    public String toString() {
        String str = "Worm " + super.toString();
        return str;
    }
}
