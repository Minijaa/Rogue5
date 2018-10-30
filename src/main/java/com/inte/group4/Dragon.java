package com.inte.group4;

import java.awt.*;

public class Dragon extends Monster {
	private static final int DRAGONHP = 500;
	private static final int DRAGONAP = 300;

	public Dragon(Point p) {
		super(DRAGONAP, DRAGONHP, p);
		setMonsterChar('#');
	}

	@Override
	public Point generatePointForMonsterMovement() {
		Point currentPoint = this.getCurrentMonsterCords();
		checkForBoundaries(currentPoint);
		Point newPoint;
		if (this.getIsUpOrLeft()) {
			int newX = currentPoint.x - 1;
			int newY = currentPoint.y + 1;
			newPoint = new Point(newX, newY);
		} else {
			int newX = currentPoint.x + 1;
			int newY = currentPoint.y - 1;
			newPoint = new Point(newX, newY);
		}
		return newPoint;
	}

	protected void checkForBoundaries(Point currentPoint) {
		if (currentPoint.x == 0 || currentPoint.y == 9) {
			this.setUpOrLeft(false);
		} else if (currentPoint.x == 9 || currentPoint.y == 0) {
			this.setUpOrLeft(true);
		}
	}

	public String toString() {
		String str = "Dragon " + super.toString();
		return str;
	}
}