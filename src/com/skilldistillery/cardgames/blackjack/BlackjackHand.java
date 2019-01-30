package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

import com.skilldistillery.cardgames.common.BlackjackDealer;
import com.skilldistillery.cardgames.common.BlackjackPlayer;
import com.skilldistillery.cardgames.common.Hand;

public class BlackjackHand extends Hand {
	boolean go = true;
	private int choice = 0;
	Scanner sc = new Scanner(System.in);

	public void runBlackjackHand() {

		BlackjackPlayer p = new BlackjackPlayer();
		BlackjackDealer d = new BlackjackDealer();
//		Deal first card to player and dealer

		drawOpeningCards(p, d);
		checkBlackjack(d, p);
		hitOrStand(p, d);
		continueGame(p, d);
	}

	private void drawOpeningCards(BlackjackPlayer p, BlackjackDealer d) {
		p.addCardToHand(d.dealCard());

		d.addCardToHand(d.dealCard());

//		Deal second card to player and dealer
		p.addCardToHand((d.dealCard()));

		System.out.print("Player hand: \n" + p.getHand() + "\n\n");
		System.out.print("Dealer hand: \n" + d.getHand());
		System.out.println("Card: ****FaceDown****");
		System.out.println();

		System.out.println("\tPlayer score: " + " " + p.getHandValue());
		System.out.println("\tDealer score: " + " " + d.getHandValue());
		d.addCardToHand(d.dealCard());
//		System.out.println(d.getHandValue()); // for Testing blackjack win on dealer
	}

	private void checkHands(BlackjackPlayer p, BlackjackDealer d) {
		if (p.getHandValue() > 21 || d.getHandValue() > 21) {
//			checkBust(p, d);
		}
		if (p.getHandValue() == d.getHandValue()) {
			System.out.println("Player push!!!");
			System.out.println("Both scores equal: " + p.getHandValue());
			go = false;
		}

		// compare scores to determine a 1 winner here
		if (p.getHandValue() > d.getHandValue()) {
			bothDisplayHand(p, d);
			playerWin();
		} else if (p.getHandValue() < d.getHandValue()) {
			bothDisplayHand(p, d);
			dealerWin();
		}
	}

	private void hitOrStand(BlackjackPlayer p, BlackjackDealer d) {
		while (go) {
			System.out.println("\nWould you like to: \n1)Hit or \n2)Stay");
			choice = sc.nextInt();
			if (choice == 1) {
				p.addCardToHand((d.dealCard()));
				System.out.println(p.getHand());
				System.out.println("\tPlayer Score: " + p.getHandValue());
				checkBust(p, d);
				go = true;
			}
			if (choice == 2) {
				System.out.println("Player Stays: ");
				dealerDisplayHand(d);
				System.out.println();
				if (d.getHandValue() < 17) {
					d.addCardToHand(d.dealCard());
				}
				dealerDisplayHand(d);
				checkBust(p, d);
				checkHands(p, d);
				go = false;
			}

		}

		while (choice != 2 && go != false) {
//			if (go == false) {
//				
//			}
		}

	}

	public void checkBust(BlackjackPlayer p, BlackjackDealer d) {
		if (p.getHandValue() > 21) {
			System.out.println(" \nPlayer Busts!!!");
			dealerWin();

			if (d.getHandValue() > 21) {
				System.out.println(" \nDealer Busts!!!");
				playerWin();

			} 
		}
		

	}

	private void checkBlackjack(BlackjackDealer d, BlackjackPlayer p) {
		if (d.getHandValue() == 21) {
			dealerDisplayHand(d);
			System.out.println("\nDealer Blackjack!!!");
			dealerWin();
		}
		if (p.getHandValue() == 21) {
			playerDisplayHand(p);
			System.out.println("\nPlayer Blackjack!!!");
			playerWin();
		}
	}

	private void bothDisplayHand(BlackjackPlayer p, BlackjackDealer d) {
		playerDisplayHand(p);
		dealerDisplayHand(d);
	}

	private void playerDisplayHand(BlackjackPlayer p) {
		System.out.println("Player hand: \n" + p.getHand());
		System.out.println("\tPlayer Score: " + p.getHandValue());
	}

	private void dealerDisplayHand(BlackjackDealer d) {
		System.out.print("Dealer hand: \n" + d.getHand());
		System.out.println("\tDealerScore: " + d.getHandValue());
	}

	private void playerWin() {
		System.out.println("Player Wins!!!");
	}

	private void dealerWin() {
		System.out.println("Dealer Wins!!!");
	}

	private void continueGame(BlackjackPlayer p, BlackjackDealer d) {
		System.out.println("Would you like to continue playing?");
		System.out.println("1) Continue \n 2) Exit?");
		choice = sc.nextInt();
		if (choice == 1) {
			p.clearHand();
			d.clearHand();
			runBlackjackHand();
		}
		if (choice == 2) {
			System.out.println("Exiting...");
			sc.close();
		}
	}

}