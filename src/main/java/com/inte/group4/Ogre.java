package com.inte.group4;

public class Ogre extends Monster {

    public Ogre(int ap, int hp){
        super(ap,hp);
    }
    @Override
    public void moveMonster() {

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
