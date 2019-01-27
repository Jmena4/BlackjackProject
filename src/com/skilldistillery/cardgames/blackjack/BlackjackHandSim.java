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
//		Blackjack  Deck is created
		Deck blackjackDeck = new Deck();

//		Deck is shuffled
		blackjackDeck.shuffle();

//		Player hand and Dealer hand  created
		BlackjackHand playerHand = new BlackjackHand();
		BlackjackHand dealerHand = new BlackjackHand();
//		First pair of cards dealt
		playerHand.addCard(blackjackDeck.dealCard());
//		System.out.println(playerHand.getHandValue());

		dealerHand.addCard(blackjackDeck.dealCard());
		dealerHand.getHandValue();

//		Second pair of Cards dealt
		playerHand.addCard(blackjackDeck.dealCard());
		System.out.print("Player hand: \n" + playerHand + " ");
		System.out.println("Player score" + " " + playerHand.getHandValue());

		System.out.println();

		dealerHand.addCard(blackjackDeck.dealCard());
		System.out.print("Dealer hand: \n" + dealerHand + " ");
		System.out.println("Dealer score" + " " + dealerHand.getHandValue());

		int playerScore = playerHand.getHandValue();
		int dealerScore = dealerHand.getHandValue();

		if (playerScore == 21 || dealerScore == 21) {
			System.out.println("Blackjack!!!");
		} else {
			while (playerScore == 21) {
				System.out.println("\nWould you like to: \n1)Hit or \n2)Stay");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Construct a hit");
					break;
				case 2:
					System.out.println("Construct a Stay");
					break;
				}
			}
		}
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
