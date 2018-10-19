package com.inte.group4;

import java.awt.*;

public class Player extends Sprite{
	
	private boolean alive;


    public Player(int ap, int hp){
        super(ap,hp);
        alive = true;
    }


    @Override
    public void attack() {

    }

    public void decreaseHp(){

    }
    
    public void decreaseHp(int attack) {
    	setHp(getHp() - attack);
    	if(getHp() <= 0) {
    		setAlive(false);
    	}
    }


	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}
    

}

