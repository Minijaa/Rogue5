package com.inte.group4;

import java.awt.*;
import java.util.ArrayList;

public class Player extends Sprite {

    private ArrayList<String> inventory;
    private final static int MAX_INVENTORY = 5;

    public Player(int ap, int hp) {
        super(ap, hp);
        inventory = new ArrayList<String>();
    }

    public void addToInventory(String object) {
        if (inventory.size() < 5) {
            inventory.add(object);
        } else {
            System.out.println("Cannot add item, inventory is full!");
        }
    }

    public int getInventorySize() {
        int inventorySize = inventory.size();
        System.out.println("Inventory contains " + inventorySize + " items, out of " + MAX_INVENTORY);
        return inventory.size();
    }

    public void removeFromInventory(String objectToRemove) {
        int index = inventory.indexOf(objectToRemove);
        removeFromInventory(index);
    }

    public void removeFromInventory(int indexToRemove) {
        inventory.remove(indexToRemove);
    }

    public String getItemByIndex(int index) {
        return inventory.get(index);
    }

}
