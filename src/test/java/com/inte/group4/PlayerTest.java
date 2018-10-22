package com.inte.group4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Måste skriva om tester pga inventory nu har item, ej strings.
// RIP TESTER NEVER FORGET

class PlayerTest {

	Player newPlayer;

	@BeforeEach
	void setUp() throws Exception {
		newPlayer = new Player(10,100);
	}

	@Test
	public void createNewPlayerTest() {
		Player newHpPlayer = new Player(10, 100);
		assertNotNull(newPlayer);
	}

	@Test
	public void decreasePlayerHpTest() {
		Player newHpPlayer = new Player(10, 100);
		int attack = 5;
		newPlayer.decreaseHp(attack);
		assertEquals(100 - attack, newPlayer.getCurrentHp());
	}

	@Test
	public void decreasePlayerHpToNegativeTest() {
		Player newHpPlayer = new Player(10, 100);
		int attack = 100;
		newPlayer.decreaseHp(attack);
		assertFalse(newPlayer.isAlive());
	}
	
	@Test
	public void fillPlayerInventory() {
		newPlayer.addToInventory("Object 1");
		newPlayer.addToInventory("Object 2");
		newPlayer.addToInventory("Object 3");
		newPlayer.addToInventory("Object 4");
		newPlayer.addToInventory("Object 5");
		newPlayer.addToInventory("Object 6");
		assertEquals(5, newPlayer.getInventorySize());
	}
	
	@Test
	public void removeFromPlayerInventoryByObject() {
		newPlayer.addToInventory("Object 1");
		newPlayer.removeFromInventory("Object 1");
		assertEquals(0, newPlayer.getInventorySize());
	}
	
	@Test
	public void removeFromPlayerInventoryByIndex() {
		newPlayer.addToInventory("Object 1");
		newPlayer.addToInventory("Object 2");
		newPlayer.addToInventory("Object 3");
		newPlayer.removeFromInventory(2);
		assertEquals(2, newPlayer.getInventorySize());
	}
	
	@Test
	public void fillAndThenRemoveFromPlayerInventory() {
		newPlayer.addToInventory("Object 1");
		newPlayer.addToInventory("Object 2");
		newPlayer.addToInventory("Object 3");
		newPlayer.addToInventory("Object 4");
		newPlayer.addToInventory("Object 5");
		newPlayer.addToInventory("Object that shouldn't be added");
		newPlayer.removeFromInventory("Object 5");
		newPlayer.addToInventory("Object 6");
		assertEquals("Object 6", newPlayer.getItemByIndex(4));
	}

}
