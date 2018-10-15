package com.inte.group4;

import java.awt.*;
import java.util.Scanner;

public class App {
    private Map map = new Map();
    private Scanner keyboard = new Scanner(System.in);
    private Player player;

    private void setUp() {
        map.alterGrid();
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
            System.out.println("Where do you want to go next?");
            String cmd = normalizeString(readLine());
            switch (cmd) {
                case "Up":
                    travelDirection("up");
                    break;
                case "Down":
                    travelDirection("down");
                    break;
                case "Left":
                    travelDirection("left");
                    break;
                case "Right":
                    travelDirection("right");
                    break;
                case "Exit":
                    running = false;
                    System.out.println("Programmet är avslutat");
                    break;
                default:
                    System.out.println("Fel kommando!");
            }
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
        //Omvänt x och y'
        Location location = map.getActiveLocation();
        map.setActiveLocation(location.getPosition().x-1, location.getPosition().y);
        map.alterGrid();

    }

    public static void main(String[] args) {
        new App().setUp();
    }
}
