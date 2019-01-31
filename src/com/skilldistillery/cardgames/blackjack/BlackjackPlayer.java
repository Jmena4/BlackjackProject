package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Participant;

public class BlackjackPlayer extends Participant {

	public BlackjackPlayer() {
		setHand(new BlackjackHand());
	}

}
