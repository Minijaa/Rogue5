package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map newMap;

    @BeforeEach
    void setUp() {
        newMap = new Map();
    }

    @Test
    public void testCreateNewMapObject() {
        assertNotNull(newMap.getLocationFromPoint(new Point(0, 0)));
    }

    @Test
    public void testGridSize() {
        assertEquals(100, newMap.gridSize());

    }
    @Test
    public void testPrintGrid(){
        String actualOutput = newMap.printGrid();

        String expectedOutput =
                "\nO O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O X O O O O O ";

               assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void testSetActivePlayerLocation(){
        newMap.setActivePlayerLocation(3,5);

        Location playerLocation = newMap.getLocationFromPoint(new Point(5,3));

        assertEquals('X',playerLocation.getMapChar());

    }
}