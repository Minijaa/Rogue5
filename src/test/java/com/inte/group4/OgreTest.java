package com.inte.group4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.awt.*;

class OgreTest {
    Ogre newOgre;

    @Test
    public void testCreateOgre(){
        newOgre = new Ogre(new Point(4,4));
        assertNotNull(newOgre);
    }

    @Test
    public void moveOgreMonsterTestLeft(){
        newOgre = new Ogre(new Point(4,4));
        for(int i=0;i<6;i++){
            newOgre.moveMonster();
        }
        Point newOgrePoint = newOgre.getCurrentMonsterCords();
        Point expected = new Point(2,4);
        assertEquals(expected,newOgrePoint);
    }
    @Test
    public void moveOgreMonsterTestRight(){
        newOgre  = new Ogre(new Point(0,4));
        for(int i=0;i<12;i++){
            newOgre .moveMonster();
        }
        Point newOgrePoint = newOgre .getCurrentMonsterCords();
        Point expected = new Point(6,4);
        assertEquals(expected,newOgrePoint);
    }

    @Test
    public void testDecreaseOgreHp() {
        newOgre = new Ogre(new Point(4,4));
        newOgre.mockAttack( 100);
        newOgre.decreaseHp(10);
        int actual = newOgre.getCurrentHp();
        assertEquals(90,actual);
        }

}