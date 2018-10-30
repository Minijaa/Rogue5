package com.inte.group4;

import java.util.Random;

public class Bandage extends Item implements Comparable<Bandage> {
	private int hpIncreaseValue;

	public Bandage() {
		Random rnd = new Random();
		int baseValue = 100;
		hpIncreaseValue = baseValue + rnd.nextInt(400);
	}

	private String determineType() {
		String type;
		if (hpIncreaseValue <= 250) {
			type = "Dirty ";
		} else if (hpIncreaseValue <= 350) {
			type = "Cleanish ";
		} else {
			type = "Sterile ";
		}
		return type;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Bandage) {
			Bandage o = (Bandage) other;
			return hpIncreaseValue == o.hpIncreaseValue;
		} else {
			return false;
		}
	}

//	@Override
//	public int hashCode() {
//		assert false : "hashCode not designed";
//		return 42;
//	}

	@Override
	public int compareTo(Bandage other) {
		if (hpIncreaseValue < other.hpIncreaseValue) {
			return -1;
		} else if (hpIncreaseValue > other.hpIncreaseValue) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return determineType() + "Bandage: +" + hpIncreaseValue + " HP";
	}

	public int getHpIncreaseValue() {
		return hpIncreaseValue;
	}

	// for test
	public void setHpIncreaseValue(int hpToIncrease) {
		hpIncreaseValue = hpToIncrease;
	}
}
