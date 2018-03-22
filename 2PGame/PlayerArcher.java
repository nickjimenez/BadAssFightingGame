import java.util.Random;
import java.util.Scanner;

public class PlayerArcher {
	private int actionProbability = 7;
	private int damage = 0;
	private int defense = 0;
	private int choice = 0;
	private int randomProbability = 0;
	private boolean block = false;
	private boolean archerAbility = false;
	private int numOfnormalAttack = 0;
	
	// If the player is an archer
	public void getArcherAction() {
		Scanner archerInput = new Scanner(System.in);
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
		choice = archerInput.nextInt();
		
		// Attack
		// An archer can deal anywhere between 8-10 damage each attack phase, and mitigates 1-3 incoming damage
		if (choice == 1) {
			if (randomProbability() <= actionProbability) {
				System.out.printf("\nRandom Probability: %d", randomProbability());
				String[] ability;
				ability = new String[10];
				ability[0] = "Blazing Arrow";
				ability[1] = "Deadly Shot";
				ability[2] = "Orion's Bolt";
				ability[3] = "Murder of Crows";
				ability[4] = "Ranger's Net";
				ability[5] = "Serpent Sting";
				ability[6] = "Serrated Arrow";
				ability[7] = "Volley";
				ability[8] = "Wing Strike";
				ability[9] = "Quick Shot";
				int num = (int) (Math.random() * 10);
				String attackAbility = ability[num];
				defense = new Random().nextInt(3) + 1;
				damage = new Random().nextInt(3) + 8;
				System.out.println();
				System.out.println("You have used the ability " + attackAbility + " and " + damage + " damage has been dealt.");
				System.out.println();
				
			} else {
				System.out.printf("\nRandom Probability: %d", randomProbability());
				damage = 0;
				System.out.println("You missed!");
				System.out.println();
			}
		numOfnormalAttack += 1;

		// Block
		// If you choose to block, it will lower the chance of the opponent's attack to land by 20%
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
		// An archer can apply a poison arrow that does 1-3 points of damage each turn
		} else if (choice == 3 && numOfnormalAttack >= 5) {
			defense = 0;
			damage = 0;
			archerAbility = true;
			System.out.println();
			System.out.println("You have used a poison arrow and it will cause 1-3 points of damage each turn until the end of the game.");
			System.out.println();

		} else {
			System.out.println("INVALID INPUT: Please indicate a value in between 1 and 3.");
			getArcherAction();
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
	
	public boolean getstateOfArcherAbility() {
		return archerAbility;
	}
	
}
