package com.inte.group4;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    Location testLocation;



     @Test
    public void testPlayerEntersLocationWithMonster() {
        Point p = new Point(0,0);
         testLocation = new Location(p);
      //  Monster m  = (Monster) new Ogre( 100, 200);
       // testLocation.setMonster(m);

        String actual = testLocation.playerEntersLocation();
        assertEquals("FIGHT!!!",actual);

    }
    @Test
    public void testPlayerEntersLocationWithNoMonster() {
        Point p = new Point(0,0);
        testLocation = new Location(p);

        String actual = testLocation.playerEntersLocation();
        assertEquals("silence",actual);
    }


}