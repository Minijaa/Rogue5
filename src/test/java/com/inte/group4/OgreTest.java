package com.inte.group4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.awt.*;

class OgreTest {
    Ogre newOgre;


    @Test
    public void testCreateOgre(){
        newOgre = new Ogre( 100, 200);
        assertNotNull(newOgre);

    }

    @Test
    public void moveOgreMonsterTest(){
        newOgre = new Ogre( 100, 200);
        Point oldOgrePoint = newOgre.getCurrentMonsterCords();
        newOgre.moveMonster();
        Point newOgrePoint = newOgre.getCurrentMonsterCords();
        assertNotEquals(oldOgrePoint,newOgrePoint);
    }

    @Test
    public void testDecreaseOgreHpAndDie() {
        newOgre = new Ogre( 100, 200);
        newOgre.decreaseHp();
        int actual = newOgre.getHp();
        String actualString = newOgre.getDieSound();
        assertEquals(0,actual);
      //  assertEquals("Graaaaaaw",actualString);

    }
    @Test
    public void testDecreaseOgreHpAndNotDie() {

    }

}