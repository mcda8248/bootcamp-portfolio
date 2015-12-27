
public class Weapon {
	private int power;
	
	
	
	public Weapon(int power) {
		this.power = power;
	}



	public void equip(Player player) {
		player.setDamage(player.getDamage()+power);
	}
}



