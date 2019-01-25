package com.skilldistillery.cardgames.common;

public enum Suit {
	HEARTS("Hearts"), // try using emoji suits here "Hearts" or (Character.toChars(0x2665)
	SPADES("Spades"), // (Character.toChars(0x2660)
	CLUBS("Clubs"), // (Character.toChars(0x2663)
	DIAMONDS("Diamonds"); // (Character.toChars(0x2666)
	final private String name;

	Suit(String name) {
		this.name = name;

	}

	@Override
	public String toString() {
		return name;
	}

}
