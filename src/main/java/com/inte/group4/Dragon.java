package com.inte.group4;

import java.awt.*;

public class Dragon extends Monster {
    private static final int DRAGONHP= 400;
    private static final int DRAGONAP= 400;

    public Dragon(Point p){
        super(DRAGONAP,DRAGONHP,p);
        //monsterChar = 'D';
    }

    @Override
    public Point moveMonster() {
       Point currentPoint = this.getCurrentMonsterCords();
       Point newPoint;
       if(currentPoint.x==0){
           this.setUpOrLeft(false);
       }else if(currentPoint.y==0){
           this.setUpOrLeft(true);
       }
       if(this.getIsUpOrLeft()){
           int newX = currentPoint.x - 1;
           int newY = currentPoint.y + 1;
           newPoint= new Point(newX,newY);
       }else{
           int newX = currentPoint.x + 1;
           int newY = currentPoint.y - 1;
           newPoint= new Point(newX,newY);
       }
       System.out.print(newPoint);
       return newPoint;
    }

    public String toString() {
        String str = "Dragon " + super.toString();
        return str;
    }
}