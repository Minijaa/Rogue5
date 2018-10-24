package com.inte.group4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// För randomgenerering av items, använd switch som kan skicka in olika argument. Se MapTest.

class PlayerTest {

	Player newPlayer;

	@BeforeEach
	void setUp() throws Exception {
		newPlayer = new Player(10, 1000);
	}

	@Test
	public void createNewPlayerTest() {
		assertNotNull(newPlayer);
	}

	@Test
	public void decreasePlayerHpTest() {
		int attack = 100;
		newPlayer.decreaseHp(attack);
		assertEquals(900, newPlayer.getCurrentHp());
	}

	@Test
	public void decreasePlayerHpToNegativeTest() {
		int attack = 1000;
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

	@Test
	public void useMinorPotionTest() {
		Potion minorPotion = new Potion(200);
		newPlayer.decreaseHp(300);
		int hurtPlayerHp = newPlayer.getCurrentHp();
		newPlayer.useItem(minorPotion);
		assertEquals(hurtPlayerHp + minorPotion.getHpIncreaseValue(), newPlayer.getCurrentHp());
	}

	@Test
	public void useUltimatePotionTest() {
		Potion ultimatePotion = new Potion(501);
		newPlayer.decreaseHp(900);
		int hurtPlayerHp = newPlayer.getCurrentHp();
		newPlayer.useItem(ultimatePotion);
		assertEquals(hurtPlayerHp + ultimatePotion.getHpIncreaseValue(), newPlayer.getCurrentHp());
	}

	@Test
	public void useScrollOfPower() {
		Scroll powerScroll = new Scroll(1, 1);
		int oldMaxHp = newPlayer.getMaxHp();
		int oldMaxAp = newPlayer.getAp();
		newPlayer.useItem(powerScroll);
		assertEquals(oldMaxHp + powerScroll.getMaxHpBuff(), newPlayer.getMaxHp());
		assertEquals(oldMaxAp + powerScroll.getMaxApBuff(), newPlayer.getAp());
	}

	public void useBandage() {
		Bandage newBandage = new Bandage();
		newPlayer.decreaseHp(500);
		int hurtPlayerHp = newPlayer.getCurrentHp();
		newPlayer.useItem(newBandage);
		assertEquals(hurtPlayerHp + newBandage.getHpIncreaseValue(), newPlayer.getCurrentHp());
	}

}
