package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<>();

	public Deck() {
		this.cards = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}
 
	public void shuffle() {
		
		Collections.shuffle(cards);
	}

	public int checkDeckSize() {

		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

}
