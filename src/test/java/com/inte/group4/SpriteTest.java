package com.inte.group4;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpriteTest {

	Player testPlayer;

	@Test
	public void decreasePlayerHpTest() {
		testPlayer = new Player(100, 1000);
		int attack = 100;
		testPlayer.decreaseHp(attack);
		assertEquals(900, testPlayer.getCurrentHp());
	}

	@Test
	public void decreasePlayerHpToNegativeTest() {
		testPlayer = new Player(100, 1000);
		int attack = 1000;
		testPlayer.decreaseHp(attack);
		assertFalse(testPlayer.isAlive());
	}
	
	@Test
	public void getPlayerApTest() {
		testPlayer = new Player(100, 1000);
		int attack = testPlayer.attack();
		assertEquals(100, attack);
	}

	@Test
	public void getOgreApTest() {
		Ogre testOgre = new Ogre(new Point(5,6));
		int attack = testOgre.attack();
		assertEquals(100, attack);
	}

	

}
