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
    public void createNewMapObject() {
        assertNotNull(newMap.getLocationFromPoint(new Point(0, 0)));
    }

    @Test
    public void gridSize() {
        assertEquals(100, newMap.gridSize());

    }
}