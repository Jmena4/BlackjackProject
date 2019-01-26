package com.skilldistillery.cardgames.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class BlackjackHandSim {
	private List<Card> blackjackGame = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackHandSim app = new BlackjackHandSim();
		app.run();

	}

	public void run() {
		runBlackjackHand(sc);
	}

	public void runBlackjackHand(Scanner sc) {

		Deck blackjackDeck = new Deck();
		blackjackDeck.shuffle();
		BlackjackHand playerHand = new BlackjackHand();
		BlackjackHand dealerHand = new BlackjackHand();
		playerHand.addCard(blackjackDeck.dealCard());
		playerHand.getHandValue();
		dealerHand.addCard(blackjackDeck.dealCard());
		dealerHand.getHandValue();
		System.out.println("Player hand: " + playerHand);
		System.out.println("Dealer hand: " + dealerHand);

//		String input = "";
//		do {
//			System.out.println("Would you like to play of a game of BlackJack? "
//					+ "\ntype 'yes' to continue or 'no' to exit." );
//			input = sc.next();
//
//			sc.close();
//		} while (input != "no");
//		sc.close();
	}

}
