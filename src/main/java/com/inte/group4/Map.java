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
        for (int y = mapGrid.length-1; y >= 0; y--) {
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
        for (int y = mapGrid.length-1; y >= 0; y--) {
            for (int x = 0; x < mapGrid.length; x++) {
                mapGrid[x][y] = new Location(new Point(x, y));
                gridSize++;
            }
        }
        setActivePlayerLocation(4, 0);
        printGrid();
    }

    public void setActivePlayerLocation(int x, int y) {
        activePlayerLocation = mapGrid[x][y];
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