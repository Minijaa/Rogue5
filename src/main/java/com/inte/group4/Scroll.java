package com.inte.group4;

public class Scroll extends Item implements Comparable<Scroll>{
	private int maxApBuff;
	private int maxHpBuff;

	private static final int HEALTH_SCROLL_HP_VALUE = 500;
	private static final int STRENGTH_SCROLL_AP_VALUE = 300;
	private static final int POWER_SCROLL_AP_VALUE = 100;
	private static final int POWER_SCROLL_HP_VALUE = 300;

	public Scroll(int maxApBuff, int maxHpBuff) {
		if (maxApBuff <= 0) {
			this.maxApBuff = 0;
			this.maxHpBuff = HEALTH_SCROLL_HP_VALUE;
		} else if (maxHpBuff <= 0) {
			this.maxApBuff = STRENGTH_SCROLL_AP_VALUE;
			this.maxHpBuff = 0;
		} else {
			this.maxApBuff = POWER_SCROLL_AP_VALUE;
			this.maxHpBuff = POWER_SCROLL_HP_VALUE;
		}
	}

	public int getMaxApBuff() {
		return maxApBuff;
	}

	public int getMaxHpBuff() {
		return maxHpBuff;
	}

	private String determineType() {
		String type;
		if (maxApBuff <= 0) {
			type = "Health: +" + maxHpBuff + " Max HP";
		} else if (maxHpBuff <= 0) {
			type = "Strength: +" + maxApBuff + " AP";
		} else {
			type = "Power: +" + maxApBuff + " AP / +" + maxHpBuff + " Max HP";
		}
		return type;
	}


	@Override
	public String toString() {
		return "Scroll of " + determineType();
	}

	@Override
	public int compareTo(Scroll other) {
		if(maxApBuff==0&& maxHpBuff>0){
			return -1;
		}else if (maxHpBuff==0&& maxApBuff>0){
			return 0;
		}else{
			return 1;
		}
	}
}
