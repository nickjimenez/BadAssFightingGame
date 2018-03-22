/*
 * @author: Brandt Davis, Yichen Ding, Robert Harley, Nickole Jimenez, Jessica Pelley
 * Project: Group 7 - Turn Based Fighting Game
 * This class file handles all of the cases for the player. It holds information such
 * as choosing your fighter, and class-specific attributes such as damage output, defense
 * mitigation, and special abilities.
 */

import java.util.Random;
import java.util.Scanner;

public class Player {
	private String character = "";
	private int damage = 0;
	private int defense = 0;
	private int choice = 0;
	private int healPoints = 0;
	private boolean block = false;
	private boolean archerAbility = false;
	private boolean wizardAbility = false;

	// Character select screen
	public void setCharacter() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println();
		System.out.println("================");
		System.out.println("CHARACTER SELECT");
		System.out.println("================");
		System.out.println();
		System.out.println("1 - ARCHER");
		System.out.println("2 - WARRIOR");
		System.out.println("3 - WIZARD");
		System.out.println("4 - RANDOM");
		System.out.println();
		System.out.print("Choose your fighter: ");
		int characterChoice = keyboard.nextInt();

		if (characterChoice == 1) {
			character = "archer";
			System.out.println();
			System.out.println("You have picked the archer.");
			System.out.println();

		} else if (characterChoice == 2) {
			character = "warrior";
			System.out.println();
			System.out.println("You have picked the warrior.");
			System.out.println();

		} else if (characterChoice == 3) {
			character = "wizard";
			System.out.println();
			System.out.println("You have picked the wizard.");
			System.out.println();

		} else if (characterChoice == 4) {
			Random characterChoiceRandom = new Random();
			int randomCharacter = characterChoiceRandom.nextInt(3) + 1;

			if (randomCharacter == 1) {
				character = "archer";
				System.out.println();
				System.out.println("You have picked the archer.");
				System.out.println();

			} else if (randomCharacter == 2) {
				character = "warrior";
				System.out.println();
				System.out.println("You have picked the warrior.");
				System.out.println();

			} else if (randomCharacter == 3) {
				character = "wizard";
				System.out.println();
				System.out.println("You have picked the wizard.");
				System.out.println();
			}
		} else {
			System.out.println("INVALID INPUT: Please indicate a value in between 1 and 4.");
			setCharacter();
		}
	}
	

	public void changestateOfBlock() {
		block = false;
	}

	public boolean getstateOfBlock() {
		return block;
	}

	public void changestateOfWizardAbility() {
		wizardAbility = false;
	}

	public boolean getstateOfArcherAbility() {
		return archerAbility;
	}

	public boolean getstateOfWizardAbility() {
		return wizardAbility;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int value) {
		damage = value;
	}

	public int getDefense() {
		return defense;
	}

	public int getHealPoints() {
		return healPoints;
	}

	public int getChoice() {
		return choice;
	}

	public void getAction() {
		if (character == "archer") {
			PlayerArcher playerArcher = new PlayerArcher();
			playerArcher.getArcherAction();
			damage = playerArcher.getDamage();
			defense = playerArcher.getDefense();
			choice= playerArcher.getChoice();
			block = playerArcher.getstateOfBlock();
			archerAbility = playerArcher.getstateOfArcherAbility();
			healPoints= 0;

		} else if (character == "warrior") {
			PlayerWarrior playerWarrior = new PlayerWarrior();
			playerWarrior.getWarriorAction();
			damage = playerWarrior.getDamage();
			defense = playerWarrior.getDefense();
			choice= playerWarrior.getChoice();
			block = playerWarrior.getstateOfBlock();
			healPoints = playerWarrior.getHealPoints();

		} else {
			PlayerWizard playerWizard  = new PlayerWizard();
			playerWizard .getWizardAction();
			damage = playerWizard.getDamage();
			defense = playerWizard.getDefense();
			choice= playerWizard.getChoice();
			block = playerWizard.getstateOfBlock();
			wizardAbility = playerWizard.getstateOfWizardAbility();
			healPoints= 0;
		}
	}
}
