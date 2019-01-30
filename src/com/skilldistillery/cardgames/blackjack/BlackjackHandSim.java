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
		BlackjackHand newBlackjackHand = new BlackjackHand();
		newBlackjackHand.runBlackjackHand();
	}

}
