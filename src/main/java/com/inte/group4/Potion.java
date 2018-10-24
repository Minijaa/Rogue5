package com.inte.group4;

public class Potion extends Item {
	private static final int MASSIVE_POTION_VALUE = 1000000;
	private static final int MAJOR_POTION_VALUE = 500;
	private static final int MINOR_POTION_VALUE = 200;
	private int currentHpIncrease;

	public Potion(int currentHpIncrease) {
		if (currentHpIncrease >= 0 && currentHpIncrease <= 200) {
			this.currentHpIncrease = MINOR_POTION_VALUE;
		} else if (currentHpIncrease > 200 && currentHpIncrease <= 500) {
			this.currentHpIncrease = MAJOR_POTION_VALUE;
		} else {
			this.currentHpIncrease = MASSIVE_POTION_VALUE;
		}
	}

	private String determineType() {
		String type;
		if (currentHpIncrease == MINOR_POTION_VALUE) {
			type = "Minor Healing: +" + currentHpIncrease + " HP";
		} else if (currentHpIncrease == MAJOR_POTION_VALUE) {
			type = "Major Healing: +" + currentHpIncrease + " HP";
		} else {
			type = "Massive Healing: +" + currentHpIncrease + " HP";
		}
		return type;
	}

	public int getHpIncreaseValue() {
		return currentHpIncrease;
	}

	@Override
	public String toString() {
		return "Potion of " + determineType();
	}
}
