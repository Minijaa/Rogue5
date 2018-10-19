package com.inte.group4;

import java.awt.*;
import java.util.Random;

public class Ogre extends Monster {
    private int mockAttackPoints;


    public Ogre(int ap, int hp){
        super(ap,hp);
    }


    public void mockAttack(int attack){
        mockAttackPoints = attack;
    }

    @Override
    public Point moveMonster() {
        Random random = new Random();
        Point oldOgrePoint = getCurrentMonsterCords();
        int x = (int)oldOgrePoint.getX();
        int y = (int)oldOgrePoint.getY();
        Point up= new Point(x,y+1);
        Point down= new Point(x,y-1);
        Point left = new Point(x-1,y);
        Point right = new Point(x+1,y);

        Point directionArray[] = {up,down,left,right};
        int direction = random.nextInt(4);
        setCurrentMonsterCords(directionArray[direction]);
        return  currentMonsterCords;

    }

    @Override
    public void attack() {

    }

    @Override
    public void decreaseHp() {
        int newHp = getHp()-mockAttackPoints;
        setHp(newHp);
        if(getHp()<=0){
            //mockMap.removeMonsterFromList();
        }
    }

    public String toString() {
        String str = "Ogre " + super.toString();
        return str;
    }
}
