package com.inte.group4;

abstract public class Sprite {

    private int ap;
    private int hp;

    public Sprite(int ap, int hp){
        this.hp = hp;
        this.ap = ap;
    }

    public int getHp(){
       return hp;
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
