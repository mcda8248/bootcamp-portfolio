
public class Player {
	private int HP;
	private int damage;
	private boolean isDead = false;
	private int armor=0;

	public Player(int HP, int damage) {
		this.HP = HP;
		this.damage = damage;
	}

	public int takeDamage(int d) {
		int damagedone = (int) (d + ((Math.random() * (5 - 1) + 1)));
		HP = HP - (damagedone-armor);
		return damagedone;
	}

	public int getHP() {
		return HP;
	}

	public boolean getIsDead() {
		if (HP < 1) {
			isDead = true;

		}
		return isDead;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setArmor(int a) {
		this.armor = a;
	}
}
