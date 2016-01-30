package data;
import java.util.ArrayList;
import java.util.List;

public class Card {
	private int cost;
	private String name ;
	private String user;
	private String type;
	private String rarity;
	private int dust;
	private int atk;
	private int hp;
	private String img;
	

	public Card(int c, String n, String u, String t, String r,
			int d, int a, int h, String i) {
		this.cost = c;
		this.name = n;
		this.user = u;
		this.type = t;
		this.rarity = r;
		this.dust = d;
		this.atk = a;
		this.hp = h;
		this.img = i;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRarity() {
		return rarity;
	}


	public void setRarity(String rarity) {
		this.rarity = rarity;
	}


	public int getDust() {
		return dust;
	}


	public void setDust(int dust) {
		this.dust = dust;
	}


	public int getAtk() {
		return atk;
	}


	public void setAtk(int atk) {
		this.atk = atk;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		if (img != null)	
		this.img = img;
		else
		this.img = "404.png";
	}
}