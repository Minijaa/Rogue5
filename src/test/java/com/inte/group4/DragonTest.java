package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {
    Dragon testDragon;

    @BeforeEach
    void setUp() throws Exception{
        testDragon = new Dragon(new Point(2, 3));
        testDragon.setUpOrLeft(true);
    }

    @Test
    void testCorrectDragonCords() {
        Point dragonPoint = testDragon.getCurrentMonsterCords();
        Point expectedPoint = new Point(2, 3);
        assertEquals(expectedPoint, dragonPoint);
    }

    @Test
    void testReturnNewPoint() {
        Point newPoint = testDragon.generatePointForMonsterMovement();
        Point expectedPoint = new Point(1, 4);
        assertEquals(expectedPoint, newPoint);
    }

    @Test
    void testRunInToTopLeft() {
        Dragon testTopLeftDragon = new Dragon(new Point(0, 7));
        testTopLeftDragon.setUpOrLeft(true);
        Point newDragonPoint = testTopLeftDragon.generatePointForMonsterMovement();
        Point expectedPoint = new Point(1, 6);
        assertEquals(expectedPoint, newDragonPoint);
    }

    @Test
    void testRunInToBottomR() {
        Dragon testBottomRightDragon = new Dragon(new Point(8, 0));
        testBottomRightDragon.setUpOrLeft(false);
        Point newDragonPoint = testBottomRightDragon.generatePointForMonsterMovement();
        Point expectedPoint = new Point(7, 1);
        assertEquals(expectedPoint, newDragonPoint);
    }

    @Test
    void testExtendedMovement() {
        Dragon extendedMovementDragon = new Dragon(new Point(9, 0));
        extendedMovementDragon.setUpOrLeft(true);
        for (int i = 0; i < 20; i++) {
            extendedMovementDragon.setCurrentMonsterCords(extendedMovementDragon.generatePointForMonsterMovement());
        }
        Point newDragonPoint = extendedMovementDragon.getCurrentMonsterCords();
        Point expectedPoint = new Point(7, 2);
        assertEquals(expectedPoint, newDragonPoint);
    }
    
    @Test
    void toStringDragonTest() {
    	Dragon testDragon = new Dragon(new Point(3,2));
    	String expectedtoString = "Dragon AP:300 HP:500 cords: 3:2";
    	assertEquals(expectedtoString, testDragon.toString());
    }
}