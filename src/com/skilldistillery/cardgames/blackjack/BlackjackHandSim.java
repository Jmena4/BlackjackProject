package com.skilldistillery.cardgames.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cardgames.common.Card;

public class BlackjackHandSim {

	public static void main(String[] args) {
		BlackjackHandSim app = new BlackjackHandSim();
		app.run();

	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		runBlackjackHand(sc);
	}

	public void runBlackjackHand(Scanner sc) {
		List<Card> blackJackDeck = new ArrayList<>();

		System.out.println("How many cards would you like to add?");

		int input = sc.nextInt();
		sc.close();
	}

}
