
/*
 * @author: Brandt Davis, Yichen Ding, Robert Harley, Nickole Jimenez, Jessica Pelley//
 * Project: Group 7 - Turn Based Fighting Game
 * This class file handles all of the cases for the CPU (if a 2-player game is chosen).
 * It holds information such as choosing your fighter, and class-specific attributes
 * such as damage output, defense mitigation, and special abilities.
 */

import java.util.Random;

public class Cpu {
	private String cpuCharacter = "";
	private int damage = 0;
	private int defense = 0;
	private int healPoints = 0;
	private int cpuChoice = 0;
	private int numOfnormalAttack = 0;
	private boolean block = false;
	private boolean archerAbility = false;
	private boolean wizardAbility = false;

	// Character select for the CPU based on a random number
	public void setCharacter() {
		Random randomCharacter = new Random();
		int cpuCharacterNum = randomCharacter.nextInt(3);

		if (cpuCharacterNum == 0) {
			cpuCharacter = "wizard";
			System.out.println("The CPU is a wizard.");

		} else if (cpuCharacterNum == 1) {
			cpuCharacter = "archer";
			System.out.println("The CPU is a archer.");

		} else {
			cpuCharacter = "warrior";
			System.out.println("The CPU is a warrior.");
		}
	}

	public void changestateOfBlock() {
		block = false;
	}

	public void changestateOfWizardAbility() {
		wizardAbility = false;
	}

	public boolean getstateOfBlock() {
		return block;
	}

	public boolean getstateOfWizardAbility() {
		return wizardAbility;
	}

	public boolean getstateOfArcherAbility() {
		return archerAbility;
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

	public int getCpuChoice() {
		return cpuChoice;
	}

	public void getAction() {
		if (cpuCharacter == "archer") {
			CpuArcher cpuArcher = new CpuArcher();
			cpuArcher.getArcherAction();
			damage = cpuArcher.getDamage();
			defense = cpuArcher.getDefense();
			block = cpuArcher.getstateOfBlock();
			archerAbility = cpuArcher.getstateOfArcherAbility();

		} else if (cpuCharacter == "warrior") {
			CpuWarrior cpuWarrior = new CpuWarrior();
			cpuWarrior.getWarriorAction();
			damage = cpuWarrior.getDamage();
			defense = cpuWarrior.getDefense();
			block = cpuWarrior.getstateOfBlock();

		} else {
			CpuWizard cpuWizard = new CpuWizard();
			cpuWizard.getWizardAction();
			damage = cpuWizard.getDamage();
			defense = cpuWizard.getDefense();
			block = cpuWizard.getstateOfBlock();
			wizardAbility = cpuWizard.getstateOfWizardAbility();
		}
	}
}
