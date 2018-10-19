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
        Point expectedPoint = new Point(oldOgrePoint.x+1,oldOgrePoint.y);
        Point newOgrePoint = newOgre.getCurrentMonsterCords();
        assertNotEquals(expectedPoint,newOgrePoint);

    }

    @Test
    public void testDecreaseOgreHp() {
        newOgre = new Ogre( 100, 200);
        newOgre.mockAttack( 100);
        newOgre.decreaseHp();
        int actual = newOgre.getHp();
        assertEquals(100,actual);
        }




}