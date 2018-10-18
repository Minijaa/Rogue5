package com.inte.group4;

abstract public class Sprite {

    private int ap;
    private int hp;


    public Sprite(int ap, int hp){
        this.ap = ap;
        this.hp = hp;
    }

    abstract public void attack();
    //random*Ap = skada
    abstract public void decreaseHp();

    @Override
    public String toString() {
        String str = "Ap:" + ap + " HP:" + hp ;
        return str;
    }
}
