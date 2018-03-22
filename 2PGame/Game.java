/*
 * @author: Brandt Davis, Yichen Ding, Robert Harley, Nickole Jimenez, Jessica Pelley
 * Project: Group 7 - Turn Based Fighting Game
 * This class file handles the main core gameplay. It holds information such
 * as seeing who goes first (by "flipping a coin"), switching between turns,
 * health changes, and ending the game when someone's health is <= 0.
 */

import java.util.Random;
import java.util.Scanner;

public class Game {
	private int numOfPlayer = 0;
	private int numOfTurn = 0;


	public int numOfTurn() {
		numOfTurn += 1;
		return numOfTurn;
	}

	public void getNumOfPlayer() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("Choose number of players, please");
		System.out.println("---------------------------------");
		System.out.println("1. Player V.S. Computer");
		System.out.println("2. Player1 V.S. Player2");
		System.out.println(" ");
		System.out.println("-----------------------");
		numOfPlayer = keyboard.nextInt();
	}

	public String flipCoinResult() {
		int randomNum;
		String result;
		randomNum = new Random().nextInt(2);
		System.out.printf("Random Number: %d \n", randomNum);
		if (randomNum < 1) {
			result = "Heads";
		} else {
			result = "Tails";
		}
		System.out.format("Coin toss result: %s", result);
		System.out.println("");
		return result;
	}


	public void gameResult() {
		getNumOfPlayer();
		if (numOfPlayer == 1) {
			CpuVsP1 cpuVsP1 = new CpuVsP1();
			cpuVsP1.PlayerVsCpu();
		} else if (numOfPlayer == 2) {
			P1VsP2 p1VsP2 = new P1VsP2();
			p1VsP2.PlayerVsPlayer();
		}else{
			System.out.print("INVALID INPUT: Please indicate a value in between 1 and 2.\n");
			getNumOfPlayer();
			gameResult();
		}
	}

	public void testMethod() {
		int turnNum = numOfTurn();
		System.out.println("");
		System.out.println("You have tested the numOfTurn() method and now is Turn" + numOfTurn);
		System.out.println("");
		getNumOfPlayer();
		System.out.println("");
		System.out.println("You have tested the getNumOfPlayer() method");
		System.out.println("");
		getNumOfPlayer();
		String flipCoinResult = flipCoinResult();
		System.out.println("");
		System.out.println("You have tested the flipCoinResult() method and the result of it is the " + flipCoinResult);
		System.out.println("");
		CpuVsP1 cpuVsP1 = new CpuVsP1();
		cpuVsP1.PlayerVsCpu();
		System.out.println("");
		System.out.println("You have tested the PlayerVsCpu() method and the result of it is the " + flipCoinResult);
		System.out.println("");
		P1VsP2 p1VsP2 = new P1VsP2();
		p1VsP2.PlayerVsPlayer();
		System.out.println("");
		System.out.println("You have tested the PlayerVsPlayer() method and the result of it is the " + flipCoinResult);
		System.out.println("");
		gameResult();
		System.out.println("");
		System.out.println("You have tested the gameResult() method and the result of it is the " + flipCoinResult);
		System.out.println("");
	}

}
