package com.inte.group4;

import java.awt.*;
import java.util.Scanner;

public class App {
    private Map map;
    private Scanner keyboard = new Scanner(System.in);
    private Player player;

    private void setUp() {
        map = new Map();
        player = new Player(new Point(9, 4));
        // System.out.println(keyboard.nextInt());
        runCommandLoop();
    }

    private String readLine() {
        return keyboard.nextLine();
    }

    private void runCommandLoop() {
        boolean running = true;
        System.out.println();
        while (running) {  
        	
        	Location oldLocation = map.getActiveLocation();
            int newX = oldLocation.getPosition().x;
            int newY = oldLocation.getPosition().y;
            System.out.println("Coords before change: " + newX + " " + newY);
            
            System.out.println("Where do you want to go next?");
            String cmd = normalizeString(readLine());
            switch (cmd) {
                case "Up":
                	newX--;
                    break;
                case "Down":
                	newX++;
                    break;
                case "Left":
                	newY--;
                    break;
                case "Right":
                	newY++;
                    break;
                case "Exit":
                    running = false;
                    System.out.println("Programmet är avslutat");
                    break;
                default:
                    System.out.println("Fel kommando!");
            }
            System.out.println("Coords after change: " + newX + " " + newY);
            travelDirection(newX, newY);
        }
    }

    private String normalizeString(String nonNormalizedString) {
        nonNormalizedString = nonNormalizedString.trim().toLowerCase();
        if (nonNormalizedString.length() == 0) {
            return nonNormalizedString;
        } else {
            char firstLetter = Character.toUpperCase(nonNormalizedString.charAt(0));
            return firstLetter + nonNormalizedString.substring(1);
        }
    }

    private void travelDirection(String direction) {
        Location location = map.getActiveLocation();
        int newY = location.getPosition().x;
        int newX = location.getPosition().y;
        location.setVisited();
        map.setActiveLocation(newX, newY-1);
        map.printGrid();

    }
    
    private void travelDirection(int newX, int newY) {
    	// Control if newX and newY are within the grid system, if not no movey move.
    	Location oldLocation = map.getActiveLocation();
    	oldLocation.setVisited();
    	map.setActiveLocation(newY, newX);
    	map.printGrid();
    }

    public static void main(String[] args) {
        new App().setUp();
    }
}
