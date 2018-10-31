package com.inte.group4;

import static org.junit.jupiter.api.Assertions.*;

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
		String nullItemString = newPlayer.addItemToInventory(null);
		assertNull(nullItemString);
	}

	@Test
	public void addItemToPlayerInventoryTest() {
		Item itemToBeAdded = spawnItem();
		String acceptedAddString = newPlayer.addItemToInventory(itemToBeAdded);
		assertEquals(1, newPlayer.getInventorySize());
		assertEquals("You found " + itemToBeAdded.toString(), acceptedAddString);
	}

	@Test
	public void fillPlayerInventoryTest() {
		while (newPlayer.getInventorySize() < newPlayer.getMaxInventorySize()) {
			Item newItem = spawnItem();
			newPlayer.addItemToInventory(newItem);
		}
		Item oneTooMany = spawnItem();
		String inventoryFullString = newPlayer.addItemToInventory(oneTooMany);
		assertEquals("Cannot add item, inventory is full!", inventoryFullString);
	}

	@Test
	public void removeFromPlayerInventoryByObjectTest() {
		Item firstItem = spawnItem();
		Item itemToRemove = spawnItem();
		newPlayer.addItemToInventory(firstItem);
		newPlayer.addItemToInventory(itemToRemove);
		Item removedItem = newPlayer.removeItemFromInventory(itemToRemove);
		assertEquals(1, newPlayer.getInventorySize());
		assertEquals(itemToRemove, removedItem);
	}

	@Test
	public void removeFromPlayerInventoryByIndexTest() {
		Item itemToRemove = spawnItem();
		newPlayer.addItemToInventory(spawnItem());
		newPlayer.addItemToInventory(itemToRemove);
		newPlayer.addItemToInventory(spawnItem());
		Item removedItem = newPlayer.removeItemFromInventory(1);
		assertEquals(2, newPlayer.getInventorySize());
		assertEquals(itemToRemove, removedItem);
	}

	@Test
	public void removeNullItemFromPlayerInventoryTest() {
		Item nullItem = newPlayer.removeItemFromInventory(null);
		assertNull(nullItem);
	}

	@Test
	public void removeIncorrectIndexFromPlayerInventoryTest() {
		Item IncorrectIndexItem = newPlayer.removeItemFromInventory(5);
		assertNull(IncorrectIndexItem);
	}

	// Onödigt test pga vi testar redan att lägga till och ta bort?
	@Test
	public void fillAndThenRemoveFromPlayerInventoryTest() {
		Potion potionToRemove = new Potion(200);
		Potion potionToAdd = new Potion(200);
		newPlayer.addItemToInventory(new Potion(200));
		newPlayer.addItemToInventory(new Potion(200));
		newPlayer.addItemToInventory(new Potion(200));
		newPlayer.addItemToInventory(new Potion(200));
		newPlayer.addItemToInventory(potionToRemove);
		newPlayer.addItemToInventory(potionToAdd);
		newPlayer.removeItemFromInventory(potionToRemove);
		newPlayer.addItemToInventory(potionToAdd);
		assertEquals(potionToAdd, newPlayer.getItemFromInventoryByIndex(4));
	}

	@Test
	public void getItemFromInventoryTest() {
		Item itemToGet = spawnItem();
		newPlayer.addItemToInventory(spawnItem());
		newPlayer.addItemToInventory(itemToGet);
		newPlayer.addItemToInventory(spawnItem());
		Item gottenItem = newPlayer.getItemFromInventoryByIndex(1);
		assertEquals(itemToGet, gottenItem);
	}

	@Test
	public void getIncorrectIndexItemFromInventoryTest() {
		Item incorrectIndexItem = newPlayer.getItemFromInventoryByIndex(5);
		assertNull(incorrectIndexItem);
	}

	@Test
	public void useNullItemTest() {
		int resultOfUseItem = newPlayer.useInventoryItem(null);
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
		newPlayer.addItemToInventory(newItem);
		int inventoryResult = newPlayer.printInventory();
		assertEquals(2, inventoryResult);
	}

	@Test
	void printInventoryWithManyItemsTest() {
		Player playerWithBigInventory = new Player(100, 1000, 50);
		for (int i = 0; i < 50; i++) {
			Item newItem = spawnItem();
			playerWithBigInventory.addItemToInventory(newItem);
		}
		int inventoryResult = playerWithBigInventory.printInventory();
		assertEquals(51, inventoryResult);
	}

	@Test
	void useMinorPotionTest() {
		Potion minorPotion = new Potion(200);
		newPlayer.decreaseHp(300);
		int hurtPlayerHp = newPlayer.getCurrentHp();
		newPlayer.useInventoryItem(minorPotion);
		assertEquals(hurtPlayerHp + minorPotion.getHpIncreaseValue(), newPlayer.getCurrentHp());
	}

	@Test
	void useUltimatePotionTest() {
		Potion ultimatePotion = new Potion(501);
		newPlayer.decreaseHp(900);
		newPlayer.useInventoryItem(ultimatePotion);
		assertEquals(newPlayer.getMaxHp(), newPlayer.getCurrentHp());
	}

	@Test
	void useScrollOfPowerTest() {
		Scroll powerScroll = new Scroll(true, true);
		int oldMaxHp = newPlayer.getMaxHp();
		int oldAp = newPlayer.getAp();
		newPlayer.useInventoryItem(powerScroll);
		assertEquals(oldMaxHp + powerScroll.getMaxHpBuff(), newPlayer.getMaxHp());
		assertEquals(oldAp + powerScroll.getMaxApBuff(), newPlayer.getAp());
	}

	@Test
	void useBandageTest() {
		Bandage newBandage = new Bandage();
		newPlayer.decreaseHp(500);
		int hurtPlayerHp = newPlayer.getCurrentHp();
		newPlayer.useInventoryItem(newBandage);
		assertEquals(hurtPlayerHp + newBandage.getHpIncreaseValue(), newPlayer.getCurrentHp());
	}

	@Test
	void sortNormalInventoryTestCheckFirstItem() {
		setUpNormalInventory();
		newPlayer.sortInventory();
		Potion expectedPotion = new Potion(200);
		Potion actualPotion = (Potion) newPlayer.getItemFromInventoryByIndex(0);
		assertEquals(expectedPotion, actualPotion);
	}

	@Test
	void sortNormalInventoryTestCheckLastItem() {
		setUpNormalInventory();
		newPlayer.sortInventory();
		Scroll expectedScroll = new Scroll(true, true);
		Scroll actualScroll = (Scroll) newPlayer.getItemFromInventoryByIndex(4);
		assertEquals(expectedScroll, actualScroll);
	}

	private void setUpNormalInventory() {
		Scroll powerScroll = new Scroll(true, true);
		newPlayer.addItemToInventory((powerScroll));
		Scroll strengthScroll = new Scroll(true, false);
		newPlayer.addItemToInventory((strengthScroll));
		Bandage bOne = new Bandage();
		newPlayer.addItemToInventory(bOne);
		Potion massivePotion = new Potion(600);
		newPlayer.addItemToInventory(massivePotion);
		Potion minorPotion = new Potion(200);
		newPlayer.addItemToInventory(minorPotion);
	}

	@Test
	void sortLargeInventoryTestCheckFirstItem() {
		largeInventroyPlayer = new Player(10, 1000, 10000);
		setupLargeUnsortedInventoryOfPotions();
		largeInventroyPlayer.sortInventory();
		Potion expectedPotion = new Potion(200);
		Potion actualPotion = (Potion) largeInventroyPlayer.getItemFromInventoryByIndex(0);
		assertEquals(expectedPotion, actualPotion);
	}

	@Test
	void bubbleSortLargeInventoryTestCheckFirstItem() {
		largeInventroyPlayer = new Player(10, 1000, 10000);
		setupLargeUnsortedInventoryOfPotions();
		largeInventroyPlayer.bubbleSortPotionInventory();
		Potion expectedPotion = new Potion(200);
		Potion actualPotion = (Potion) largeInventroyPlayer.getItemFromInventoryByIndex(0);
		assertEquals(expectedPotion, actualPotion);
	}

	private void setupLargeUnsortedInventoryOfPotions() {
		Potion p;
		for (int i = 0; i < 10000; i++) {
			if (i < 3000) {
				p = new Potion(1000000);
				largeInventroyPlayer.addItemToInventory(p);
			} else if (i < 6000) {
				p = new Potion(500);
				largeInventroyPlayer.addItemToInventory(p);
			} else {
				p = new Potion(200);
				largeInventroyPlayer.addItemToInventory(p);
			}
		}

	}

}
