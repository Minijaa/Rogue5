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
    public void moveOgreMonsterTest(){
        newOgre = new Ogre(new Point(4,4));
        newOgre.moveMonster();
        Point newOgrePoint = newOgre.getCurrentMonsterCords();
        Point expected = new Point(3,4);
        assertEquals(expected,newOgrePoint);

    }


    @Test
    public void testDecreaseOgreHp() {
        newOgre = new Ogre(new Point(4,4));
        newOgre.mockAttack( 100);
        newOgre.decreaseHp(10);
        int actual = newOgre.getCurrentHp();
        assertEquals(190,actual);
        }


}