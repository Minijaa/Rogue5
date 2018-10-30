package com.inte.group4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {
	private Location[][] mapGrid;
	private Location activePlayerLocation;
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	private int gridSize;
	private static final int X_AXIS_MAP_SIZE = 10;
	private static final int Y_AXIS_MAP_SIZE = 10;

	public Map() {
		mapGrid = new Location[X_AXIS_MAP_SIZE][Y_AXIS_MAP_SIZE];
		createGrid();
		createAndPlaceMonsters();
		createAndPlaceTreasures();
		printGrid();
	}

	private void createAndPlaceMonsters() {
		// Adding Ogres
		mapGrid[4][5].setMonster(new Ogre(new Point(4, 5))).setUpOrLeft(true);
		mapGrid[2][2].setMonster(new Ogre(new Point(2, 2))).setUpOrLeft(false);
		mapGrid[9][3].setMonster(new Ogre(new Point(9, 3))).setUpOrLeft(true);
		mapGrid[1][4].setMonster(new Ogre(new Point(1, 4))).setUpOrLeft(false);
		mapGrid[7][7].setMonster(new Ogre(new Point(7, 7))).setUpOrLeft(false);

		// Adding Dragons
		mapGrid[2][3].setMonster(new Dragon(new Point(2, 3))).setUpOrLeft(true);
		mapGrid[5][6].setMonster(new Dragon(new Point(5, 6))).setUpOrLeft(false);
		mapGrid[0][7].setMonster(new Dragon(new Point(0, 7))).setUpOrLeft(false);
		mapGrid[8][0].setMonster(new Dragon(new Point(8, 0))).setUpOrLeft(true);
		mapGrid[7][3].setMonster(new Dragon(new Point(7, 3))).setUpOrLeft(false);

		// Adding Worms
		mapGrid[0][9].setMonster(new Worm(new Point(0, 9))).setUpOrLeft(false);
		mapGrid[2][0].setMonster(new Worm(new Point(2, 0))).setUpOrLeft(true);
		mapGrid[4][9].setMonster(new Worm(new Point(4, 9))).setUpOrLeft(false);
		mapGrid[6][0].setMonster(new Worm(new Point(6, 0))).setUpOrLeft(true);
		mapGrid[8][9].setMonster(new Worm(new Point(8, 9))).setUpOrLeft(false);

		// Add monsters to the list of monsters
		for (int y = mapGrid.length - 1; y >= 0; y--) {
			for (int x = 0; x < mapGrid.length; x++) {
				if (mapGrid[x][y].getMonster() != null) {
					mapGrid[x][y].setMapChar();
					addMonsterToList(mapGrid[x][y].getMonster());
				}
			}
		}
	}

	private void createAndPlaceTreasures() {
		// Adding Potions
		mapGrid[5][0].setTreasure(new Potion(200));
		mapGrid[5][2].setTreasure(new Potion(200));
		mapGrid[3][4].setTreasure(new Potion(500));
		mapGrid[1][2].setTreasure(new Potion(500));
		mapGrid[3][6].setTreasure(new Potion(800));
		mapGrid[7][8].setTreasure(new Potion(800));

		// Adding Scrolls
		mapGrid[4][1].setTreasure(new Scroll(false, true));
		mapGrid[9][4].setTreasure(new Scroll(false, true));
		mapGrid[8][1].setTreasure(new Scroll(true, false));
		mapGrid[5][3].setTreasure(new Scroll(true, false));
		mapGrid[8][6].setTreasure(new Scroll(true, true));
		mapGrid[2][9].setTreasure(new Scroll(true, true));

		// Adding Bandages
		mapGrid[3][0].setTreasure(new Bandage());
		mapGrid[0][5].setTreasure(new Bandage());
		mapGrid[1][7].setTreasure(new Bandage());
		mapGrid[4][8].setTreasure(new Bandage());
		mapGrid[5][6].setTreasure(new Bandage());
		mapGrid[7][5].setTreasure(new Bandage());
	}

	public String printGrid() {
		StringBuilder mapBuilder = new StringBuilder("");
		for (int y = mapGrid.length - 1; y >= 0; y--) {
			System.out.println();
			mapBuilder.append("\n");
			for (int x = 0; x < mapGrid.length; x++) {

				System.out.print(mapGrid[x][y].getMapChar() + " ");
				mapBuilder.append(mapGrid[x][y].getMapChar() + " ");
			}
		}
		return mapBuilder.toString();
	}

	private void createGrid() {
		for (int y = mapGrid.length - 1; y >= 0; y--) {
			for (int x = 0; x < mapGrid.length; x++) {
				mapGrid[x][y] = new Location(new Point(x, y));
				gridSize++;
			}
		}
		setActivePlayerLocation(4, 0);
		System.out.println("player at 4;0");
	}

	public void setActivePlayerLocation(int x, int y) {
		activePlayerLocation = mapGrid[x][y];
		activePlayerLocation.setPlayerAtLocation();
	}

	public Location getActivePlayerLocation() {
		return activePlayerLocation;
	}

	public Location getLocationFromPoint(Point gridPoint) {
		return mapGrid[gridPoint.x][gridPoint.y];
	}

	public int gridSize() {
		return gridSize;
	}

	public void addMonsterToList(Monster monster) {
		monsterList.add(monster);
	}

	public Monster removeMonster(Monster monsterToBeRemoved) {
		Location location = this.getLocationFromPoint(monsterToBeRemoved.getCurrentMonsterCords());
		location.setMonster(null);
		removeMonsterFromList(monsterToBeRemoved);
		location.setLocationText("silence");
		return monsterToBeRemoved;
	}

	public void removeMonsterFromList(Monster monster) {
		monsterList.remove(monster);

	}

	public Point rndCords() {
		Random rnd = new Random();
		int x, y;
		Point cords;
		x = rnd.nextInt(10);
		y = rnd.nextInt(10);
		cords = new Point(x, y);
		return cords;
	}

	//
	// if (monsterList.size() < 15) {
	//
	// Point cords = new Point(rndCords());
	// Location location = getLocationFromPoint(cords);
	// if (location.getMonster() == null) {
	// monster.setCurrentMonsterCords(cords);
//    public void addMonsterToGrid(Monster monster) {
//                location.setMonster(monster);
//                addMonsterToList(monster);
//                //System.out.println(monsterList.size());
//                System.out.println(monster.toString());
//            }
//        } else {
//            throw new IllegalArgumentException("There can only be 15 monsters in a map");
//        }
//    }

	public Monster getMonsterFromList(int index) {
		return monsterList.get(index);
	}

	public int getMonsterListSize() {
		return monsterList.size();
	}

	public void moveAllMonsters() {
		for (Monster m : monsterList) {
			Point oldPoint = m.getCurrentMonsterCords();
			// System.out.println("Monster Type:" + m.getClass().getSimpleName() + "
			// OLDPOINT: " + oldPoint.x + " " + oldPoint.y);
			Point newPoint = m.moveMonster();
			if (getLocationFromPoint(newPoint).getMonster() != null
					|| getLocationFromPoint(newPoint).equals(activePlayerLocation)) {
				if (m.getDeadLockCounter() == 3) {
					m.setUpOrLeft(!m.getIsUpOrLeft());
					m.resetDeadLockCounter();
					// System.out.println("Monster Type:" + m.getClass().getSimpleName() + " is
					// tired of waiting. Tries to changes direction!");
				} else {
					m.setCurrentMonsterCords(oldPoint);
					m.incrementDeadLockCounter();
					// System.out.println("Monster Type:" + m.getClass().getSimpleName() + " STOPS
					// and counts to: " + m.getDeadLockCounter());
				}
			} else {
				m.resetDeadLockCounter();
				m.setCurrentMonsterCords(newPoint);
				// System.out.println("Monster Type:" + m.getClass().getSimpleName() + "
				// NEWPOINT " + newPoint.x + " " + newPoint.y);
				getLocationFromPoint(oldPoint).setMonster(null);
				getLocationFromPoint(oldPoint).setMapChar();
				getLocationFromPoint(newPoint).setMonster(m);
				getLocationFromPoint(newPoint).setMapChar();
			}
		}
	}
}