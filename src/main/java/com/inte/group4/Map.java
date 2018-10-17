package com.inte.group4;

import java.awt.*;

public class Map {
    private Location[][] mapGrid;
    private Location activePlayerLocation;
    private int gridSize;

    public Map() {
        mapGrid = new Location[10][10];
        createGrid();
    }

    public String  printGrid() {
        StringBuilder mapBuilder = new StringBuilder("");
        for (Location[] array : mapGrid) {
            System.out.println();
            mapBuilder.append("\n");
            for (Location location : array) {
                System.out.print(location.getMapChar() + " ");
                mapBuilder.append(location.getMapChar() + " ");
            }
        }
        return mapBuilder.toString();
    }

    public void createGrid() {
        for (int y = 0; y < mapGrid.length; y++) {
            for (int x = 0; x < mapGrid.length; x++) {
                mapGrid[x][y] = new Location(new Point(x, y));
                gridSize++;
            }
        }
        setActivePlayerLocation(4, 9);
        printGrid();
    }

    public void setActivePlayerLocation(int x, int y) {
        activePlayerLocation = mapGrid[y][x];
        activePlayerLocation.setPlayerAtLocation();
    }

    public Location getActivePlayerLocation() {
        return activePlayerLocation;
    }

    public Location getLocationFromPoint(Point gridPoint){
        return mapGrid[gridPoint.x][gridPoint.y];
    }

    public int gridSize() {
        return gridSize;
    }
}