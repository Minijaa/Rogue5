package com.inte.group4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
        assertNotEquals(newOgrePoint,oldOgrePoint);

    }


    @Test
    public void testDecreaseOgreHpAndDie() {
        newOgre = new Ogre( 100, 200);
        int hpToDecreaseFromAttack = 200;
        int actual = newOgre.getHp()-hpToDecreaseFromAttack;
        String actualString = newOgre.getDieSound();
        assertEquals(0,actual);
        assertEquals("Graaaaaaw",actualString);

    }
    @Test
    public void testDecreaseOgreHpAndNotDie() {
        newOgre = new Ogre( 100, 200);
        int hpToDecreaseFromAttack = 10;
        int actual = newOgre.getHp()-hpToDecreaseFromAttack;
        assertEquals(190,actual);
    }

}