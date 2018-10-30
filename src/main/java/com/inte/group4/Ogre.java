package com.inte.group4;

import java.awt.*;
import java.util.Random;

public class Ogre extends Monster {
	private static final int OGREHP = 300;
	private static final int OGREAP = 100;

	public Ogre(Point p) {
		super(OGREAP, OGREHP, p);
		monsterChar = 'G';
	}

	@Override
	public Point moveMonster() {
		Point ogrePoint = getCurrentMonsterCords();
		checkForBoundaries(ogrePoint);

		Point newOgrePoint;
		if (getIsUpOrLeft()) {
			newOgrePoint = new Point(ogrePoint.x + 1, ogrePoint.y);
		} else {
			newOgrePoint = new Point(ogrePoint.x - 1, ogrePoint.y);
		}
		return newOgrePoint;
	}

	protected void checkForBoundaries(Point currentPoint) {
		if (currentPoint.x == 0) {
			setUpOrLeft(true);
		} else if (currentPoint.x == 9) {
			setUpOrLeft(false);
		}
	}

	public String toString() {
		String str = "Ogre " + super.toString();
		return str;
	}
}
