package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand extends Deck {
	private List<Card> hand;

	public Hand() {
		this.hand = new ArrayList<Card>();

	}

	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getRank().getValue();
		}
		return handValue;
	}

	// This method calls the Card object to construct a new card and add it to the
	public void addCard(Card card) {
		hand.add(card);
	}

	public void clearHand() {
		hand.clear();
	}

	public List<Card> getCards() {
		return hand;
	}

	@Override
	public String toString() {
		String handPrintOut = "";
		for (Card card : hand) {
			handPrintOut += card.toString();
		}
		return handPrintOut;

	}

}
