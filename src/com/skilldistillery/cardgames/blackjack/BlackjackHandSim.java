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
		System.out.print("Player hand: \n" + playerHand);
		System.out.println("\tPlayer score" + " " + playerHand.getHandValue());
		System.out.println();
		System.out.print("Dealer hand: \n" + dealerHand);
		System.out.println("Card: ****FaceDown****");
		System.out.println("\tDealer score" + " " + dealerHand.getHandValue());

		dealerHand.addCard(blackjackDeck.dealCard());

		int playerScore = playerHand.getHandValue();
		int dealerScore = dealerHand.getHandValue();

		if (playerScore == 21) {
			System.out.println("\nPlayer Wins Blackjack!!!");
		}
		if (dealerScore == 21) {
			System.out.print("Dealer hand: \n" + dealerHand + " "); // for testing
			System.out.println("\nDealer Wins Blackjack!!!");
		} else {
			while (playerScore <= 22) {
//				if (((dealerHand.getHandValue() > 22 || ((playerHand.getHandValue() > 22))))) {
//					System.err.println("Bust!!!");
//				}
				int choice;
				do {
					System.out.print("\nWould you like to: \n1)Hit or \n2)Stay");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						playerScore += playerHand.getHandValue();
						System.out.println(playerScore);
						break;
					case 2:
						System.out.println("Player Stay" + " " + playerHand.getHandValue());
						System.out.println(dealerScore);
						break;
					}
					if (dealerScore > 22) {
						System.err.println("Dealer Busts!!!");
						playerWin();

					}
					if (playerScore > 22) {
						System.err.println("Player Busts!!!");
						//compare scores to determine a winner here
						dealerWin();
					}
					if (dealerScore < 17 && dealerScore <= 21) {
						dealerHand.addCard(blackjackDeck.dealCard());
					}
				} while (choice != 2);

			}
		}
//		System.out.println("Players Score is: " + playerScore);
	}

	public void playerWin() {
		System.out.println("Player Wins!!!");
	}

	public void dealerWin() {
		System.out.println("Dealer Wins!!!");
	}

}
