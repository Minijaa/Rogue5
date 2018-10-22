package com.inte.group4;

import java.awt.*;
import java.util.Scanner;

public class App {
	private Map map;
	private Scanner keyboard = new Scanner(System.in);
	private Player player;

	private void setUp() {
		map = new Map();
		// player = new Player(new Point(9, 4));
		// System.out.println(keyboard.nextInt());
		runCommandLoop();
	}

	private String readLine() {
		return keyboard.nextLine();
	}

	private void runCommandLoop() {
		boolean running = true;
		System.out.println();
		while (running) {

			Location oldLocation = map.getActivePlayerLocation();
			int newX = oldLocation.getPosition().x;
			int newY = oldLocation.getPosition().y;
			System.out.println("Coords before change: " + newX + " " + newY);

			System.out.println("Where do you want to go next?");
			String cmd = normalizeString(readLine());
			switch (cmd) {
			case "Up":
				newY++;
				break;
			case "Down":
				newY--;
				break;
			case "Left":
				newX--;
				break;
			case "Right":
				newX++;
				break;
			case "Bag":
				openInventory();
				break;
			case "Exit":
				running = false;
				System.out.println("Programmet är avslutat");
				break;
			default:
				System.out.println("Fel kommando!");
			}
			System.out.println("Coords after change: " + newX + " " + newY);
			travelDirection(newX, newY);
			// moveMonsters();
			map.printGrid();
		}
	}

	// Iom att vi använder scanner blir det knepigt att göra allt i player,
	// iofs är det bara att ha en till i player, men men.
	// Delade även upp det i två metoder pga mer strukturerad kod.
	//
	// Bör tänka på HUR items används. Antar instanceof och plussar på
	// aktuell stat.
	private void openInventory() {
		System.out.println("Inventory opened, pick an item!");
		player.printInventory();

		int pickedItemIndex = keyboard.nextInt();
		if (pickedItemIndex > player.getInventorySize() || pickedItemIndex < 0) {
			System.out.println("No, wrong index!");
		} else {
			fetchItem(pickedItemIndex - 1);
		}

	}

	private void fetchItem(int index) {
		Item gottenItem = player.getItemByIndex(index);
		System.out.println("What do you wanna do with " + gottenItem.toString() + "?");
		System.out.println("1: Use item. \n 2: Drop item. \n 3: Exit/cancel.");
		String cmd = normalizeString(readLine());
		switch (cmd) {
		case "1":
			// use item
			// remove item from player inventory and Map-list of items
			break;
		case "2":
			// drop item?
			// remove item from player inventory and Map-list of items
			break;
		case "3":
			// do nothing/exit?
			break;
		default:
			// do nothing/exit
			break;
		}

	}

	protected String normalizeString(String nonNormalizedString) {
		nonNormalizedString = nonNormalizedString.trim().toLowerCase();
		if (nonNormalizedString.length() == 0) {
			return nonNormalizedString;
		} else {
			char firstLetter = Character.toUpperCase(nonNormalizedString.charAt(0));
			return firstLetter + nonNormalizedString.substring(1);
		}
	}

	private void travelDirection(int newX, int newY) {
		// Control if newX and newY are within the grid system, if not no movey move.
		Location oldLocation = map.getActivePlayerLocation();
		oldLocation.setVisited();
		map.setActivePlayerLocation(newX, newY);
	}

	public static void main(String[] args) {
		new App().setUp();
	}
}
