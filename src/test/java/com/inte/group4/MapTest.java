package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map newMap;
    Dragon dragon;
    Ogre ogre;
    Worm worm;

    @BeforeEach
    void setUp() {

        newMap = new Map();
        dragon = new Dragon(200,1000);
        ogre = new Ogre(300,1400);
        worm = new Worm(300,600);
        newMap.addMonsterToGrid(dragon);
        newMap.addMonsterToGrid(ogre);
        newMap.addMonsterToGrid(worm);

        do {
                Random rnd = new Random();
                int ap = 300 + rnd.nextInt(400);
                int hp = 500 + rnd.nextInt(1000);
            int monsterType = rnd.nextInt(3);
            switch (monsterType) {
                case 0:
                    Ogre tempOgre = new Ogre(ap, hp);
                    newMap.addMonsterToGrid(tempOgre);
                    break;
                case 1:
                    Worm tempWorm = new Worm(ap, hp);
                    newMap.addMonsterToGrid(tempWorm);
                    break;
                case 2:
                    Dragon tempDragon = new Dragon(ap, hp);
                    newMap.addMonsterToGrid(tempDragon);
                    break;

                default:
            }
        }while(newMap.getMonsterListSize()<15);
    }

    @Test
    public void testCreateNewMapObject() {
        assertNotNull(newMap.getLocationFromPoint(new Point(0, 0)));
    }

    @Test
    public void testGridSize() {
        assertEquals(100, newMap.gridSize());

    }
    @Test
    public void testPrintGrid(){
        String actualOutput = newMap.printGrid();

        String expectedOutput =
                "\nO O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O O O O O O O \n" +
                "O O O O X O O O O O ";

               assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void testSetActivePlayerLocation(){
        newMap.setActivePlayerLocation(3,5);

        Location playerLocation = newMap.getLocationFromPoint(new Point(3,5));

        assertEquals('X',playerLocation.getMapChar());

    }
    //Kristina
    @Test
    public void testThatMonsterIsAdded(){
        Monster monsterInArrayList = newMap.getMonsterFromList(5);
        Point cords = monsterInArrayList.getCurrentMonsterCords();
        Location location = newMap.getLocationFromPoint(cords);
        Monster monsterAtLocation = location.getMonster();
        assertEquals(monsterAtLocation, monsterInArrayList);
    }
    //Kristina
    @Test
    public void testRndCords(){
        Point pointToTest = new Point(newMap.rndCords());
        int x,y;
        int belowZero = -1;
        int above9 = 10;

        x = pointToTest.x;
        y = pointToTest.y;
        assertNotEquals(x, belowZero);
        assertNotEquals(x, above9);
        assertNotEquals(y, belowZero);
        assertNotEquals(y, above9);
    }
    //Kristina
    @Test
    public void testAddMonsterToGrid(){
        Monster monsterInArrayList = newMap.getMonsterFromList(7);
        Point point = monsterInArrayList.getCurrentMonsterCords();
        Location location = newMap.getLocationFromPoint(point);
        Monster monsterAtLocation = location.getMonster();
        assertEquals(monsterAtLocation.getCurrentMonsterCords(), monsterInArrayList.getCurrentMonsterCords());
        assertEquals(point, location.getMonster().getCurrentMonsterCords() );
    }
}