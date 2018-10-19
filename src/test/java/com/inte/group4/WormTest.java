package com.inte.group4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WormTest {
    Worm testWorm;

    @BeforeEach
    void setup() {
        testWorm = new Worm();
    }

    @Test
    void moveMonsterTest() {
        Point oldPosition = testWorm.getMonsterPosition();
        testWorm.moveMonster();
        Point newPosition = testWorm.getMonsterPosition();
        int x = newPosition.x;
        int y = newPosition.y;
        assertTrue(x >= 0 && x < 10 && y >= 0 && y < 10);
        assertFalse(oldPosition != null && oldPosition.equals(newPosition));
    }

    @Test
    void decreaseHp() {

    }
}