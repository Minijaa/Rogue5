package com.inte.group4;

abstract public class Sprite {

    private int ap;
    private int currentHp;
    private int maxHp;
    private boolean alive;

    public Sprite(int ap, int currentHp) {
        this.currentHp = currentHp;
        this.ap = ap;
        maxHp = currentHp;
        alive = true;
    }

    public final int getCurrentHp() {
        return currentHp;
    }

    public final int attack() {
        return getAp();
    }

    public final void decreaseHp(int attack) {
        setCurrentHp(getCurrentHp() - attack);
        if (getCurrentHp() <= 0) {
            setAlive(false);
        }
    }

    public void setCurrentHp(int newHp) {
        currentHp = newHp;
    }

    public void setCurrentAp(int newAp) {
        ap = newAp;
    }

    public final boolean isAlive() {
        return alive;
    }

    public final void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        String str = "AP:" + ap + " HP:" + currentHp;
        return str;
    }

    public int getAp() {
        return ap;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void addToMaxHp(int hpToAddToMaxHp) {
        maxHp += hpToAddToMaxHp;
    }

    public void addToCurrentHp(int hpToAddToCurrentHp) {
        if ((currentHp + hpToAddToCurrentHp) > maxHp) {
            currentHp = maxHp;
        } else {
            currentHp += hpToAddToCurrentHp;
        }
    }

    public void addToAp(int apToAddtoAp) {
        ap += apToAddtoAp;

    }
}
