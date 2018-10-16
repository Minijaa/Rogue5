package com.inte.group4;

import java.awt.*;

public class Location {
    private String locationText;
    private boolean hasTreasure;
    private boolean hasMonster;
    private Point position;
    private char mapChar;
    private static final char visitedLocationChar = '.';
    private static final char unvisitedLocationChar = 'O';
    private static final char playerAtLocationChar = 'X';

    public Location(String locationText, char mapChar, boolean hasTreasure, boolean hasMonster) {
        this.locationText = locationText;
        this.mapChar = mapChar;
        this.hasTreasure = hasTreasure;
        this.hasMonster = hasMonster;
    }

    public Location(Point p) {
        //changed here
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

    public boolean hasTreasure() {
        return hasTreasure;
    }

    public void setHasTreasure(boolean hasTreasure) {
        this.hasTreasure = hasTreasure;
    }

    public boolean hasMonster() {
        return hasMonster;
    }

    public void setHasMonster(boolean hasMonster) {
        this.hasMonster = hasMonster;
    }

    public void playerEntersLocation() {
        if (hasMonster) {
            System.out.println("FIGHT!!!");
        }

        System.out.println(locationText);

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