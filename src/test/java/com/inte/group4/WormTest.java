package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WormTest {
	private Worm testWorm;

	@BeforeEach
	void setUp() {
		testWorm = new Worm(new Point(1, 1));
	}

	@Test
	void moveMonsterTest() {
		testWorm.setUpOrLeft(true); // Tell worm to travel upwards
		Point newPosition = testWorm.generatePointForMonsterMovement();
		Point expectedPoint = new Point(1, 2);
		assertEquals(newPosition, expectedPoint);
		testWorm.setUpOrLeft(false); // Tell worm to travel downwards
		newPosition = testWorm.generatePointForMonsterMovement();
		expectedPoint.y = 0;
		assertEquals(newPosition, expectedPoint);
	}

	@Test
	void testBoundaries() {
		Worm lowerBoundaryWorm = new Worm(new Point(4, 0));
		Worm upperBoundaryWorm = new Worm(new Point(4, 9));

		lowerBoundaryWorm.setUpOrLeft(false); // Tell worm to travel downwards
		upperBoundaryWorm.setUpOrLeft(true); // Tell worm to travel upwards
		Point lowerWormPosition = lowerBoundaryWorm.generatePointForMonsterMovement();
		Point upperWormPosition = upperBoundaryWorm.generatePointForMonsterMovement();

		assertTrue(lowerWormPosition.equals(new Point(4, 1)) && upperWormPosition.equals(new Point(4, 8)));
		assertTrue(lowerBoundaryWorm.getIsUpOrLeft());
		assertFalse(upperBoundaryWorm.getIsUpOrLeft());
	}

	@Test
	public void toStringWormTest() {
		Worm testWorm = new Worm(new Point(3, 2));
		String expectedtoString = "Worm AP:400 HP:200 cords: 3:2";
		assertEquals(expectedtoString, testWorm.toString());
	}
}
