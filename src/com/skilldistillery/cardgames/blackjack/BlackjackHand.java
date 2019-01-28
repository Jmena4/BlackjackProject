package com.skilldistillery.cardgames.blackjack;

import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Hand;

public class BlackjackHand extends Hand {
	private List<Card> blackjackDeck;

	public BlackjackHand() {
		blackjackDeck = new ArrayList<>();

	}

}
