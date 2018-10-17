package com.inte.group4;

import java.awt.*;

public class Player extends Sprite{
    private Point currentPosition;

    public Player(Point position){
        currentPosition = position;
    }
    public Point getPosition() {
        return currentPosition;
    }

    public void setPosition(Point newPosition) {
        currentPosition = newPosition;

    }

    @Override
    public void attack() {

    }

    public void decreaseHp(){

    }

}

