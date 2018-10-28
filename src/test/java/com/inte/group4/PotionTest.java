package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {
    private Potion testMassivePotion;
    private Potion testMajorPotion;
    private Potion testMinorPotion;

    @BeforeEach
    void setUp() {
        testMassivePotion = new Potion(Integer.MAX_VALUE);
        testMajorPotion = new Potion(499);
        testMinorPotion = new Potion(Integer.MIN_VALUE);
    }

    @Test
    void testCreatingPotions() {
        assertEquals(1000000, testMassivePotion.getHpIncreaseValue());
        assertEquals(500, testMajorPotion.getHpIncreaseValue());
        assertEquals(200, testMinorPotion.getHpIncreaseValue());
    }

    @Test
    void testCompareTo() {
        Potion newMassivePotion = new Potion(600);
        assertEquals(-1, testMinorPotion.compareTo(testMajorPotion));
        assertEquals(0, testMassivePotion.compareTo(newMassivePotion));
        assertEquals(1, testMajorPotion.compareTo(testMinorPotion));
    }

    @Test
    void testToStringAndIndirectlyDetermineType() {
        assertEquals("Potion of Minor Healing: +200 HP",testMinorPotion.toString());
        assertEquals("Potion of Major Healing: +500 HP",testMajorPotion.toString());
        assertEquals("Potion of Massive Healing: +1000000 HP",testMassivePotion.toString());
    }
}