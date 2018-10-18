package com.inte.group4;

public class Worm extends Monster {

    public Worm(int ap, int hp){
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
        String str = "Worm " + super.toString();
        return str;
    }
}
