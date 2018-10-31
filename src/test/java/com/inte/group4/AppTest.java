package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    App newTestApp;
    Map map;
    @BeforeEach
    void setUp() throws Exception {
        newTestApp = new App(1);
        map = newTestApp.getMap();
    }

    @Test
    void testNormalizeString() {
        String actualOutput = newTestApp.normalizeString(" unNormalizedString");
        String expectedOutput = "Unnormalizedstring";

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void testTravelDirectionInvalidMove() {
        String expectedOutput = "Invalid move!!";
        String actualOutPut = newTestApp.travelDirection(10, 10);
        assertEquals(expectedOutput, actualOutPut);

    }

    @Test
    void testTravelDirectionValidMove() {
        String str = newTestApp.travelDirection(4, 1);
        assertEquals("Valid move!!", str);
    }

    @Test
    void testGetTreasure(){
        map.setActivePlayerLocation(4,1);
        //newTestApp.getT

    }

}
