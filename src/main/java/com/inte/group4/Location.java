package com.inte.group4;

import java.awt.*;

public class Location {
	private String locationText = "silence";
	private Item treasure;
	private Monster monster;
	private Point position;
	private char mapChar;
	private static final char visitedLocationChar = '.';
	private static final char unvisitedLocationChar = 'O';
	private static final char playerAtLocationChar = 'X';

	public Location(String locationText, char mapChar) {
		this.locationText = locationText;
		this.mapChar = mapChar;
		this.monster = null;
		this.treasure = null;
	}

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

	public void setMapChar(char mapChar) {
		this.mapChar = mapChar;
	}

	public void setTreasure(Item item) {
		this.treasure = item;
	}
	
	public Item getTreasure() {
		return treasure;
	}

	public void removeTreasure() {
		treasure = null;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
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

	public void setVisited() {
		setMapChar(visitedLocationChar);
	}

	public void setUnvisited() {
		setMapChar(unvisitedLocationChar);
	}

	public void setPlayerAtLocation() {
		setMapChar(playerAtLocationChar);
	}

	public Point getPosition() {
		return position;
	}
}