package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WormTest {
    private Worm testWorm;

    @BeforeEach
    void setup() {
        testWorm = new Worm(new Point(1, 1));
    }

    @Test
    void moveMonsterTest() {
        Point oldPosition = testWorm.getCurrentMonsterCords();
        testWorm.setUpOrLeft(true); //Tell worm to travel upwards
        Point newPosition = testWorm.moveMonster();
        assertTrue(newPosition.x == oldPosition.x && newPosition.y == (oldPosition.y + 1));
        testWorm.setUpOrLeft(false); //Tell worm to travel downwards
        newPosition = testWorm.moveMonster();
        assertTrue(newPosition.equals(oldPosition));
    }

    @Test
    void testBoundaries() {
        Worm lowerBoundaryWorm = new Worm(new Point(4, 0));
        Worm upperBoundaryWorm = new Worm(new Point(4, 9));

        lowerBoundaryWorm.setUpOrLeft(false); //Tell worm to travel downwards
        upperBoundaryWorm.setUpOrLeft(true); //Tell worm to travel upwards
        Point lowerWormPosition = lowerBoundaryWorm.moveMonster();
        Point upperWormPosition = upperBoundaryWorm.moveMonster();

        assertTrue(lowerWormPosition.equals(new Point(4, 1)) && upperWormPosition.equals(new Point(4, 8)));
        assertTrue(lowerBoundaryWorm.getIsUpOrLeft());
        assertFalse(upperBoundaryWorm.getIsUpOrLeft());
    }
}