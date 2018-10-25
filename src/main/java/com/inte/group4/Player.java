package com.inte.group4;

import java.util.ArrayList;

public class Player extends Sprite {

    private ArrayList<Item> inventory;
    private final static int MAX_INVENTORY = 5;

    public Player(int ap, int hp) {
        super(ap, hp);
        inventory = new ArrayList<Item>(MAX_INVENTORY);
    }

    // Hur testa denna metod? Endast size, vi kan inte testa vad som skrivs ut?
    public int getInventorySize() {
        int inventorySize = inventory.size();
        System.out.println("Inventory contains " + inventorySize + " items, out of " + MAX_INVENTORY);
        return inventory.size();
    }

    public static int getMaxInventory() {
        return MAX_INVENTORY;
    }

    public String addToInventory(Item newItem) {
        String returnValue = null;
        if (newItem != null) {
            if (inventory.size() < MAX_INVENTORY) {
                inventory.add(newItem);
                returnValue = "";
            } else {
                returnValue = "Cannot add item, inventory is full!";
                System.out.println(returnValue);
            }
        }
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
            setCurrentHp(getCurrentHp() + potionToUse.getHpIncreaseValue());
            return 1;
        } else if (itemToUse instanceof Bandage) {
            Bandage bandageToUse = (Bandage) itemToUse;
            setCurrentHp(getCurrentHp() + bandageToUse.getHpIncreaseValue());
            return 1;
        } else if (itemToUse instanceof Scroll) {
            Scroll scrollToUse = (Scroll) itemToUse;
            addToMaxHp(scrollToUse.getMaxHpBuff());
            addToAp(scrollToUse.getMaxApBuff());
            return 1;
        } else {
            return 0;
        }
    }

    // Hur testa denna metod?
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
