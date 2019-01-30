package com.skilldistillery.cardgames.common;

import com.skilldistillery.cardgames.blackjack.BlackjackHand;

public class BlackjackPlayer extends Participant {

	public BlackjackPlayer() {
		setHand(new BlackjackHand());
	}

}
