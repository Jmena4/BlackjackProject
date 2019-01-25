package com.skilldistillery.cardgames.common;

import java.util.List;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Rank;
import com.skilldistillery.cardgames.common.Suit;

public abstract class Hand {

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
