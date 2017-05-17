package com.scarabcoder.gameapi.enums;

public enum TeamSpreadType {
	/**
	 * Will select random team if both teams are even, otherwise the team with less players.
	 */
	EVEN, 
	/**
	 * Will fill first team, then when full second team, and so on.
	 */
	FIRST_AVAILABLE
}
