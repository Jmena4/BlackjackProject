package com.skilldistillery.cardgames.common;

public enum Suit {
	HEARTS("Hearts"), 
	SPADES("Spades"), 
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds"); 
	final private String name;

	Suit(String name) {
		this.name = name;

	}

	@Override
	public String toString() {
		return name;
	}

}
