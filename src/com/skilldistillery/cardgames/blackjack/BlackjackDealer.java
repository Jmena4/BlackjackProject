package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;
import com.skilldistillery.cardgames.common.Participant;

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
