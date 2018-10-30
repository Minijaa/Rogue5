package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrollTest {
	private Scroll testHealthScroll;
	private Scroll testStrengthScroll;
	private Scroll testPowerScroll;

	@BeforeEach
	void setUp() {
		testHealthScroll = new Scroll(false, true);
		testStrengthScroll = new Scroll(true, false);
		testPowerScroll = new Scroll(true, true);
	}

	@Test
	void testCreatingScrolls() {
		assertEquals(500, testHealthScroll.getMaxHpBuff());
		assertEquals(300, testStrengthScroll.getMaxApBuff());
		assertEquals(200, testPowerScroll.getMaxApBuff());
	}

	@Test
	void testCompareTo() {
		Scroll newStrengthScroll = new Scroll(true, false);
		assertEquals(1, testPowerScroll.compareTo(testHealthScroll));
		assertEquals(-1, testStrengthScroll.compareTo(testHealthScroll));
		assertEquals(0, testStrengthScroll.compareTo(newStrengthScroll));
	}

	@Test
	void testToStringAndIndirectlyDetermineType() {
		assertEquals("Scroll of Health: +500 Max HP", testHealthScroll.toString());
		assertEquals("Scroll of Strength: +300 AP", testStrengthScroll.toString());
		assertEquals("Scroll of Power: +200 AP / +400 Max HP", testPowerScroll.toString());
	}

	@Test
	void equalsScrollCorrectTest() {
		Scroll s1 = new Scroll(false, false);
		Scroll s2 = s1;
		assertEquals(s1, s2);
	}

	@Test
	void equalsScrollNotCorrectTest() {
		Scroll s1 = new Scroll(false, false);
		Scroll s2 = new Scroll(true, false);
		assertNotEquals(s1, s2);
	}

	@Test
	void equalsScrollAndBandageTest() {
		Scroll testScroll = new Scroll(true, true);
		Bandage testBandage = new Bandage();
		assertNotEquals(testScroll, testBandage);
	}
}