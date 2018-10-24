package com.inte.group4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Player newPlayer;

	@BeforeEach
	void setUp() throws Exception {
		newPlayer = new Player(10, 1000);
	}

	Item spawnItem() {
		Random rnd = new Random();
		int ap = rnd.nextInt(10);
		int hp = rnd.nextInt(500);
		int itemType = rnd.nextInt(2);
		Item newItem;
		switch (itemType) {
		case 0:
			newItem = new Potion(hp);
			break;
		case 1:
			newItem = new Scroll(ap, hp);
			break;
		case 2:
			newItem = new Bandage();
			break;
		default:
			newItem = new Bandage();
		}

		return newItem;
	}

	@Test
	public void createNewPlayerTest() {
		assertNotNull(newPlayer);
	}

	// Borde detta test vara i Sprite istället? Antagligen.
	@Test
	public void decreasePlayerHpTest() {
		int attack = 100;
		newPlayer.decreaseHp(attack);
		assertEquals(900, newPlayer.getCurrentHp());
	}

	// Borde detta test vara i Sprite istället? Antagligen.
	@Test
	public void decreasePlayerHpToNegativeTest() {
		int attack = 1000;
		newPlayer.decreaseHp(attack);
		assertFalse(newPlayer.isAlive());
	}

	@Test
	public void addNullItemToPlayerInventoryTest() {
		String nullItemString = newPlayer.addToInventory(null);
		assertNull(nullItemString);
	}

	@Test
	public void addItemToPlayerInventoryTest() {
		Item itemToBeAdded = spawnItem();
		String acceptedAddString = newPlayer.addToInventory(itemToBeAdded);
		assertEquals(1, newPlayer.getInventorySize());
		assertEquals("", acceptedAddString);
	}

	@Test
	public void fillPlayerInventoryTest() {
		while (newPlayer.getInventorySize() < Player.getMaxInventory()) {
			Item newItem = spawnItem();
			newPlayer.addToInventory(newItem);
		}
		Item oneTooMany = spawnItem();
		String inventoryFullString = newPlayer.addToInventory(oneTooMany);
		assertEquals("Cannot add item, inventory is full!", inventoryFullString);
	}

	@Test
	public void removeFromPlayerInventoryByObjectTest() {
		Item firstItem = spawnItem();
		Item itemToRemove = spawnItem();
		newPlayer.addToInventory(firstItem);
		newPlayer.addToInventory(itemToRemove);
		Item removedItem = newPlayer.removeFromInventory(itemToRemove);
		assertEquals(1, newPlayer.getInventorySize());
		assertEquals(itemToRemove, removedItem);
	}

	@Test
	public void removeFromPlayerInventoryByIndexTest() {
		Item itemToRemove = spawnItem();
		newPlayer.addToInventory(spawnItem());
		newPlayer.addToInventory(itemToRemove);
		newPlayer.addToInventory(spawnItem());
		Item removedItem = newPlayer.removeFromInventory(1);
		assertEquals(2, newPlayer.getInventorySize());
		assertEquals(itemToRemove, removedItem);
	}

	@Test
	public void removeNullItemFromPlayerInventoryTest() {
		Item nullItem = newPlayer.removeFromInventory(null);
		assertNull(nullItem);
	}

	@Test
	public void removeIncorrectIndexFromPlayerInventoryTest() {
		Item IncorrectIndexItem = newPlayer.removeFromInventory(5);
		assertNull(IncorrectIndexItem);
	}

	// Onödigt test pga vi testar redan att lägga till och ta bort?
	@Test
	public void fillAndThenRemoveFromPlayerInventoryTest() {
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
	public void getItemFromInventoryTest() {
		Item itemToGet = spawnItem();
		newPlayer.addToInventory(spawnItem());
		newPlayer.addToInventory(itemToGet);
		newPlayer.addToInventory(spawnItem());
		Item gottenItem = newPlayer.getItemByIndex(1);
		assertEquals(itemToGet, gottenItem);
	}

	@Test
	public void getIncorrectIndexItemFromInventoryTest() {
		Item incorrectIndexItem = newPlayer.getItemByIndex(5);
		assertNull(incorrectIndexItem);
	}

	@Test
	public void useNullItemTest() {
		int resultOfUseItem = newPlayer.useItem(null);
		assertEquals(0, resultOfUseItem);

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
	public void useScrollOfPowerTest() {
		Scroll powerScroll = new Scroll(1, 1);
		int oldMaxHp = newPlayer.getMaxHp();
		int oldAp = newPlayer.getAp();
		newPlayer.useItem(powerScroll);
		assertEquals(oldMaxHp + powerScroll.getMaxHpBuff(), newPlayer.getMaxHp());
		assertEquals(oldAp + powerScroll.getMaxApBuff(), newPlayer.getAp());
	}

	public void useBandageTest() {
		Bandage newBandage = new Bandage();
		newPlayer.decreaseHp(500);
		int hurtPlayerHp = newPlayer.getCurrentHp();
		newPlayer.useItem(newBandage);
		assertEquals(hurtPlayerHp + newBandage.getHpIncreaseValue(), newPlayer.getCurrentHp());
	}

}
