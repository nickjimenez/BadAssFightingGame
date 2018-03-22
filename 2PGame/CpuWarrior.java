import java.util.Random;

public class CpuWarrior {
	private int actionProbability = 7;
	private int damage = 0;
	private int defense = 0;
	private boolean block = false;
	private int randomProbability = 0;
	
	// If the CPU is a warrior
		public void getWarriorAction() {
			System.out.println();
			System.out.println("===============");
			System.out.println("COMPUTER'S TURN");
			System.out.println("===============");
			System.out.println();
			Random randomChoice = new Random();
			int cpuChoice = randomChoice.nextInt(2);
			
			// Attack
			// A warrior can deal anywhere between 6-8 damage each attack phase
			if (cpuChoice == 0) {
				if (randomProbability() <= actionProbability){
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
			         System.out.println("The CPU used the ability " + attackAbility + " and " + damage + " damage has been dealt.");
			         System.out.println();
				}else {
				    System.out.printf("\nRandom Probability: %d", randomProbability());
					damage = 0;
					System.out.println("The CPU missed!");
					System.out.println();
				}
			}
			
			// Block
			// A warrior mitigates 3-5 incoming damage
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
		
}
