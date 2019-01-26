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
		String input= "";
		do {
			System.out.println("Would you like to play of a game of BlackJack? type 'yes' or 'no' to continue." );
			input = sc.next();
			System.out.println(input);
			playerHand.addCard(blackjackDeck.dealCard());
			playerHand.getHandValue();

			sc.close();
		} while (input != "no");
		sc.close();
	}

}
