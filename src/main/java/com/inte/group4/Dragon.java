package com.inte.group4;

import java.awt.*;

public class Dragon extends Monster {
    private static final int DRAGONHP= 400;
    private static final int DRAGONAP= 400;

    public Dragon(Point p){
        super(DRAGONAP,DRAGONHP,p);
    }

    @Override
    public Point moveMonster() {
        return null;
    }

    public String toString() {
        String str = "Dragon " + super.toString();
        return str;
    }
}
