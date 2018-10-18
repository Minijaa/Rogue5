package com.inte.group4;

public class Dragon extends Monster {

    public Dragon(int ap, int hp){
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
        String str = "Dragon " + super.toString();
        return str;
    }
}
