package com.inte.group4;

public class Map {
    String[][] mapGrid;

    public Map() {
        mapGrid = new String[20][20];
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
            System.out.println();
            for (int i = 0; i < array.length; i++) {
                array[i] = "O";
            }
        }
        printGrid();
    }
}