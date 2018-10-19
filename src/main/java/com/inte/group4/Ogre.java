package com.inte.group4;

import java.awt.*;

public class Ogre extends Monster {
    private static final String dieSound = "Graaaaaaw";
    private int mockAttackPoints;


    public Ogre(int ap, int hp){
        super(ap,hp);
    }

    public String getDieSound(){
        return dieSound;
    }
    public void mockAttack(int attack){
        mockAttackPoints = attack;
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
        int newHp = getHp()-mockAttackPoints;
        setHp(newHp);

    }

    public String toString() {
        String str = "Ogre " + super.toString();
        return str;
    }
}
