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

			System.out.println("Where do you want to go next?");
			String cmd = normalizeString(readLine());
			switch (cmd) {
			case "W":
				newY++;
				break;
			case "S":
				newY--;
				break;
			case "A":
				newX--;
				break;
			case "D":
				newX++;
				break;
			case "E":
				openInventoryCommand();
				break;
			case "Q":
				running = askIfQuit();
				break;
			default:
				System.out.println("Wrong input, try again!");
			}
			if (running) {
				travelDirection(newX, newY);
				running = evaluatePlayerLocation();
				if (running) {
					map.printGrid();
				}
			}
		}
		System.out.println("Exiting game, well played or something ¯\\_(ツ)_/¯");
	}

	private boolean evaluatePlayerLocation() {
		if (checkMonsterAtLocation()) {
			fight();
		}
		if (player.isAlive()) {
			getTreasure();
			if (lastMonsterOnMap()) {
				System.out.println("All monsters be dead, congratz you won?");
				return false;
			}
			return true;
		} else {
			System.out.println("Oh dear, you are dead!");
			return false;
		}
	}

	private boolean checkMonsterAtLocation() {
		if (map.getActivePlayerLocation().getMonster() != null) {
			return true;
		} else {
			return false;
		}
	}

	private void fight() {
		// fight-switch etc
	}

	private void getTreasure() {
		Location activeLocation = map.getActivePlayerLocation();
		Item treasure = activeLocation.getTreasure();

		if (treasure != null) {
			if (player.getInventorySize() == Player.getMaxInventory()) {
				System.out.println("Inventory FULL, use an item to pick up treasure!");
			} else {
				player.addToInventory(treasure);
				activeLocation.removeTreasure();
			}
		}
	}

	private boolean lastMonsterOnMap() {
		if (map.getMonsterListSize() == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void openInventoryCommand() {
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

	public boolean askIfQuit() {
		System.out.println("Do you really wanna quit?");
		System.out.println("1: I really wanna quit" + "\n" + "2: No I won't give up yet!");
		int quitResult = keyboard.nextInt();
		if (quitResult == 1) {
			return false;
		} else {
			return true;

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
