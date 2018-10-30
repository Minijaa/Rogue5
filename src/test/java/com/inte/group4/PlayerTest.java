package com.inte.group4;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Player newPlayer;
	Player largeInventroyPlayer;

	@BeforeEach
	void setUp() throws Exception {
		newPlayer = new Player(10, 1000);
	}

	Item spawnItem() {
		Random rnd = new Random();
		boolean apForScroll = rnd.nextBoolean();
		boolean hpForScroll = rnd.nextBoolean();
		int hpForPotion = rnd.nextInt(500);
		int itemType = rnd.nextInt(3);
		Item newItem;
		switch (itemType) {
		case 0:
			newItem = new Potion(hpForPotion);
			break;
		case 1:
			newItem = new Scroll(apForScroll, hpForScroll);
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
		assertEquals("You found " + itemToBeAdded.toString(), acceptedAddString);
	}

	@Test
	public void fillPlayerInventoryTest() {
		while (newPlayer.getInventorySize() < newPlayer.getMaxInventory()) {
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
	void printInventoryThatIsEmptyTest() {
		int inventoryResult = newPlayer.printInventory();
		assertEquals(0, inventoryResult);
	}

	@Test
	void printInventoryWithOneItemTest() {
		Item newItem = spawnItem();
		newPlayer.addToInventory(newItem);
		int inventoryResult = newPlayer.printInventory();
		assertEquals(2, inventoryResult);
	}
	
	@Test
	void printInventoryWithManyItemsTest() {
		Player playerWithBigInventory = new Player(100,1000, 50);
		for(int i = 0; i < 50; i++) {
			Item newItem = spawnItem();
			playerWithBigInventory.addToInventory(newItem);
		}
		int inventoryResult = playerWithBigInventory.printInventory();
		assertEquals(51, inventoryResult);
	}

	@Test
	void useMinorPotionTest() {
		Potion minorPotion = new Potion(200);
		newPlayer.decreaseHp(300);
		int hurtPlayerHp = newPlayer.getCurrentHp();
		newPlayer.useItem(minorPotion);
		assertEquals(hurtPlayerHp + minorPotion.getHpIncreaseValue(), newPlayer.getCurrentHp());
	}

	@Test
	void useUltimatePotionTest() {
		Potion ultimatePotion = new Potion(501);
		newPlayer.decreaseHp(900);
		newPlayer.useItem(ultimatePotion);
		assertEquals(newPlayer.getMaxHp(), newPlayer.getCurrentHp());
	}

	@Test
	void useScrollOfPowerTest() {
		Scroll powerScroll = new Scroll(true, true);
		int oldMaxHp = newPlayer.getMaxHp();
		int oldAp = newPlayer.getAp();
		newPlayer.useItem(powerScroll);
		assertEquals(oldMaxHp + powerScroll.getMaxHpBuff(), newPlayer.getMaxHp());
		assertEquals(oldAp + powerScroll.getMaxApBuff(), newPlayer.getAp());
	}

	@Test
	void useBandageTest() {
		Bandage newBandage = new Bandage();
		newPlayer.decreaseHp(500);
		int hurtPlayerHp = newPlayer.getCurrentHp();
		newPlayer.useItem(newBandage);
		assertEquals(hurtPlayerHp + newBandage.getHpIncreaseValue(), newPlayer.getCurrentHp());
	}

	@Test
	void sortNormalInventoryTestCheckFirstItem() {
		setUpNormalInventory();
		newPlayer.sortInventory();
		Potion expectedPotion = new Potion(200);
		Potion actualPotion = (Potion) newPlayer.getItemByIndex(0);
		assertEquals(expectedPotion, actualPotion);
	}

	@Test
	void sortNormalInventoryTestCheckLastItem() {
		setUpNormalInventory();
		newPlayer.sortInventory();
		Scroll expectedScroll = new Scroll(true, true);
		Scroll actualScroll = (Scroll) newPlayer.getItemByIndex(4);
		assertEquals(expectedScroll, actualScroll);
	}

	private void setUpNormalInventory() {
		Scroll powerScroll = new Scroll(true, true);
		newPlayer.addToInventory((powerScroll));
		Scroll strengthScroll = new Scroll(true, false);
		newPlayer.addToInventory((strengthScroll));
		Bandage bOne = new Bandage();
		newPlayer.addToInventory(bOne);
		Potion massivePotion = new Potion(600);
		newPlayer.addToInventory(massivePotion);
		Potion minorPotion = new Potion(200);
		newPlayer.addToInventory(minorPotion);
	}

	@Test
	void sortLargeInventoryTestCheckFirstItem() {
		largeInventroyPlayer = new Player(10, 1000, 10000);
		setupLargeUnsortedInventoryOfPotions();
		largeInventroyPlayer.sortInventory();
		Potion expectedPotion = new Potion(200);
		Potion actualPotion = (Potion) largeInventroyPlayer.getItemByIndex(0);
		assertEquals(expectedPotion, actualPotion);
	}

	@Test
	void bubbleSortLargeInventoryTestCheckFirstItem() {
		largeInventroyPlayer = new Player(10, 1000, 10000);
		setupLargeUnsortedInventoryOfPotions();
		largeInventroyPlayer.bubbleSortPotionInventory();
		Potion expectedPotion = new Potion(200);
		Potion actualPotion = (Potion) largeInventroyPlayer.getItemByIndex(0);
		assertEquals(expectedPotion, actualPotion);
	}

	private void setupLargeUnsortedInventoryOfPotions() {
		Potion p;
		for (int i = 0; i < 10000; i++) {
			if (i < 3000) {
				p = new Potion(1000000);
				largeInventroyPlayer.addToInventory(p);
			} else if (i < 6000) {
				p = new Potion(500);
				largeInventroyPlayer.addToInventory(p);
			} else {
				p = new Potion(200);
				largeInventroyPlayer.addToInventory(p);
			}
		}

	}

}
