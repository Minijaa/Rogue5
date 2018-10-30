package com.inte.group4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

class OgreTest {
	Ogre newOgre;

	@Test
	void testCreateOgre() {
		newOgre = new Ogre(new Point(4, 4));
		assertNotNull(newOgre);
	}

	@Test
	void moveOgreMonsterTestLeft() {
		newOgre = new Ogre(new Point(4, 4));
		for (int i = 0; i < 6; i++) {
			newOgre.setCurrentMonsterCords(newOgre.generatePointForMonsterMovement());
		}
		Point newOgrePoint = newOgre.getCurrentMonsterCords();
		Point expected = new Point(2, 4);
		assertEquals(expected, newOgrePoint);
	}

	@Test
	void moveOgreMonsterTestLeftTurnRight() {
		newOgre = new Ogre(new Point(0, 4));
		for (int i = 0; i < 20; i++) {
			newOgre.setCurrentMonsterCords(newOgre.generatePointForMonsterMovement());
		}
		Point newOgrePoint = newOgre.getCurrentMonsterCords();
		Point expected = new Point(2, 4);
		assertEquals(expected, newOgrePoint);
	}

	@Test
	void toStringOgreTest() {
		Ogre testOgre = new Ogre(new Point(3, 2));
		String expectedtoString = "Ogre AP:100 HP:300 cords: 3:2";
		assertEquals(expectedtoString, testOgre.toString());
	}
}
