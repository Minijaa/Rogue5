package com.inte.group4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	
	Player newPlayer;

//	@BeforeEach
//	void setUp() throws Exception {
//		newPlayer = new Player(5,5);
//	}
	
	@Test
	void createNewPlayerTest() {
		newPlayer = new Player(10,100);
		assertNotNull(newPlayer);
	}
	
	@Test
	void decreasePlayerHpTest() {
		newPlayer = new Player(10,100);
		int attack = 5;
		newPlayer.decreaseHp(attack);
		assertEquals(100 - attack, newPlayer.getHp());
	}
	
	@Test
	void decreasePlayerHpToNegativeTest() {
		newPlayer = new Player(10, 100);
		int attack = 100;
		newPlayer.decreaseHp(attack);
		assertFalse(newPlayer.isAlive());
	}



}
