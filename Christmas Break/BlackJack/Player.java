package examples;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int value = 0;
	private int highValue = 0;
	private int numDealt = 0;
	private boolean isFaceDown;
	List<Card> dealt = new ArrayList<>();

	public Player(boolean f) {
		if (!f) {
			isFaceDown = false;
		}
		else 
			isFaceDown = true;
	}
	public void addCard(Card c) {
		dealt.add(c);
		if (c.getValue() == -1) {
			if ((highValue + 11) >= 21) {
				highValue = value + 11;
				value = value + 1;
			} else {
				highValue = highValue + 11;
				value = value + 1;
			}
		} else {
			highValue = highValue + (c.getValue());
			value = value + (c.getValue());
		}
	}

	public void printHand() {
		int size = dealt.size();
		for (int i = 0; i < size; i++) {
			if (isFaceDown == true && i == 1) {
				System.out.println("_____");
		    	System.out.println("|XXX|");
		    	System.out.println("|XXX|");
		    	System.out.println("|XXX|");
		    	System.out.println("-----");
			} else 
			dealt.get(i).printCard();
		}
	}

	public int getValue() {
		return value;
	}

	public int getHighValue() {
		return highValue;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setHighValue(int highValue) {
		this.highValue = highValue;
	}
	
	public void setIsFaceDown(boolean f) {
		this.isFaceDown = f;
	}

	public boolean isSplitable() {
		if (dealt.get(0).getRank().equals(dealt.get(1).getRank())) {
			return true;
		} else
			return false;
	}
}
