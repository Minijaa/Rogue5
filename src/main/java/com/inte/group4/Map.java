package com.inte.group4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    private Location[][] mapGrid;
    private Location activePlayerLocation;
    private ArrayList<Monster> monsterList = new ArrayList<Monster>();
    private int gridSize;

    public Map() {
        mapGrid = new Location[10][10];
        createGrid();
        createAndPlaceMonsters();
    }

    private void createAndPlaceMonsters() {
        //Adding Ogres
        mapGrid[4][5].setMonster(new Ogre(new Point(4,5))).setUpOrLeft(true);
        mapGrid[2][2].setMonster(new Ogre(new Point(2,2))).setUpOrLeft(false);
        mapGrid[9][2].setMonster(new Ogre(new Point(9,2))).setUpOrLeft(true);
        mapGrid[1][4].setMonster(new Ogre(new Point(1,4))).setUpOrLeft(false);
        mapGrid[7][7].setMonster(new Ogre(new Point(7,7))).setUpOrLeft(false);

        //Adding Dragons
        mapGrid[2][3].setMonster(new Dragon(new Point(2,3))).setUpOrLeft(true);
        mapGrid[5][6].setMonster(new Dragon(new Point(5,6))).setUpOrLeft(false);
        mapGrid[0][7].setMonster(new Dragon(new Point(0,7))).setUpOrLeft(false);
        mapGrid[8][0].setMonster(new Dragon(new Point(8,0))).setUpOrLeft(true);
        mapGrid[7][3].setMonster(new Dragon(new Point(7,3))).setUpOrLeft(false);

        //Adding Worms
        mapGrid[0][9].setMonster(new Worm(new Point(0,9))).setUpOrLeft(false);
        mapGrid[2][0].setMonster(new Worm(new Point(2,0))).setUpOrLeft(true);
        mapGrid[4][9].setMonster(new Worm(new Point(4,9))).setUpOrLeft(false);
        mapGrid[6][0].setMonster(new Worm(new Point(6,0))).setUpOrLeft(true);
        mapGrid[8][9].setMonster(new Worm(new Point(8,9))).setUpOrLeft(false);

    }

    public String printGrid() {
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

    public void addMonsterToList(Monster monster){
        monsterList.add(monster);
    }

    public void removeMonsterFromList(Monster monster){
        monsterList.remove(monster);
    }


    public Point rndCords(){
        Random rnd= new Random();
        int x,y;
        Point cords;
        x = rnd.nextInt(10);
        y = rnd.nextInt(10);
        cords = new Point(x,y);
        return cords;
    }

    public void addMonsterToGrid(Monster monster){

        if(monsterList.size()<15){

            Point cords = new Point(rndCords());
            Location location = getLocationFromPoint(cords);
            if(location.getMonster() == null){
                monster.setCurrentMonsterCords(cords);
                location.setMonster(monster);
                addMonsterToList(monster);
                //System.out.println(monsterList.size());
                System.out.println(monster.toString());


            }
        } else{
            throw new IllegalArgumentException("There can only be 15 monsters in a map");
        }
    }

    public Monster getMonsterFromList(int index){
        return monsterList.get(index);
    }
    public int getMonsterListSize(){
        return monsterList.size();
    }
}