package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {
    Dragon testDragon;

    @BeforeEach
    void setUp() {
        testDragon = new Dragon(new Point(2, 3));
        testDragon.setUpOrLeft(true);
    }

    @Test
    public void testCorrectDragonCords() {
        Point dragonPoint = testDragon.getCurrentMonsterCords();
        Point expectedPoint = new Point(2, 3);
        assertEquals(expectedPoint, dragonPoint);
    }

    @Test
    public void testReturnNewPoint() {
        Point newPoint = testDragon.moveMonster();
        Point expectedPoint = new Point(1, 4);
        assertEquals(expectedPoint, newPoint);
    }

    @Test
    public void testRunInToTopLeft() {
        Dragon testTopLeftDragon = new Dragon(new Point(0, 7));
        testTopLeftDragon.setUpOrLeft(true);
        Point newDragonPoint = testTopLeftDragon.moveMonster();
        Point expectedPoint = new Point(1, 6);
        assertEquals(expectedPoint, newDragonPoint);
    }

    @Test
    public void testRunInToBottomR() {
        Dragon testBottomRightDragon = new Dragon(new Point(8, 0));
        testBottomRightDragon.setUpOrLeft(false);
        Point newDragonPoint = testBottomRightDragon.moveMonster();
        Point expectedPoint = new Point(7, 1);
        assertEquals(expectedPoint, newDragonPoint);
    }

    @Test
    public void testExtendedMovement() {
        Dragon extendedMovementdragon = new Dragon(new Point(9, 0));
        extendedMovementdragon.setUpOrLeft(true);
        for (int i = 0; i < 20; i++) {
            extendedMovementdragon.setCurrentMonsterCords(extendedMovementdragon.moveMonster());
        }
        Point newDragonPoint = extendedMovementdragon.getCurrentMonsterCords();
        Point expectedPoint = new Point(7, 2);
        assertEquals(expectedPoint, newDragonPoint);
    }
}