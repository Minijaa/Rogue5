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
       assertEquals(1,isNeighbourOf(newOgrePoint, oldOgrePoint));

    }

    private int isNeighbourOf(Point newPoint, Point oldPoint) {
        int d1 = Math.abs(newPoint.y - oldPoint.y);
        int d2 = Math.abs(newPoint.x - oldPoint.x);
        return d1 + d2 ;
    }

    @Test
    public void testDecreaseOgreHp() {
        newOgre = new Ogre( 100, 200);
        newOgre.mockAttack( 100);
        newOgre.decreaseHp(10);
        int actual = newOgre.getCurrentHp();
        assertEquals(100,actual);
        }






}