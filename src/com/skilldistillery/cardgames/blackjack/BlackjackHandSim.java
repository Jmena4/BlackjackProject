package com.skilldistillery.cardgames.blackjack;

import java.io.IOException;
import java.util.Scanner;

public class BlackjackHandSim {
	static Scanner sc = new Scanner(System.in);

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
		do {
			drawBlackjackHand(p, d);
			go = playerGotBlackjack(p);
			go = dealerGotBlackjack(d);
			go = playerHitOrStand(p, d);
			go = dealerHitOrStand(d);
			go = blackjackWinner(p, d);
			continueGame(p, d); // need to figure out location of continue game
			System.out.println(d.getDeck().checkDeckSize());

		} while (go == true && (d.getDeck().checkDeckSize() >= 15) && p.getHandValue() < 21);

	}
	/* && d.getHandValue() < 21 */;
//		if (d.getDeck().checkDeckSize() <= 15) {
//			p.clearHand();
//			d.clearHand();
//			d.getDeck().shuffle();
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

	private boolean playerGotBlackjack(BlackjackPlayer p) {
		boolean go = true;
		if (p.getHandValue() == 21) {
			System.out.println("\nPlayer Blackjack!!!");
			go = false;
		}
		return go;
	}

	private boolean dealerGotBlackjack(BlackjackDealer d) {
		boolean go = true;
		if (d.getHandValue() == 21) {
			System.out.println("Dealer hand: \n" + d.getHand());
			System.out.println("\nDealer Blackjack!!!");
			go = false;
		}
		return go;
	}

	private boolean playerHitOrStand(BlackjackPlayer p, BlackjackDealer d) {
		int choice = 0;
		boolean go = true;
		do {
			System.out.println("\nWould you like to: \n1)Hit or \n2)Stay");
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Incorrect Input, try again...");
				sc.close();
			}

			if (choice == 1) {
				p.addCardToHand(d.dealCard());
				go = true;
			}
			if (choice == 2) {
				System.out.println("Player Stands");
				go = false;
			}
			System.out.println(p.getHand());
			go = checkPlayerHandBust(p);
		} while (choice != 2 && go != false);
		return go;

	}

	private boolean checkPlayerHandBust(BlackjackPlayer p) {
		boolean go = true;
		if (p.getHandValue() > 21) {
			System.out.println(" \nPlayer Busts!!!");
			System.out.println("\tPlayer score: " + p.getHandValue());
			go = false;
		}
		return go;
	}

	private boolean dealerHitOrStand(BlackjackDealer d) {
		boolean go = true;
		System.out.println();
		while (d.getHandValue() < 17) {
			d.addCardToHand(d.dealCard());
		}
		System.out.println("Dealer hand: \n" + d.getHand());
		go = checkDealerHandBust(d);
		return go;
	}

	private boolean checkDealerHandBust(BlackjackDealer d) {
		boolean go = true;
		if (d.getHandValue() > 21) {
			System.out.println("Dealer Busts!!!");
			go = false;
		}
		return go;
	}

	private boolean blackjackWinner(BlackjackPlayer p, BlackjackDealer d) {
		boolean go = true;
		if (p.getHandValue() > d.getHandValue() && p.getHandValue() <= 21) {
			playerWin();
			go = false;
		}
		if (p.getHandValue() < d.getHandValue() && d.getHandValue() <= 21) {
			dealerWin();
			go = false;
		}
		if (p.getHandValue() == d.getHandValue() && p.getHandValue() < 21 && d.getHandValue() < 21) {
			System.out.println("Player push!!!");
//			System.out.println("Both scores equal: " + p.getHandValue());
			go = false;
		}
		System.out.println("\tPlayer score: " + p.getHandValue() + "\n" + "\tDealer score: " + d.getHandValue());
		return go;
	}

	private void continueGame(BlackjackPlayer p, BlackjackDealer d) {
		int choice = 0;
		System.out.println("Would you like to continue playing?");
		System.out.println("1) Continue \n2) Exit?");
		try {
			choice = sc.nextInt();
			if (choice == 1) {
				p.clearHand();
				d.clearHand();
			}
			if (choice == 2) {
				System.out.println("Exiting...");
				p.clearHand();
				d.clearHand();
				System.exit(1);
//				d.getDeck().shuffle();
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