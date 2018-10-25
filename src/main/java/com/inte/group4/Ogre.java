package com.inte.group4;

import java.awt.*;
import java.util.Random;

public class Ogre extends Monster {
    private int mockAttackPoints;
    private static final int OGREHP= 100;
    private static final int OGREAP= 100;
    private boolean direction;



    public Ogre(Point p){
        super(OGREAP,OGREHP, p);
        monsterChar = 'G';
    }

    public void mockAttack(int attack){
        mockAttackPoints = attack;
    }


    private Point setDirection(int x, int y){
        Point newDirection;
        if (!(direction)){
            newDirection = new Point(x-1,y);
        }else{
            newDirection = new Point(x+1,y);
        }
        return newDirection;
    }

    @Override
    public Point moveMonster() {
      Point ogrePoint = getCurrentMonsterCords();
       int x = (int)ogrePoint.getX();
       int y = (int)ogrePoint.getY();
       checkforWall();
       Point newOgrePoint= setDirection(x,y);
       setCurrentMonsterCords(newOgrePoint);
        return  newOgrePoint;
   }
   private void checkforWall() {
       int x = (int)getCurrentMonsterCords().getX();
        if(x==0){
            direction=true;
        }else if(x==9){
            direction=false;
        }
   }

    public String toString() {
        String str = "Ogre " + super.toString();
        return str;
    }
}
