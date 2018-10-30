package com.inte.group4;

import java.awt.*;

public class Worm extends Monster {
	private static final int WORMHP = 200;
	private static final int WORMAP = 400;

	public Worm(Point p) {
		super(WORMAP, WORMHP, p);
		monsterChar = 'W';
	}

	@Override
	public Point moveMonster() {
		Point oldPosition = currentMonsterCords;
		Point newPosition;
		checkForBoundaries(oldPosition);
		if (isUpOrLeft()) {
			newPosition = new Point(oldPosition.x, (oldPosition.y + 1));
		} else {
			newPosition = new Point(oldPosition.x, (oldPosition.y - 1));
		}
		return newPosition;
	}

	protected void checkForBoundaries(Point oldPosition) {
		if (oldPosition.y == 0) {
			setUpOrLeft(true);
		} else if (oldPosition.y == 9) {
			setUpOrLeft(false);
		}
	}

	public String toString() {
		String str = "Worm " + super.toString();
		return str;
	}
}
