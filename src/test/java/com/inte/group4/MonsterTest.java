package com.inte.group4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

class MonsterTest {

	@Test
	void isUpOrLeftChangeTest() {
		Ogre testOgre = new Ogre(new Point(6, 7));
		testOgre.setUpOrLeft(true);
		assertTrue(testOgre.getIsUpOrLeft());
		testOgre.setUpOrLeft(false);
		assertFalse(testOgre.getIsUpOrLeft());
	}

	@Test
	void addToDeadLockTest() {
		Dragon testDragon = new Dragon(new Point(3, 6));
		testDragon.incrementDeadLockCounter();
		assertEquals(1, testDragon.getDeadLockCounter());
	}

	@Test
	void resetDeadLockTest() {
		Worm testWorm = new Worm(new Point(3, 6));
		testWorm.incrementDeadLockCounter();
		testWorm.incrementDeadLockCounter();
		testWorm.incrementDeadLockCounter();
		testWorm.resetDeadLockCounter();
		assertEquals(0, testWorm.getDeadLockCounter());
	}

}
