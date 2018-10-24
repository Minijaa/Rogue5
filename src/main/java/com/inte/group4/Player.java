package com.inte.group4;

import java.util.ArrayList;

public class Player extends Sprite {

	private ArrayList<Item> inventory;
	private final static int MAX_INVENTORY = 5;

	public Player(int ap, int hp) {
		super(ap, hp);
		inventory = new ArrayList<Item>(MAX_INVENTORY);
	}

	public void addToInventory(Item newItem) {
		if (inventory.size() < MAX_INVENTORY) {
			inventory.add(newItem);
		} else {
			System.out.println("Cannot add item, inventory is full!");
		}
	}

	public int getInventorySize() {
		int inventorySize = inventory.size();
		System.out.println("Inventory contains " + inventorySize + " items, out of " + MAX_INVENTORY);
		return inventory.size();
	}

	public void removeFromInventory(Item itemToRemove) {
		int index = inventory.indexOf(itemToRemove);
		removeFromInventory(index);
	}

	public void removeFromInventory(int indexToRemove) {
		inventory.remove(indexToRemove);
	}

	public Item getItemByIndex(int index) {
		return inventory.get(index);
	}

	public void useItem(Item itemToUse) {
		if (itemToUse instanceof Potion) {
			Potion potionToUse = (Potion) itemToUse;
			setCurrentHp(getCurrentHp() + potionToUse.getHpIncreaseValue());
		} else if (itemToUse instanceof Bandage) {
			Bandage bandageToUse = (Bandage) itemToUse;
			setCurrentHp(getCurrentHp() + bandageToUse.getHpIncreaseValue());
		} else if (itemToUse instanceof Scroll) {
			Scroll scrollToUse = (Scroll) itemToUse;
			addToMaxHp(scrollToUse.getMaxHpBuff());
			addToAp(scrollToUse.getMaxApBuff());
		}
	}

	public int printInventory() {
		if (inventory.isEmpty()) {
			System.out.println("Your inventory is empty! :(");
			return 0;
		} else {
			System.out.println("Inventory opened, pick an item!");
			int number = 1;
			for (Item item : inventory) {
				System.out.println(number + ": " + item.toString());
				number++;
			}
			return number;
		}

	}

}
