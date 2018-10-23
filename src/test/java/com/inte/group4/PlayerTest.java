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
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(new Potion(200));
		Potion oneTooManyPotion = new Potion(200);
		newPlayer.addToInventory(oneTooManyPotion);
		assertEquals(5, newPlayer.getInventorySize());
	}
	
	@Test
	public void removeFromPlayerInventoryByObject() {
		Potion potionToRemove = new Potion(200);
		newPlayer.addToInventory(potionToRemove);
		newPlayer.removeFromInventory(potionToRemove);
		assertEquals(0, newPlayer.getInventorySize());
	}
	
	@Test
	public void removeFromPlayerInventoryByIndex() {
		Potion secondPotion = new Potion(200);
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(secondPotion);
		newPlayer.addToInventory(new Potion(200));
		newPlayer.removeFromInventory(2);
		assertEquals(2, newPlayer.getInventorySize());
	}
	
	@Test
	public void fillAndThenRemoveFromPlayerInventory() {
		Potion potionToRemove = new Potion(200);
		Potion potionToAdd = new Potion(200);
		
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(new Potion(200));
		newPlayer.addToInventory(potionToRemove);
		newPlayer.addToInventory(potionToAdd);
		newPlayer.removeFromInventory(potionToRemove);
		newPlayer.addToInventory(potionToAdd);
		assertEquals(potionToAdd, newPlayer.getItemByIndex(4));
	}

}
