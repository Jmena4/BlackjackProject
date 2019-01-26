package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	List<Card> newDeck = new ArrayList<>();
	
	public Hand() {

	}

	public int getHandValue() {

		return 0;
	}

	public void addCard(Rank rank, Suit suit) {

	}

	public void clearHand() {

	}

	public List<Card> getCars() {

		return null;

	}

	@Override
	public String toString() {

		return null;

	}

}
