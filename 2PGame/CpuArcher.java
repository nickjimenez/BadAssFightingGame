import java.util.Random;

public class CpuArcher {
	private int actionProbability = 7;
	private int damage = 0;
	private int defense = 0;
	private boolean block = false;
	private boolean archerAbility = false;
	private int randomProbability = 0;
	
	// If the CPU is an archer
	public void getArcherAction() {
		System.out.println();
		System.out.println("===============");
		System.out.println("COMPUTER'S TURN");
		System.out.println("===============");
		System.out.println();
		Random randomChoice = new Random();
		int cpuChoice = randomChoice.nextInt(2);
		
		// Attack
		// An archer can deal anywhere between 8-10 damage each attack phase
		if (cpuChoice == 0) {
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
			    System.out.println("The CPU used the ability " + attackAbility + " and " + damage + " damage has been dealt.");
		            System.out.println();
		    }
		    else {
			    System.out.printf("\nRandom Probability: %d", randomProbability());
			    damage = 0;
		         	System.out.println("The CPU missed!");
				System.out.println();
			}
		
		// Block
		// An archer mitigates 1-3 incoming damage
		}	else if (cpuChoice == 1) {
			defense = 0;
			damage = 0;
			
			if (randomProbability() <= actionProbability) {
				System.out.printf("\nRandom Probability: %d", randomProbability());
				System.out.println();
				System.out.print("CPU failed to block!\n");
				System.out.println();
			} else {
				System.out.printf("\nRandom Probability: %d", randomProbability());
				System.out.println("CPU successfully block.");
				System.out.print("");
				block = true;
			}
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
	
	public boolean getstateOfArcherAbility() {
		return archerAbility;
	}
	
}
