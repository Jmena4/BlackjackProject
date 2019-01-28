package com.skilldistillery.cardgames.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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

		boolean go = true;
		int choice = 0;

		while (go) {
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

			} else if (dealerScore == 21) {
				System.out.print("Dealer hand: \n" + dealerHand + " "); // for testing
				System.out.println("\nDealer Wins Blackjack!!!");

			} else {
				do {
					System.out.println("\nWould you like to: \n1)Hit or \n2)Stay");
					try {
						choice = sc.nextInt();
					} catch (Exception e) {

						e.printStackTrace();
						break;
					}
					switch (choice) {
					case 1:
						playerHand.addCard(blackjackDeck.dealCard());
						playerScore = playerHand.getHandValue();
						System.out.print(playerHand);
						System.out.println("\tPlayer Score " + playerScore);

						break;
					case 2:
						System.out.println("Player Stays: ");
//						System.out.println(dealerHand.getHandValue());
						System.out.println("Dealer hand: \n" + dealerHand);
						if (dealerScore <= 16) {
							dealerHand.addCard(blackjackDeck.dealCard());
							System.out.println("Dealer hand: \n" + dealerHand);
						}

						// compare scores to determine a 1 winner here
						if (playerScore > dealerScore) {
							playerWin();
							System.out.println("Player Score " + playerHand.getHandValue());
							System.out.println("DealerScore " + dealerHand.getHandValue());
						} else if (dealerScore > playerScore) {
							dealerWin();
							System.out.println("Player Score " + playerHand.getHandValue());
							System.out.println("DealerScore " + dealerHand.getHandValue());
							break;
						}
					}
					if (playerScore > 21 || dealerScore > 21) {
						checkBust(playerScore, dealerScore);
					}
					while (choice != 2 && playerScore < 21)
						;
					if (go != false) {
						dealerHand.clearHand();
						playerHand.clearHand();
						System.out.println("would you like to play another game?");
						System.out.println("type '1' to continue or '2' to exit");
						int relaunchchoice = sc.nextInt();
						if (relaunchchoice == 1) {
							runBlackjackHand(sc);
						} else if (relaunchchoice == 2) {
							System.out.println("Exiting Blackjack game...");
							System.exit(1);
						}
					}

				} while (go == true && blackjackDeck.checkDeckSize() >= 15);
			}
		}
	}

	public void playerWin() {
		System.out.println("Player Wins!!!");
	}

	public void dealerWin() {
		System.out.println("Dealer Wins!!!");
	}

	public void compareHands() {

	}

	public void checkBust(int playerScore, int dealerScore) {
		if (playerScore > 21) {
			System.out.println(" \nPlayer Busts!!!");
			dealerWin();
			if (dealerScore > 21) {
				System.out.println(" \nDealer Busts!!!");
				playerWin();
			}
		}
	}
}
