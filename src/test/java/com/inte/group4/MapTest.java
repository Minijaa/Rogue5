package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map newMap = new Map();

    @Test
    void testCreateNewMapObject() {
        assertNotNull(newMap.getLocationFromPoint(new Point(0, 0)));
    }

    @Test
    void newMapObjectNotNullTest() {
        assertNotNull(newMap);
    }

    @Test
    void testGridSize() {
        assertEquals(100, newMap.gridSize());

    }

    @Test
    void monsterSizeTest() {
        assertEquals(15, newMap.getMonsterListSize());
    }

    @Test
    void getActivePlayerLocationTest() {
        Location activePlayerLocation = newMap.getActivePlayerLocation();
        Location playerLocationAtStart = new Location(new Point(4, 0));
        assertEquals(playerLocationAtStart.getPosition(), activePlayerLocation.getPosition());
    }


    // Känns som att testet är sådär, bör location hämtas från removedMonster eller testDragon?
    @Test
    void removeMonsterTest() {
        Dragon testDragonToRemove = new Dragon(new Point(5, 6));
        Monster removedMonster = newMap.removeMonster(testDragonToRemove);
        Location locationWithoutMonster = newMap.getLocationFromPoint(removedMonster.getCurrentMonsterCords());

        assertEquals(testDragonToRemove, removedMonster);
        assertEquals("silence", locationWithoutMonster.getLocationText());
        assertNull(locationWithoutMonster.getMonster());
    }

    @Test
    void testPrintGrid() {
        String actualOutput = newMap.printGrid();
        String expectedOutput =
                "\nW O O O W O O O W O \n" +
                        "O O O O O O O O O O \n" +
                        "# O O O O O O G O O \n" +
                        "O O O O O # O O O O \n" +
                        "O O O O G O O O O O \n" +
                        "O G O O O O O O O O \n" +
                        "O O # O O O O # O G \n" +
                        "O O G O O O O O O O \n" +
                        "O O O O O O O O O O \n" +
                        "O O W O X O W O # O ";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testSetActivePlayerLocation() {
        newMap.setActivePlayerLocation(3, 5);
        Location playerLocation = newMap.getLocationFromPoint(new Point(3, 5));
        assertEquals('X', playerLocation.getMapChar());
    }

    // Kristina
    @Test
    void testMonsterIsTheSameInListAndOnGrid() {
        Monster monsterInArrayList = newMap.getMonsterFromList(13);
        Location expectedMonsterLocation = newMap.getLocationFromPoint(new Point(6, 0));
        Monster expectedMonsterAtLocation = expectedMonsterLocation.getMonster();
        assertEquals(expectedMonsterAtLocation, monsterInArrayList);
    }

    // Kristina
    @Test
    void testRndCords() {
        int x, y;
        int belowZero = -1;
        int above9 = 10;

        for (int i = 0; i < 100; i++) {
            Point pointToTest = new Point(newMap.rndCords());
            x = pointToTest.x;
            y = pointToTest.y;
            assertNotEquals(x, belowZero);
            assertNotEquals(x, above9);
            assertNotEquals(y, belowZero);
            assertNotEquals(y, above9);
        }
    }

    // Kristina
    @Test
    void testMoveAllMonsters() {
        Monster monsterInArrayList = newMap.getMonsterFromList(5);
        // Location originalLocation =
        // newMap.getLocationFromPoint(monsterInArrayList.getCurrentMonsterCords());
        newMap.moveAllMonsters();
        Point pointAfterMove = monsterInArrayList.getCurrentMonsterCords();
        Location locationAfterMove = newMap.getLocationFromPoint(pointAfterMove);
        Point expectedPoint = new Point(6, 5);
        Location expectedLocation = newMap.getLocationFromPoint(expectedPoint);
        assertEquals(expectedLocation, locationAfterMove);
        assertEquals(expectedPoint, pointAfterMove);
    }

    // Kristina
    @Test
    void testMapCharUpdateAtNewLocationOnMove() {
        Monster monsterInArrayList = newMap.getMonsterFromList(8);
        newMap.moveAllMonsters();
        Location newLocation = newMap.getLocationFromPoint(monsterInArrayList.getCurrentMonsterCords());
        assertEquals(monsterInArrayList.getMonsterChar(), newLocation.getMapChar());
    }

    // Kristina
    @Test
    void testMapCharUpdateAtOldLocationOnMove() {
        Monster monsterInArrayList = newMap.getMonsterFromList(14);
        Location oldLocation = newMap.getLocationFromPoint(monsterInArrayList.getCurrentMonsterCords());
        newMap.moveAllMonsters();
        assertNotEquals(monsterInArrayList.getMonsterChar(), oldLocation.getMapChar());
    }

    // fill out
    @Test
    void testMultipleMonsterMoves() {
        for (int i = 0; i < 5; i++) {
            newMap.moveAllMonsters();
        }
    }
}