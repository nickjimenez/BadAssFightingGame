import java.util.Random;

public class CpuWizard {
	private int actionProbability = 7;
	private int damage = 0;
	private int defense = 0;
	private boolean block = false;
	private boolean wizardAbility = false;
	private int randomProbability = 0;
	
	// If the CPU is a wizard
	public void getWizardAction() {
		System.out.println();
		System.out.println("===============");
		System.out.println("COMPUTER'S TURN");
		System.out.println("===============");
		System.out.println();
		Random randomChoice = new Random();
		int cpuChoice = randomChoice.nextInt(2);
		
		// Attack
		// A wizard can deal anywhere between 10-12 damage each attack phase, and has no mitigation (so defense is always 0)
		if (cpuChoice == 0) {
			if (randomProbability() <= actionProbability){
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
		        Random randomDamage = new Random();
		        damage = randomDamage.nextInt(3) + 10;
		        System.out.println("The CPU used the ability " + attackAbility + " and " + damage + " damage has been dealt.");
		        System.out.println();
			}else {
			    System.out.printf("\nRandom Probability: %d", randomProbability());
				damage = 0;
				System.out.println("The CPU missed!");
				System.out.println();
			}
		}
		else if (cpuChoice == 1) {
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
	
	public boolean getstateOfWizardAbility() {
		return wizardAbility;
	}
}
