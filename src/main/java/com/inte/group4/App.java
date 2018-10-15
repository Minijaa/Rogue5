package com.inte.group4;

/**
 * Hello world!
 * making a small change
 */
public class App {
    private Map map = new Map();

    private void setUp() {
        map.clearGrid();
    }

    public static void main(String[] args) {
        new App().setUp();
    }
}
