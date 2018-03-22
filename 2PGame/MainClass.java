/*
 * @author: Brandt Davis, Yichen Ding, Robert Harley, Nickole Jimenez, Jessica Pelley
 * Project: Group 7 - Turn Based Fighting Game
 * This class file is the main driver file to start the game. It holds information such
 * as the initial main menu, and the instructions on how to play.
 */

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass {
	// Main menu
	public static void main(String[] args) {
		Panel panel = new Panel();
		JFrame frame = new JFrame("War of Doom");
		frame.setContentPane(new JPanel(){
		    Image PlayStartImage = new ImageIcon("PlayStart.jpg").getImage();
		    public void paintComponent(Graphics g){
		    super.paintComponent(g);
		    g.drawImage(PlayStartImage, 0, 0, 1015, 635, this);
		    }
		});
		    
        JButton playButton = new JButton("Play");
		JButton instructionsButton = new JButton("Instructions");
		JButton quitButton = new JButton("Quit");
		
		frame.add(playButton);
		frame.add(instructionsButton);
		frame.add(quitButton);
		
		playButton.setLayout(null);
		
		playButton.setBounds(50, 40, 20,3);
		
		frame.setSize(1015, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		int mainMenuChoice = 0;
		Scanner keyboard = new Scanner(System.in);
		
		while (mainMenuChoice == 0) {
			System.out.println("========================");
		    System.out.println("THE BADASS FIGHTING GAME");
		    System.out.println("========================");
		    System.out.println();
		    System.out.println("1 - PLAY");
		    System.out.println("2 - INSTRUCTIONS");
		    System.out.println("3 - EXIT");
		    System.out.println();
		    System.out.print("What would you like to do? ");
		    mainMenuChoice = keyboard.nextInt();
		    
		    if (mainMenuChoice !=0 && mainMenuChoice != 1 && mainMenuChoice != 2 && mainMenuChoice != 3) {
		    	System.out.println("INVALID INPUT: Please indicate a number between 1 and 3.");
		    	mainMenuChoice = 0;
		    }
		    
			while (mainMenuChoice == 2) {
				// Game instructions
				getInstruction();
				System.out.println();
				System.out.print("Press 'm' to go back to the main menu: ");
				String instructionsChoice = keyboard.next();
				
				if (instructionsChoice.equals("m") || instructionsChoice.equals("M")) {
					System.out.println("Returning to menu.");
					mainMenuChoice = 0;
				}
				else {
					System.out.println("Invalid input. Press 'm' to go back to the menu");
					mainMenuChoice = 2;
				}
			}

			if (mainMenuChoice == 1) {
				Game game = new Game();
			    game.gameResult();
			}
			else if (mainMenuChoice == 3) {
				// Quit the game
		        System.out.println("Exit");
		    }

		}
	}

	public static void getInstruction() {
		System.out.println();
		System.out.println("============");
		System.out.println("INSTRUCTIONS");
		System.out.println("============");
		System.out.println();
		System.out.println("Don't suck.");
	}
}
