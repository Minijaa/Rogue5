package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BandageTest {
	private Bandage dirtyBandage;
	private Bandage cleanishBandage;
	private Bandage sterileBandage;

	@BeforeEach
	void setUp() {
		boolean allKindsOfBandagesCreated = false;
		while (!allKindsOfBandagesCreated) {
			Bandage b = new Bandage();
			if (b.getHpIncreaseValue() <= 250) {
				dirtyBandage = b;
			} else if (b.getHpIncreaseValue() <= 350) {
				cleanishBandage = b;
			} else {
				sterileBandage = b;
			}
			if (dirtyBandage != null && cleanishBandage != null && sterileBandage != null) {
				allKindsOfBandagesCreated = true;
			}
		}
	}
	@Test
	void dirtyBandageHpTest() {
		assertTrue(dirtyBandage.getHpIncreaseValue() <= 250);
	}

	@Test
	void cleanishBandageHpTest() {
		assertTrue(cleanishBandage.getHpIncreaseValue() <= 350 && cleanishBandage.getHpIncreaseValue() > 250);
	}

	@Test
	void sterileBandageHpTest() {
		assertTrue(sterileBandage.getHpIncreaseValue() > 350);
	}

	@Test
	void testCompareTo() {
		Bandage newDirtyBandage = new Bandage();
		newDirtyBandage.setHpIncreaseValue(dirtyBandage.getHpIncreaseValue());
		assertEquals(1, sterileBandage.compareTo(cleanishBandage));
		assertEquals(-1, dirtyBandage.compareTo(cleanishBandage));
		assertEquals(0, dirtyBandage.compareTo(newDirtyBandage));
	}

	@Test
	void testToStringAndIndirectlyDetermineType() {
		assertEquals("Dirty Bandage: +" + dirtyBandage.getHpIncreaseValue() + " HP", dirtyBandage.toString());
		assertEquals("Cleanish Bandage: +" + cleanishBandage.getHpIncreaseValue() + " HP", cleanishBandage.toString());
		assertEquals("Sterile Bandage: +" + sterileBandage.getHpIncreaseValue() + " HP", sterileBandage.toString());
	}
	
	@Test
	void equalsBandageCorrectTest() {
		Bandage b1 = new Bandage();
		Bandage b2 = b1;
		assertEquals(b1, b2);
	}
	
	@Test
	void equalsBandageNotCorrectTest() {
		Bandage b1 = new Bandage();
		Bandage b2 = new Bandage();
		assertNotEquals(b1, b2);
	}
	
	@Test
	void equalsBandageAndPotionTest() {
		Bandage testBandage = new Bandage();
		Potion testPotion = new Potion(200);
		assertNotEquals(testBandage, testPotion);
	}
}