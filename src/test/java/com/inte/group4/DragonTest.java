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
    public void testReturnNewPoint() {
        Point oldPoint = testDragon.getCurrentMonsterCords();
        int oldX = oldPoint.x;
        int oldY = oldPoint.y;
        Point newPoint = testDragon.moveMonster();
        int newX = newPoint.x;
        int newY = newPoint.y;
        assertTrue(newX == (oldX - 1) && newY == (oldY + 1));
    }
    @Test
    public void testRunInToTopLeft() {
        Dragon testTopLeftDragon = new Dragon(new Point(0, 7));
        testTopLeftDragon.setUpOrLeft(true);
        Point oldPoint = testTopLeftDragon.getCurrentMonsterCords();
        int oldX = oldPoint.x;
        int oldY = oldPoint.y;
        Point newPoint = testTopLeftDragon.moveMonster();
        int newX = newPoint.x;
        int newY = newPoint.y;
        assertTrue(newX == (oldX + 1) && newY == (oldY - 1));
    }

    @Test
    public void testRunInToBottomR() {
        Dragon testBottomRightDragon = new Dragon(new Point(8, 0));
        testBottomRightDragon.setUpOrLeft(false);
        Point oldPoint = testBottomRightDragon.getCurrentMonsterCords();
        int oldX = oldPoint.x;
        int oldY = oldPoint.y;
        Point newPoint = testBottomRightDragon.moveMonster();
        int newX = newPoint.x;
        int newY = newPoint.y;
        assertTrue(newX == (oldX - 1) && newY == (oldY + 1));
    }

    @Test
    public void testMovedToNonePlayerLocation() {
        //dragon.Move();
        //assertNotEquals(Map.getActivePlayerLocation(), dragon.getCurrentMonsterLocation());

    }


}