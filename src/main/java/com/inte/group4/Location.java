package com.inte.group4;

import java.awt.*;

public class Location {
	private String locationText = "silence";
	private Item treasure;
	private Monster monster;
	private Point position;
	private char mapChar;
	private boolean isVisited = false;
	private static final char visitedLocationChar = '.';
	private static final char unvisitedLocationChar = 'O';
	private static final char playerAtLocationChar = 'X';

	public Location(Point p) {
		// changed here
		mapChar = unvisitedLocationChar;
		position = p;
	}

	public String getLocationText() {
		return locationText;
	}

	public void setLocationText(String locationText) {
		this.locationText = locationText;
	}

	public char getMapChar() {
		return mapChar;
	}

	public int setMapChar() {
		if (monster != null) {
			mapChar = monster.getMonsterChar();
			return 2;
		} else if (isVisited) {
			mapChar = visitedLocationChar;
			return 1;
		} else {
			mapChar = unvisitedLocationChar;
			return 0;
		}
	}

	public void setTreasure(Item item) {
		this.treasure = item;
	}

	public Item getTreasure() {
		return treasure;
	}

	public Item removeTreasure() {
		Item removedTreasure = treasure;
		treasure = null;
		return removedTreasure;
	}

	public Monster getMonster() {
		return monster;
	}

	public Monster setMonster(Monster monster) {
		this.monster = monster;
		return monster;
	}

	public String playerEntersLocation() {
		StringBuilder locationBuilder = new StringBuilder("");
		if (monster != null) {
			System.out.println("FIGHT!!!");
			locationBuilder.append("FIGHT!!!");
			return locationBuilder.toString();
		}

		System.out.println(locationText);
		locationBuilder.append(locationText);
		return locationBuilder.toString();

	}

	public void setVisited(boolean visited) {
		isVisited = visited;

	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setPlayerAtLocation() {
		mapChar = playerAtLocationChar;
	}

	public Point getPosition() {
		return position;
	}
}