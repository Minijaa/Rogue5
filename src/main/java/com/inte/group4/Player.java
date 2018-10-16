package com.inte.group4;

import java.awt.*;

public class Player {
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

}

