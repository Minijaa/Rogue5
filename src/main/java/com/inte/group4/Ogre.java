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
        Point oldOgrePoint = getCurrentMonsterCords();
        setCurrentMonsterCords(new Point(3,3));
        return  currentMonsterCords;

    }

    @Override
    public void attack() {

    }

    @Override
    public void decreaseHp() {
        int newHp = getHp()-200;
        setHp(newHp);
        if(getHp()<=0){
          //  removeMonster(this);
           // System.out.print(getDieSound());
        }
    }

    public String toString() {
        String str = "Ogre " + super.toString();
        return str;
    }
}
