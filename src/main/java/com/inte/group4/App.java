package com.inte.group4;

import java.util.Scanner;

public class App {
	private Map map;
	private Scanner keyboard = new Scanner(System.in);
	private Player player;

	private void setUp() {
		map = new Map();
		player = new Player(10, 1000);
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

	private void openInventory() {
		int exitValue = player.printInventory();
		if (exitValue != 1) {
			System.out.println(exitValue + ": Exit inventory");
			int pickedItemIndex = keyboard.nextInt();

			while (pickedItemIndex != (exitValue)) {
				if (pickedItemIndex > player.getInventorySize() || pickedItemIndex < 0) {
					System.out.println("No item at that index!");
				} else {
					Item gottenItem = player.getItemByIndex(pickedItemIndex - 1);
					player.useItem(gottenItem);
					exitValue = player.printInventory();
					pickedItemIndex = keyboard.nextInt();
				}
			}
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
