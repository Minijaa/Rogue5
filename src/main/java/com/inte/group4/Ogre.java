package com.inte.group4;

import java.awt.*;

public class Ogre extends Monster {
    private static final String dieSound = "Graaaaaaw";

    public Ogre(int ap, int hp){
        super(ap,hp);
    }

    public String getDieSound(){
        return dieSound;
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
