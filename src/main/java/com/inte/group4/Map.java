package com.inte.group4;

import java.awt.*;

public class Map {
    private Location[][] mapGrid;
    private Location activeLocation;
    private int gridSize;

    public Map() {
        mapGrid = new Location[10][10];
        createGrid();
    }

    public void printGrid() {
        for (Location[] array : mapGrid) {
            System.out.println();
            for (Location location : array) {
                System.out.print(location.getMapChar() + " ");
            }
        }
    }

    public void createGrid() {
        for (int y = 0; y < mapGrid.length; y++) {
            for (int x = 0; x < mapGrid.length; x++) {
                mapGrid[x][y] = new Location(new Point(x, y));
                gridSize++;
            }
        }
        setActiveLocation(4, 9);
        printGrid();
    }

    public void setActiveLocation(int x, int y) {
        //activeLocation.setMapChar('_');
        activeLocation = mapGrid[y][x];
        activeLocation.setPlayerAtLocation();
    }

    public Location getActiveLocation() {
        return activeLocation;
    }

    public Location getLocationFromPoint(Point gridPoint){
        return mapGrid[gridPoint.x][gridPoint.y];
    }

    public int gridSize() {
        return gridSize;
    }
}