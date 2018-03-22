import java.util.Random;
import java.util.Scanner;

public class PlayerWarrior {
	private int actionProbability = 7;
	private int damage = 0;
	private int defense = 0;
	private int choice = 0;
	private int randomProbability = 0;
	private boolean block = false;
	private boolean archerAbility = false;
	private int numOfnormalAttack = 0;
	private int healPoints = 0;

	// If the player is a warrior
	public void getWarriorAction() {
		Scanner warriorInput = new Scanner(System.in);
		System.out.println();
		System.out.println("=========");
		System.out.println("YOUR TURN");
		System.out.println("=========");
		System.out.println();
		System.out.println("1 - Normal attack");
		System.out.println("2 - Block");
		System.out.println("3 - Special ability (WILL BE AVAILABE AFTER 5 ATTACKS)");
		System.out.println();
		System.out.print("What would you like to do? ");
		choice = warriorInput.nextInt();
		healPoints = 0;

		// Attack
		// A warrior can deal anywhere between 6-8 damage each attack phase, and
		// mitigates 3-5 incoming damage
		if (choice == 1) {

			if (randomProbability() <= actionProbability) {
				String[] ability;
				ability = new String[10];
				ability[0] = "Bladestorm";
				ability[1] = "Charge";
				ability[2] = "Cleave";
				ability[3] = "Flurry";
				ability[4] = "Furious Charge";
				ability[5] = "Rend";
				ability[6] = "Seeking Slash";
				ability[7] = "Seismic Slam";
				ability[8] = "Shield Bash";
				ability[9] = "Whirlwind";
				int num = (int) (Math.random() * 10);
				String attackAbility = ability[num];
				defense = new Random().nextInt(3) + 3;
				damage = new Random().nextInt(3) + 6;
				System.out.println();
				System.out.println(
						"You have used the ability " + attackAbility + " and " + damage + " damage has been dealt.");
				System.out.println();

			} else {
				System.out.printf("\nRandom Probability: %d", randomProbability());
				System.out.println("You missed!");
				System.out.println();
			}
			numOfnormalAttack += 1;

			// Block
			// If you choose to block, it will lower the chance of the
			// opponent's attack to land by 20%
		} else if (choice == 2) {
			defense = 0;
			damage = 0;

			if (randomProbability() <= actionProbability) {
				System.out.printf("\nRandom Probability: %d", randomProbability());
				System.out.println();
				System.out.print("You failed to block!\n");
				System.out.println();

			} else {
				System.out.printf("\nRandom Probability: %d", randomProbability());
				System.out.println("You successfully block.");
				System.out.print("");
				block = true;
			}

			// Special
			// A warrior can heal himself/herself by 10-15 points
		} else if (choice == 3 && numOfnormalAttack >= 5) {
			defense = 0;
			damage = 0;
			healPoints = new Random().nextInt(6) + 10;
			System.out.println();
			System.out.println("You heal yourself by " + healPoints + " points.");
			System.out.println();

		} else {
			System.out.println("INVALID INPUT: Please indicate a value in between 1 and 3.");
			getWarriorAction();
		}
	}

	public int randomProbability() {
		randomProbability = new Random().nextInt(10);
		return randomProbability;
	}

	public int getDamage() {
		return damage;
	}

	public int getDefense() {
		return defense;
	}

	public boolean getstateOfBlock() {
		return block;
	}

	public int getChoice() {
		return choice;
	}
	
	public int getHealPoints() {
		return healPoints;
	}
}
