package com.inte.group4;

import java.util.Scanner;

//@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DM_DEFAULT_ENCODING")
public class App {

    private Map map;
    private Scanner keyboard = new Scanner(System.in);
    private Player player;

    //ändra!
    public App(int i) {
        setUp();
    }

    public App() {
        setUp();
        runCommandLoop();
    }

    private void setUp() {
        map = new Map();
        player = new Player(100, 1000);
    }
    public Player getPlayer(){
        return player;
    }
    public Map getMap() {
        return map;
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
                    System.out.println("Wrong input, try again! - Runcommandloop");
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

    boolean checkMonsterAtLocation() {
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
        Location currentLocation = map.getActivePlayerLocation();
        currentLocation.setLocationText("FIGHT!!!");
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
        player.sortInventory();
        if (player.getItemFromInventoryByIndex(0) != null && player.getItemFromInventoryByIndex(0) instanceof Potion) {
            Potion pot = (Potion) player.getItemFromInventoryByIndex(0);
            player.useInventoryItem(pot);
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
        if (!player.isAlive()) {
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
                    running = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input, try again! - Game over");
            }
        }
    }

    int getTreasure() {
        Location activeLocation = map.getActivePlayerLocation();
        Item treasure = activeLocation.getTreasure();

        if (treasure != null) {
            if (player.getInventorySize() == player.getMaxInventorySize()) {
                System.out.println("Inventory FULL, use an item to pick up treasure!");
                return 0;
            } else {
                player.addItemToInventory(treasure);
                activeLocation.removeTreasure();
                return 1;
            }
        }
        return -1;
    }

    boolean lastMonsterOnMap() {
        if (map.getMonsterListSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void openInventoryCommand() {
        player.sortInventory();
        int exitValue = player.printInventory();
        if (exitValue != 1) {
            System.out.println(exitValue + ": Exit inventory");
            int pickedItemIndex = keyboard.nextInt();
            keyboard.nextLine();

            while (pickedItemIndex != (exitValue)) {
                if (pickedItemIndex > player.getInventorySize() || pickedItemIndex < 0) {
                    System.out.println("No item at that index!");
                } else {
                    Item gottenItem = player.getItemFromInventoryByIndex(pickedItemIndex - 1);
                    player.useInventoryItem(gottenItem);
                }
                exitValue = player.printInventory();
                if (exitValue == 0) {
                    break;
                }
                System.out.println(exitValue + ": Exit inventory");
                pickedItemIndex = keyboard.nextInt();
                keyboard.nextLine();
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

    String travelDirection(int newX, int newY) {
        StringBuilder appBuilder = new StringBuilder("");
        if (newX > 9 || newX < 0 || newY > 9 || newY < 0) {
            System.out.println("Invalid move!!");
            appBuilder.append("Invalid move!!");
            return appBuilder.toString();
        } else {
            Location oldLocation = map.getActivePlayerLocation();
            oldLocation.setVisited(true);
            oldLocation.setMapChar();
            map.setActivePlayerLocation(newX, newY);
            appBuilder.append("Valid move!!");
            return appBuilder.toString();
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
