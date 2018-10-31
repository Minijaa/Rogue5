package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    App newTestApp;
    Map map;
    Player player;

    @BeforeEach
    void setUp() throws Exception {
        newTestApp = new App(1);
        map = newTestApp.getMap();
        player = newTestApp.getPlayer();

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
    void testValidGetTreasure(){
        map.setActivePlayerLocation(4,1);
        int validCheck= newTestApp.getTreasure();
        assertEquals(1, validCheck);
    }

    @Test
    void testInvalidGetTreasure(){
        map.setActivePlayerLocation(4,2);
        int validCheck= newTestApp.getTreasure();
        assertEquals(-1, validCheck);
    }

    @Test
    void testFullInventoryGetTreasure(){
        player.addItemToInventory(new Potion(200));
        player.addItemToInventory(new Potion(200));
        player.addItemToInventory(new Potion(200));
        player.addItemToInventory(new Potion(200));
        player.addItemToInventory(new Potion(200));
        map.setActivePlayerLocation(4,1);
        int validCheck= newTestApp.getTreasure();
        assertEquals(0, validCheck);
    }
    @Test
    void testCheckMonsterAtLocation() {
        assertFalse(newTestApp.checkMonsterAtLocation());
        map.getLocationFromPoint(new Point(4, 0)).setMonster(new Worm(new Point(4, 0)));
        assertTrue(newTestApp.checkMonsterAtLocation());
    }
    @Test
    void lastMonsterOnMapTrueTest() {
        ArrayList<Monster> removeableMonsterList = new ArrayList<Monster>();

        for(int i = 0; i < map.getMonsterListSize(); i++) {
            Monster m = map.getMonsterFromList(i);
            removeableMonsterList.add(m);
        }
        for(Monster m : removeableMonsterList) {
            map.removeMonster(m);
        }
        boolean isLastMonster = newTestApp.lastMonsterOnMap();
        assertTrue(isLastMonster);
    }

    @Test
    void lastMonsterOnMapFalseTest() {
        boolean isLastMonster = newTestApp.lastMonsterOnMap();
        assertFalse(isLastMonster);
    }
}
