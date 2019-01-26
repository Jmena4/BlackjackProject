package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

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
		BlackjackHand(sc);
		
		sc.close();
	}

}
