package com.skilldistillery.cardgames.common;

import com.skilldistillery.cardgames.blackjack.BlackjackHand;

public class BlackjackDealer extends Participant {
	private Deck deck;

	public BlackjackDealer() {

		setHand(new BlackjackHand());

		deck = new Deck();
		deck.shuffle();
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Card dealCard() {

		return deck.dealCard();

	}

}
