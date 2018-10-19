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