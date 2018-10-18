package com.inte.group4;

import java.awt.*;

public class Ogre extends Monster {

    public Ogre(int ap, int hp){
        super(ap,hp);
    }
    @Override
    public Point moveMonster() {
    return null;
    }

    @Override
    public void attack() {

    }

    @Override
    public void decreaseHp() {

    }
    public String toString() {
        String str = "Ogre " + super.toString();
        return str;
    }
}
