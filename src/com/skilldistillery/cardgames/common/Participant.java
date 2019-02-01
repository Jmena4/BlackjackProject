package com.skilldistillery.cardgames.common;

public abstract class Participant {
	private Hand hand;

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void addCardToHand(Card c) {
		hand.addCard(c);
	}

	public int getHandValue() {
		int counter = 0;
		for (Card card : hand.getCards()) {
			counter += card.getRank().getValue();
		}
		return counter;

	}

	public void clearHand() {
		hand.clearHand();
	}
	
//	public void hitOrStand(Card c) {
//		for (Hand hand : hand) {
//			
//		}
//		hand.addCard(c);
//	}
}
