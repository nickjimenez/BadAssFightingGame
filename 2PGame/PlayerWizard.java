import java.util.Random;
import java.util.Scanner;

public class PlayerWizard {
	private int actionProbability = 7;
	private int damage = 0;
	private int defense = 0;
	private int choice = 0;
	private int randomProbability = 0;
	private boolean block = false;
	private boolean wizardAbility = false;
	private int numOfnormalAttack = 0;

	// If the player is a wizard
	public void getWizardAction() {
		Scanner wizardInput = new Scanner(System.in);
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
		int choice = wizardInput.nextInt();

		// Attack
		// A wizard can deal anywhere between 10-12 damage each attack phase,
		// and mitigates 0 incoming damage
		if (choice == 1) {

			if (randomProbability() <= actionProbability) {
				String[] ability;
				ability = new String[10];
				ability[0] = "Arcane Barrage";
				ability[1] = "Blizzard";
				ability[2] = "Chaos Bolt";
				ability[3] = "Comet Storm";
				ability[4] = "Fireball";
				ability[5] = "Magic Missle";
				ability[6] = "Ray of Frost";
				ability[7] = "Scorch";
				ability[8] = "Shocking Grasp";
				ability[9] = "Vampiric Touch";
				int num = (int) (Math.random() * 10);
				String attackAbility = ability[num];
				defense = 0;
				damage = new Random().nextInt(3) + 10;
				System.out.println();
				System.out.println(
						"You have used the ability " + attackAbility + " and " + damage + " damage has been dealt.");
				System.out.println();

			} else {
				System.out.printf("\nRandom Probability: %d", randomProbability());
				System.out.print("You missed!\n");
				System.out.print("");
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
			// A wizard can make the opponent miss their next turn
		} else if (choice == 3 && numOfnormalAttack >= 5) {
			defense = 0;
			damage = 0;
			wizardAbility = true;
			System.out.println();
			System.out.println("You have used your special ability, and your opponent wil miss his/her next turn.");
			System.out.println();

		} else {
			System.out.println("INVALID INPUT: Please indicate a value in between 1 and 3.");
			getWizardAction();
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
	
	public boolean getstateOfWizardAbility() {
		return wizardAbility;
	}
}
