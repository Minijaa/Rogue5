package com.inte.group4;

import java.util.Scanner;

public class App {

    private Map map;
    private Scanner keyboard = new Scanner(System.in);
    private Player player;

    private void setUp() {
        map = new Map();
        player = new Player(100, 1000);
        runCommandLoop();
    }

    private String readLine() {
        return keyboard.nextLine();
    }

    private void runCommandLoop() {
        boolean running = true;
        System.out.println();
        while (running) {
            Location oldLocation = map.getActivePlayerLocation();
            int newX = oldLocation.getPosition().x;
            int newY = oldLocation.getPosition().y;
            System.out.println();
            getPlayerHealthStatus();
            System.out.println("Where do you want to go next?");
            String cmd = normalizeString(readLine());
            switch (cmd) {
                case "W":
                    newY++;
                    break;
                case "S":
                    newY--;
                    break;
                case "A":
                    newX--;
                    break;
                case "D":
                    newX++;
                    break;
                case "E":
                    openInventoryCommand();
                    break;
                case "Q":
                    running = askIfQuit();
                    break;
                case "Å": // Stand still
                    break;
                default:
                    System.out.println("Wrong input, try again!");
            }
            map.moveAllMonsters();

            if (running) {
                // Är inte detta fel ordning? Player ska väl röra sig innan monster?
                travelDirection(newX, newY);
                running = evaluatePlayerLocation();
                if (running) {
                    map.printGrid();
                }
            }
        }
        System.out.println("Exiting game, well played or something ¯\\_(ツ)_/¯");
    }

    private boolean evaluatePlayerLocation() {
        if (checkMonsterAtLocation() && player.isAlive()) {
            fight();
        }
        if (player.isAlive()) {
            getTreasure();
            if (lastMonsterOnMap()) {
                System.out.println("All monsters be dead, congratz you won?");
                gameOver();
                return false;
            }
            return true;
        } else {
            System.out.println("Oh dear, you are dead!");
            return false;
        }
    }

    private boolean checkMonsterAtLocation() {
        if (map.getActivePlayerLocation().getMonster() != null) {
            return true;
        } else {
            return false;
        }
    }

    public void getPlayerHealthStatus() {
        System.out.println("Player health: " + player.getCurrentHp() + "/" + player.getMaxHp());
    }

    public void getMonsterHealthStatus(Monster monster) {
        System.out.println("Monster health: " + monster.getCurrentHp() + "/" + monster.getMaxHp());
    }

    private void fight() {
        boolean running = true;
        Monster monsterToKill = map.getActivePlayerLocation().getMonster();
        System.out.println();
        System.out.println("It's " + monsterToKill.getClass().getSimpleName() + " smashing time!");
        while (running) {
            System.out.println("Fight the " + monsterToKill.getClass().getSimpleName()
                    + "! Press A to attack or P to take a health potion!");
            String cmd = normalizeString(readLine());
            switch (cmd) {
                case "A":
                    playerAttacks();
                    break;
                case "P":
                    // System.out.println("Potion");
                    usePotionInBattle();
                    break;
                case "Q":
                    running = askIfQuit();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
            }
            if (map.getActivePlayerLocation().getMonster() == null) {
                break;
            }
        }
    }

    private void usePotionInBattle() {
        if (player.getItemByIndex(0) != null && player.getItemByIndex(0) instanceof Potion) {
            Potion pot = (Potion) player.getItemByIndex(0);
            player.useItem(pot);
            monsterAttacks(map.getActivePlayerLocation().getMonster());
        } else {
            System.out.println("You don't have a potion, attack!");
            playerAttacks();
        }
    }

    private void playerAttacks() {
        Monster monsterToKill = map.getActivePlayerLocation().getMonster();
        if (player.isAlive() && monsterToKill.isAlive()) {
            getPlayerHealthStatus();
            monsterToKill.decreaseHp(player.attack());
            System.out.println(
                    "You hit the " + monsterToKill.getClass().getSimpleName() + " for " + player.getAp() + " dmg!");
            if (!monsterToKill.isAlive()) {
                System.out.println("You slayed the " + monsterToKill.getClass().getSimpleName() + "!");
                map.removeMonster(monsterToKill);
            } else {
                monsterAttacks(monsterToKill);
            }
        }
    }

    private void monsterAttacks(Monster monsterToKill) {
        getMonsterHealthStatus(monsterToKill);
        player.decreaseHp(monsterToKill.attack());
        System.out.println(
                "The " + monsterToKill.getClass().getSimpleName() + " hit you for " + monsterToKill.getAp() + " dmg!");
        if (!evaluatePlayerLocation()) {
            gameOver();
            return;
        }
        getPlayerHealthStatus();
    }

    private void gameOver() {
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("New Game?");
            System.out.println("1: YES!!!");
            System.out.println("2: NOOO!!!");
            String cmd = normalizeString(readLine());
            switch (cmd) {
                case "1":
                    new App().setUp();
                    break;
                case "2":
                    System.out.println("Exiting game, well played or something ¯\\_(ツ)_/¯");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input, try again!");
            }
        }
    }

    private void getTreasure() {
        Location activeLocation = map.getActivePlayerLocation();
        Item treasure = activeLocation.getTreasure();

        if (treasure != null) {
            if (player.getInventorySize() == player.getMaxInventory()) {
                System.out.println("Inventory FULL, use an item to pick up treasure!");
            } else {
                player.addToInventory(treasure);
                activeLocation.removeTreasure();
            }
        }
    }

    private boolean lastMonsterOnMap() {
        if (map.getMonsterListSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void openInventoryCommand() {
        int exitValue = player.printInventory();
        if (exitValue != 1) {
            System.out.println(exitValue + ": Exit inventory");
            int pickedItemIndex = keyboard.nextInt();

            while (pickedItemIndex != (exitValue)) {
                if (pickedItemIndex > player.getInventorySize() || pickedItemIndex < 0) {
                    System.out.println("No item at that index!");
                } else {
                    Item gottenItem = player.getItemByIndex(pickedItemIndex - 1);
                    player.useItem(gottenItem);
                    exitValue = player.printInventory();
                    if (exitValue == 0) {
                        break;
                    }
                    System.out.println(exitValue + ": Exit inventory");
                    pickedItemIndex = keyboard.nextInt();
                }
            }
        }
    }

    public boolean askIfQuit() {
        System.out.println("Do you really wanna quit?");
        System.out.println("1: I really wanna quit" + "\n" + "2: No I won't give up yet!");
        int quitResult = keyboard.nextInt();
        if (quitResult == 1) {
            return false;
        } else {
            return true;
        }
    }

    protected String normalizeString(String nonNormalizedString) {
        nonNormalizedString = nonNormalizedString.trim().toLowerCase();
        if (nonNormalizedString.length() == 0) {
            return nonNormalizedString;
        } else {
            char firstLetter = Character.toUpperCase(nonNormalizedString.charAt(0));
            return firstLetter + nonNormalizedString.substring(1);
        }
    }

    private void travelDirection(int newX, int newY) {
        if (newX > 9 || newX < 0 || newY > 9 || newY < 0) {
            System.out.println("Invalid move!!");
        } else {
            Location oldLocation = map.getActivePlayerLocation();
            oldLocation.setVisited(true);
            oldLocation.setMapChar();
            map.setActivePlayerLocation(newX, newY);
        }
    }
    public static void main(String[] args) {
        new App().setUp();
    }
}
