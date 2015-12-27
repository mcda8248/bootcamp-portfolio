
public class Armor {
	private int armor;
	
	public Armor(int armor) {
		this.armor = armor;
	}
	
	public void equip(Player player) {
		player.setArmor(armor);
}
}
