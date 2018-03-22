import java.util.Random;

public class CpuVsP1 extends Game {
	private int cpuHealth = 0;
	private int p1Health = 0;
	private static int defaultCpuHealth = 100;
	private static int defaultP1Health = 100;
	
	public CpuVsP1() {
		this(defaultP1Health, defaultCpuHealth);
	}

	public CpuVsP1(int valueOfP1Health, int valueOfCpuHealth) {
		setP1Health(valueOfP1Health);
		setCpuHealth(valueOfCpuHealth);
	}

	public void setP1Health(int valueOfP1Health) {
		p1Health = valueOfP1Health;
	}

	public void setCpuHealth(int valueOfCpuHealth) {
		cpuHealth = valueOfCpuHealth;
	}

	// Dealing with block and wizards' abilities' effects on the player's
	// damage.
	public void checkBlockAndWizardAbilityOfCpu(Cpu cpu, Player p1) {
		if (cpu.getstateOfBlock()) {
			p1.setDamage(0);
			cpu.changestateOfBlock();
		}

		if (cpu.getstateOfWizardAbility()) {
			System.out.println("Because of the cpu's wizard ability, you missed!!! ");
			p1.setDamage(0);
			cpu.changestateOfWizardAbility();
		}

	}

	// Dealing with archers' abilities' effects' on the cpu's damage.
	public void checkArcherAbilityOfCpu(Cpu cpu) {
		if (cpu.getstateOfArcherAbility()) {
			cpu.setDamage(cpu.getDamage() + (new Random().nextInt(3) + 1));
			System.out.println("Because of the poison arrow, the cpu totally cause you" + cpu.getDamage() + "damage.");
		}
	}

	// Dealing with block and wizards' abilities' effects on the cpu's
	// damage.
	public void checkBlockAndWizardAbilityOfPlayer(Cpu cpu, Player p1) {
		if (p1.getstateOfBlock()) {
			cpu.setDamage(0);
			p1.changestateOfBlock();
		}

		if (p1.getstateOfWizardAbility()) {
			System.out.println("Because of the player's ability, the cpu missed!!! ");
			cpu.setDamage(0);
			p1.changestateOfWizardAbility();
		}
	}

	// Dealing with archers' abilities' effects' on the player's damage.
	public void checkArcherAbilityOfPlayer(Player p1) {
		if (p1.getstateOfArcherAbility()) {
			p1.setDamage(p1.getDamage() + (new Random().nextInt(3) + 1));
			System.out.println("Because of the poison arrow, you totally cause the cpu" + p1.getDamage() + "damage.");
		}

	}

	// Calculation the cpu'health and the player's health.
	public void cpuAndP1healthCalculation(Cpu cpu, Player p1) {
		if (p1.getDefense() >= cpu.getDamage()) {
			p1Health = p1Health;
		} else {
			p1Health = (p1Health - cpu.getDamage() + p1.getDefense() + p1.getHealPoints());
		}
		if (cpu.getDefense() >= p1.getDamage()) {
			cpuHealth = cpuHealth;
		} else {
			cpuHealth = (cpuHealth - p1.getDamage() + cpu.getDefense());
		}
	}

	public void PlayerVsCpu() {
		boolean noResult = true;
		Cpu cpu = new Cpu();
		Player p1 = new Player();

		System.out.println("-----------------------");
		System.out.println("Computer's character:");
		cpu.setCharacter();
		System.out.println("-----------------------");
		System.out.println("Player's character:");
		p1.setCharacter();

		if (flipCoinResult() == "Tails") {
			System.out.println("----------------------------------------");
			System.out.print("Your health:" + p1Health);
			System.out.println("    Computer's health:" + cpuHealth);
			System.out.println("----------------------------------------");
			System.out.println("CPU's turn first!");
			System.out.println("");
			cpu.getAction();
			p1Health = (p1Health - cpu.getDamage() + p1.getDefense());
		} else {
			System.out.println("Your turn first!");
			System.out.println("");
		}

		while (noResult) {
			System.out.println("----------------------------------------");
			System.out.print("Your health:" + p1Health);
			System.out.println("    Computer's health:" + cpuHealth);
			System.out.println("----------------------------------------");
			System.out.println("Turn" + numOfTurn());
			System.out.println("----------------------------------------");
			System.out.println("Now is player's turn.");
			p1.getAction();
			checkBlockAndWizardAbilityOfCpu(cpu, p1);
			checkArcherAbilityOfPlayer(p1);

			cpu.getAction();
			checkBlockAndWizardAbilityOfPlayer(cpu, p1);
			checkArcherAbilityOfCpu(cpu);
			cpuAndP1healthCalculation(cpu, p1);

			if (cpuHealth <= 0 && p1Health > 0) {
				noResult = false;
				System.out.println();
				System.out.println("YOU WIN");
			} else if (cpuHealth > 0 && p1Health <= 0) {
				noResult = false;
				System.out.println();
				System.out.println("YOU LOSE");
			} else if (cpuHealth <= 0 && p1Health <= 0) {
				noResult = false;
				System.out.println();
				System.out.println("YOU WIN");
			} else {
				noResult = true;
			}
		}
	}
}
