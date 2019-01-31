package com.skilldistillery.cardgames.blackjack;

import java.io.IOException;
import java.util.Scanner;

public class BlackjackHandSim {
	static Scanner sc = new Scanner(System.in);
	private int choice = 0;

	public static void main(String[] args) throws IOException, Exception {
		BlackjackHandSim app = new BlackjackHandSim();
		app.runBlackjackHandSim(sc);

	}

	private void runBlackjackHandSim(Scanner sc) {
//		BlackjackHand newBlackjackHand = new BlackjackHand();
//		newBlackjackHand.runBlackjackHand();
		boolean go = true;
		BlackjackPlayer p = new BlackjackPlayer();
		BlackjackDealer d = new BlackjackDealer();
//		while (go) {
		drawBlackjackHand(p, d);
		gotBlackjack(p, d);
		playerHitOrStand(p, d);

		dealerHitOrStand(d);

		blackjackWinner(p, d);
		continueGame(p, d); // need to figure out location of continue game
	}

//		while (go != false || d.getDeck().checkDeckSize() > 15) {
//			System.out.println(d.getHand().checkDeckSize()); // still reworking
//		}
//	}

	private void drawBlackjackHand(BlackjackPlayer p, BlackjackDealer d) {
		p.addCardToHand(d.dealCard());
		d.addCardToHand(d.dealCard());
		p.addCardToHand(d.dealCard());

		System.out.println("Player hand: \n" + p.getHand());
		System.out.print("Dealer hand: \n" + d.getHand());
		System.out.println("Card: ******FaceDown******");
		System.out.println();
		d.addCardToHand(d.dealCard());
	}

	private boolean gotBlackjack(BlackjackPlayer p, BlackjackDealer d) {
		boolean go = true;
		if (d.getHandValue() == 21) {
			System.out.println("Dealer hand: \n" + d.getHand());
			System.out.println("\nDealer Blackjack!!!");

			go = false;
		}
		if (p.getHandValue() == 21) {
			System.out.println("\nPlayer Blackjack!!!");
			go = false;
		}
		return go;
	}

	private boolean playerHitOrStand(BlackjackPlayer p, BlackjackDealer d) {
		boolean go = false;
		do {
			System.out.println("\nWould you like to: \n1)Hit or \n2)Stay");
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Incorrect Input, try again...");
				if (choice == 1) {
					p.addCardToHand(d.dealCard());
					go = true;
					if (choice == 2) {
						go = false;
					}
					System.out.println(p.getHand());
					checkPlayerHandBust(p);
				}
			}
		} while (choice != 2 && go != false);
		return go;

	}

	private boolean checkPlayerHandBust(BlackjackPlayer p) {
		if (p.getHandValue() > 21) {
			System.out.println(" \nPlayer Busts!!!");
			System.out.println("Player score: " + p.getHandValue());
		}
		return false;
	}

	private void dealerHitOrStand(BlackjackDealer d) {
		System.out.println("Player Stands");
//		System.out.println("Dealer hand: " + d.getHand());
		System.out.println();
		if (d.getHandValue() < 17) {
			d.addCardToHand(d.dealCard());
		}
		System.out.println("Dealer hand: \n" + d.getHand());
		checkDealerHandBust(d);
	}

	private boolean checkDealerHandBust(BlackjackDealer d) {
		if (d.getHandValue() > 21) {
			System.out.println("Dealer Busts!!!");
//			System.out.println("Dealer score: " + d.getHandValue());
		}
		return false;
	}

	private boolean blackjackWinner(BlackjackPlayer p, BlackjackDealer d) {
		boolean go = true;
		if (p.getHandValue() > d.getHandValue()) {
			playerWin();
			go = false;
		}
		if (p.getHandValue() < d.getHandValue()) {
			dealerWin();
			go = false;
		}
		if (p.getHandValue() == d.getHandValue()) {
			System.out.println("Player push!!!");
			System.out.println("Both scores equal: " + p.getHandValue());
			go = false;
		}
		return go;
	}

	private void continueGame(BlackjackPlayer p, BlackjackDealer d) {
		System.out.println("Would you like to continue playing?");
		System.out.println("1) Continue \n 2) Exit?");
		try {
			choice = sc.nextInt();
			if (choice == 1) {
				p.clearHand();
				d.clearHand();
			}
			if (choice == 2) {
				System.out.println("Exiting...");
//				sc.close();
			}
		} catch (Exception e) {
			System.out.println("Incorrect Input, try again...");
		}
	}

	private void dealerWin() {
		System.out.println("Dealer Wins!!!");
	}

	private void playerWin() {
		System.out.println("Player Wins!!!");
	}
}