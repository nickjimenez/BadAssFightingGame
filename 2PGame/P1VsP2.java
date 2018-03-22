import java.util.Random;

public class P1VsP2 extends Game {
	private int p1Health = 0;
	private int p2Health = 0;
	private static int defaultP1Health = 100;
	private static int defaultP2Health = 100;
	
	public P1VsP2() {
		this(defaultP1Health, defaultP2Health);
	}

	public P1VsP2(int valueOfP1Health, int valueOfP2Health) {
		setP1Health(valueOfP1Health);
		setP2Health(valueOfP2Health);
	}

	public void setP1Health(int valueOfP1Health) {
		p1Health = valueOfP1Health;
	}

	public void setP2Health(int valueOfP2Health) {
		p2Health = valueOfP2Health;
	}

	// Dealing with block and wizards abilities' effects on the p1's damage.
	public void checkBlockAndWizardAbilityOfP2(Player p2, Player p1) {
		if (p2.getstateOfBlock()) {
			p1.setDamage(0);
			p2.changestateOfBlock();
		}

		if (p2.getstateOfWizardAbility()) {
			System.out.println("Because of the player 2's ability, the player 1 missed!!! ");
			p1.setDamage(0);
			p2.changestateOfWizardAbility();
		}
	}

	// Dealing with archers' abilities' effects on the p1's damage.
	public void checkArcherAbilityOfP1(Player p1) {
		if (p1.getstateOfArcherAbility()) {
			p1.setDamage(p1.getDamage() + (new Random().nextInt(3) + 1));
			System.out.println("Because of the poison arrow, the player 1 totally cause the player 2" + p1.getDamage()
					+ "damage.");
		}
	}

	// Dealing with block and wizards abilities' effects on the p2's damage.
	public void checkBlockAndWizardAbilityOfP1(Player p2, Player p1) {
		if (p1.getstateOfBlock()) {
			p2.setDamage(0);
			p1.changestateOfBlock();
		}

		if (p1.getstateOfWizardAbility()) {
			System.out.println("Because of the player 1's ability, the player 2 missed!!! ");
			p2.setDamage(0);
			p1.changestateOfWizardAbility();
		}
	}

	// Dealing with archers' abilities' effects on the p2's damage.
	public void checkArcherAbilityOfP2(Player p2) {
		if (p2.getstateOfArcherAbility()) {
			p2.setDamage(p2.getDamage() + (new Random().nextInt(3) + 1));
			System.out.println("Because of the poison arrow, the player 2 totally cause the player 1" + p2.getDamage()
					+ "damage.");
		}
	}

	// Calculation the cpu'health and the player's health.
	public void p1AndP2healthCalculation(Player p1, Player p2) {
		if (p1.getDefense() >= p2.getDamage()) {
			p1Health = p1Health;
		} else {
			p1Health = (p1Health - p2.getDamage() + p1.getDefense() + p1.getHealPoints());
		}
		if (p2.getDefense() >= p1.getDamage()) {
			p2Health = p2Health;
		} else {
			p2Health = (p2Health - p1.getDamage() + p2.getDefense());
		}
	}

	public void PlayerVsPlayer() {
		boolean noResult = true;
		Player p1 = new Player();
		Player p2 = new Player();

		System.out.println("-----------------------");
		System.out.println("Player 1's character:");
		p1.setCharacter();
		System.out.println("-----------------------");
		System.out.println("Player 2's character:");
		p2.setCharacter();

		if (flipCoinResult() == "Tails") {
			System.out.print("Player 1's health:" + p1Health);
			System.out.println("    Player 2's health:" + p2Health);
			System.out.println("Player 2's turn first!");
			System.out.println("");
			System.out.println("-----------------------");
			System.out.println("Now is player 2's turn.");
			p2.getAction();
			System.out.println("-----------------------");
			p2Health = (p2Health - p1.getDamage() + p2.getDefense());
		} else {
			System.out.println("Player 1's turn first!");
			System.out.println("");
		}

		while (noResult) {
			System.out.print("Player 1's health:" + p1Health);
			System.out.println("    Player 2's health:" + p2Health);
			System.out.println("-----------------------");
			System.out.println("Turn" + numOfTurn());
			System.out.println("Now is player 1's turn.");
			System.out.println("-----------------------");
			p1.getAction();
			checkBlockAndWizardAbilityOfP2(p2, p1);
			checkArcherAbilityOfP1(p1);

			System.out.println("-----------------------");
			System.out.println("Now is player 2's turn.");
			p2.getAction();
			checkBlockAndWizardAbilityOfP1(p2, p1);
			checkArcherAbilityOfP2(p2);
			System.out.println("-----------------------");
			p1AndP2healthCalculation(p1, p2);

			if (p2Health <= 0 && p1Health > 0) {
				noResult = false;
				System.out.println();
				System.out.println("Player 1 WIN");
			} else if (p2Health > 0 && p1Health <= 0) {
				noResult = false;
				System.out.println();
				System.out.println("Player 2 WIN");
			} else if (p2Health <= 0 && p1Health <= 0) {
				noResult = false;
				System.out.println();
				System.out.println("Player 1 WIN");
			} else {
				noResult = true;
			}
		}
	}
}