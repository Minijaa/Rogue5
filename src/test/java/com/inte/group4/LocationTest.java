package com.inte.group4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

	Location testLocation;

	@Test
	public void testPlayerEntersLocationWithMonster() {
		Point p = new Point(0, 0);
		testLocation = new Location(p);
		Monster m = (Monster) new Ogre(p);
		testLocation.setMonster(m);

		String actual = testLocation.playerEntersLocation();
		assertEquals("FIGHT!!!", actual);

	}

	@Test
	public void testPlayerEntersLocationWithNoMonster() {
		Point p = new Point(0, 0);
		testLocation = new Location(p);

		String actual = testLocation.playerEntersLocation();
		assertEquals("silence", actual);
	}

	@Test
	public void setLocationAsVisitedTest() {
		testLocation = new Location(new Point(4, 5));
		testLocation.setVisited(true);
		boolean isLocationVisited = testLocation.isVisited();
		assertTrue(isLocationVisited);
	}

	@Test
	public void setMapCharMonsterTest() {
		Point p = new Point(6, 7);
		testLocation = new Location(p);
		Worm testWorm = new Worm(p);
		testLocation.setMonster(testWorm);
		int returnChar = testLocation.setMapChar();
		assertEquals(2, returnChar);
	}

	@Test
	public void setMapCharUnvisitedTest() {
		testLocation = new Location(new Point(6, 7));
		int returnChar = testLocation.setMapChar();
		assertEquals(0, returnChar);

	}

	@Test
	public void setMapCharVisitedTest() {
		testLocation = new Location(new Point(6, 7));
		testLocation.setVisited(true);
		int returnChar = testLocation.setMapChar();
		assertEquals(1, returnChar);
	}

	@Test
	public void getTreasureTest() {
		testLocation = new Location(new Point(6, 7));
		Potion treasure = new Potion(501);
		testLocation.setTreasure(treasure);
		assertEquals(treasure, testLocation.getTreasure());
	}

	@Test
	public void getTreasureIsNullTest() {
		testLocation = new Location(new Point(6, 7));
		assertNull(testLocation.getTreasure());
	}

	@Test
	public void removeTreasureTest() {
		testLocation = new Location(new Point(6, 7));
		Potion treasure = new Potion(501);
		testLocation.setTreasure(treasure);
		Item removedTreasure = testLocation.removeTreasure();
		assertEquals(removedTreasure, treasure);
	}

}