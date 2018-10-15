package com.inte.group4;

public class Map {
    String[][] mapGrid;

    public Map() {
        mapGrid = new String[10][10];
    }

    public void printGrid() {
        for (String[] array : mapGrid) {
           System.out.println();
            for (String string : array) {
                System.out.print(string + " ");
            }
        }
    }

    public void clearGrid() {

        for (String[] array : mapGrid) {
            for (int i = 0; i < array.length; i++) {
                array[i] = "O";
            }
        }
        mapGrid[9][4] = "X";
        printGrid();
    }
}