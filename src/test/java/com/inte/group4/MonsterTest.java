package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

class MonsterTest {

	@Test
	public void isUpOrLeftChangeTest() {
		Ogre testOgre = new Ogre(new Point(6, 7));
		testOgre.setUpOrLeft(true);
		assertTrue(testOgre.getIsUpOrLeft());
		testOgre.setUpOrLeft(false);
		assertFalse(testOgre.getIsUpOrLeft());

	}

	@Test
	public void addToDeadLockTest() {
		Dragon testDragon = new Dragon(new Point(3,6));
	}

	public void resetDeadLockTest() {
		// reset'a osv
	}

}
