import java.util.*;

public class GameShell {
	public static void main(String[] args) {

		GameShell g = new GameShell();
		g.game();
	}

	public void game() {
		boolean easy = false;
		boolean normal = false;
		boolean hard = false;
		int battleswon = 0;
		Enemy enemy = new Enemy(25, 5);
		Player player = new Player(100, 10);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Press 1 for Easy, 2 for Normal, 3 for Hardcore.");
		int diff = scanner.nextInt();

		if (diff == 3) {
			hard = true;
			player = new Player(50, 5);
		} else if (diff == 2) {
			normal = true;
			player = new Player(100, 10);
		} else {
			easy = true;
			player = new Player(150, 15);

		}
		Map floor1 = new Map();
		floor1.printMap();
		for (int i = 0; i < 3; i++) {
			int b = battle(player, enemy, battleswon);
			if (b >= 0) {
				enemy = new Enemy(25, 5);
				battleswon = b;
			} else if (b == -1) {
				battleswon = b;
				break;
			}

		}

		if (battleswon == 3) {
			System.out.println("You win");
		} else if (battleswon == -1) {
			System.out.println("You lose");
		}

	}

	public int battle(Player player, Enemy enemy, int b) {
		Scanner scanner = new Scanner(System.in);
		int battleswon = b;

		for (int i = 0; i < 100; i++) {
			System.out.println("Press any key to fight.");
			scanner.nextLine();
			int damageDone = enemy.takeDamage(player.getDamage());
			System.out
					.println("You do " + damageDone + " damage to the orc, leaving him with " + enemy.getHP() + " HP.");
			int damageTaken = player.takeDamage(enemy.getDamage());
			System.out.println(
					"The orc does " + damageTaken + " damage to you, leaving you with " + player.getHP() + " HP.");
			if (enemy.getIsDead() == true && player.getIsDead() == true) {
				System.out.println("You hack the orc's head off with your last breath, then expire. Game Over.");
				battleswon = -1;
				break;
			} else if (player.getIsDead()) {
				System.out.println("The orc kills you. Game Over.");
				battleswon = -1;
				break;
			} else if (enemy.getIsDead()) {
				System.out.println("You kill the orc and move on.");
				battleswon++;
				loot(player, (int) (Math.random() * 100));
				break;
			}
		}

		return battleswon;
	}

	public void loot(Player player, int roll) {
		if (roll > 99) {
			Weapon loot = new Weapon(15);
			System.out.println("You found the Legendary Sword!");
			loot.equip(player);
		} else if (roll == 98) {
			Armor loot = new Armor(15);
			System.out.println("You found the Legendary Suit of Armor!");
			loot.equip(player);
		} else if (roll < 98 && roll > 85) {
			Weapon loot = new Weapon(10);
			System.out.println("You found a mithril sword!");
			loot.equip(player);
		} else if (roll < 86 && roll > 70) {
			Armor loot = new Armor(10);
			System.out.println("You found mithril armor!");
			loot.equip(player);
		} else if (roll < 71 && roll > 60) {
			Weapon loot = new Weapon(5);
			System.out.println("You found a steel sword!");
			loot.equip(player);
		} else if (roll < 61 && roll > 49) {
			Armor loot = new Armor(5);
			System.out.println("You found steel armor!");
			loot.equip(player);

		}
	}
}
