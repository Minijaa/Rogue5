package com.inte.group4;

import java.awt.*;

public class Map {
    private Location[][] mapGrid;
    private boolean firstRun;


    private Location activeLocation;

    public Map() {
        firstRun = true;
        mapGrid = new Location[10][10];
    }

    public void printGrid() {
        for (Location[] array : mapGrid) {
            System.out.println();
            for (Location location : array) {
                System.out.print(location.getMapChar() + " ");
            }
        }
    }

    public void alterGrid() {
        if (firstRun) {
            for (int y = 0; y < mapGrid.length; y++) {
                for (int x = 0; x < mapGrid.length; x++) {
                    mapGrid[x][y] = new Location(new Point(x,y));
                    System.out.println("X " + x);
                    System.out.println("Y " + y);
                }
            }
            setActiveLocation(4, 9);
            firstRun = false;
            printGrid();
        } else {

        }
    }

    public void setActiveLocation(int x, int y) {
        //activeLocation.setMapChar('_');
        activeLocation = mapGrid[y][x];
        activeLocation.setMapChar('X');
    }

    public Location getActiveLocation() {
        return activeLocation;
    }

    public void setFirstRun(boolean firstRun) {
        this.firstRun = firstRun;
    }
}