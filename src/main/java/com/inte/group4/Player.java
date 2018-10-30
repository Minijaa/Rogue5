package com.inte.group4;

import java.util.ArrayList;
import java.util.Collections;

public class Player extends Sprite {

	private ArrayList<Item> inventory;
	//private final static int MAX_INVENTORY = 5;
	private int maxInventory=5;


	public Player(int ap, int hp) {
		super(ap, hp);
		maxInventory =5 ;
		inventory = new ArrayList<Item>(maxInventory );

	}

	Player(int ap, int hp, int inventorySize) {
		super(ap, hp);
		maxInventory =inventorySize ;
		inventory = new ArrayList<Item>(inventorySize);

	}

	// Hur testa denna metod? Endast size, vi kan inte testa vad som skrivs ut?
	public int getInventorySize() {
		int inventorySize = inventory.size();
		// System.out.println("Inventory contains " + inventorySize + " items, out of "
		// + MAX_INVENTORY);
		return inventory.size();
	}

	public int getMaxInventory() {
		return maxInventory ;
	}

	public String addToInventory(Item newItem) {
		String returnValue = null;
		if (newItem != null) {
			if (inventory.size() < maxInventory) {
				inventory.add(newItem);
				returnValue = "You found " + newItem.toString();
			} else {
				returnValue = "Cannot add item, inventory is full!";

			}
		}
		System.out.println(returnValue);
		return returnValue;
	}

	public Item removeFromInventory(Item itemToRemove) {
		if (itemToRemove != null) {
			int index = inventory.indexOf(itemToRemove);
			Item removedItem = removeFromInventory(index);
			return removedItem;
		}
		return null;
	}

	public Item removeFromInventory(int indexToRemove) {
		if (indexToRemove >= 0 && indexToRemove <= getInventorySize()) {
			Item removedItem = inventory.remove(indexToRemove);
			return removedItem;
		}
		return null;

	}

	public Item getItemByIndex(int index) {
		if (index >= 0 && index <= getInventorySize()) {
			return inventory.get(index);
		} else {
			return null;
		}
	}

	public int useItem(Item itemToUse) {
		if (itemToUse instanceof Potion) {
			Potion potionToUse = (Potion) itemToUse;
			addToCurrentHp(potionToUse.getHpIncreaseValue());
			System.out.println("Used " + potionToUse.toString() + ", Player stats: AP: " + getAp() + " HP: "
					+ getCurrentHp() + "/" + getMaxHp());
			inventory.remove(potionToUse);
			return 1;
		} else if (itemToUse instanceof Bandage) {
			Bandage bandageToUse = (Bandage) itemToUse;
			addToCurrentHp(bandageToUse.getHpIncreaseValue());
			System.out.println("Used " + bandageToUse.toString() + ", Player stats: AP: " + getAp() + " HP: "
					+ getCurrentHp() + "/" + getMaxHp());
			inventory.remove(bandageToUse);
			return 1;
		} else if (itemToUse instanceof Scroll) {
			Scroll scrollToUse = (Scroll) itemToUse;
			addToMaxHp(scrollToUse.getMaxHpBuff());
			addToCurrentHp(scrollToUse.getMaxHpBuff());
			addToAp(scrollToUse.getMaxApBuff());
			System.out.println("Used " + scrollToUse.toString() + ", Player stats: AP: " + getAp() + " HP: "
					+ getCurrentHp() + "/" + getMaxHp());
			inventory.remove(scrollToUse);
			return 1;
		} else {
			return 0;
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

	protected void sortInventory() {
		ArrayList<Potion> potionList = new ArrayList<>();
		;
		ArrayList<Bandage> bandageList = new ArrayList<>();
		ArrayList<Scroll> scrollList = new ArrayList<>();
		for (Item i : inventory) {
			if (i instanceof Potion) {
				Potion p = (Potion) i;
				potionList.add(p);
			} else if (i instanceof Bandage) {
				Bandage b = (Bandage) i;
				bandageList.add(b);
			} else if (i instanceof Scroll) {
				Scroll s = (Scroll) i;
				scrollList.add(s);
			}
		}
		Collections.sort(potionList);
		Collections.sort(bandageList);
		Collections.sort(scrollList);
		inventory.clear();
		inventory.addAll(potionList);
		inventory.addAll(bandageList);
		inventory.addAll(scrollList);
	}
	public void bubbleSortPotionInventory() {
		for(int i=1; i<=inventory.size()-1; i++){
			for(int j=1; j<=inventory.size()-i; j++){
				Potion firstPotion =  (Potion) inventory.get(j-1);
				Potion secondPotion = (Potion) inventory.get(j);
				if(firstPotion.getHpIncreaseValue()>secondPotion.getHpIncreaseValue()){
					inventory.set(j-1,secondPotion);
					inventory.set(j,firstPotion);
				}
			}
		}
	}

}
