package examples;

public class Card implements Comparable<Card>{
    private String rank;
    private String suit;
    private int value;
    private String abbr;
    private String rankAbbr;

    public Card(String r, String s, int v) {
        rank = r;
        suit = s;
        value = v;
        
        switch (rank) {
        case "Two":
        	abbr = "2";
        	break;
        case "Three":
        	abbr = "3";
        	break;
        case "Four":
        	abbr = "4";
        	break;
        case "Five":
        	abbr = "5";
        	break;
        case "Six":
        	abbr = "6";
        	break;
        case "Seven":
        	abbr = "7";
        	break;
        case "Eight":
        	abbr = "8";
        	break;
        case "Nine":
        	abbr = "9";
        	break;
        case "Ten":
        	abbr = "10";
        	break;
        case "Jack":
        	abbr = "J";
        	break;
        case "Queen":
        	abbr = "Q";
        	break;
        case "King":
        	abbr = "K";
        	break;
        case "Ace":
        	abbr = "A";
        	break;
        default:
        	abbr = "?";
        	break;
        }
        
        switch (suit) {
        case "Clubs":
        	rankAbbr = "C";
        	break;
        case "Spades":
        	rankAbbr = "S";
        	break;
        case "Hearts":
        	rankAbbr = "H";
        	break;
        case "Diamonds":
        	rankAbbr = "D";
        	break;
        default:
        	rankAbbr = "?";
        	break;
        }
        
    }

    @Override
    public String toString() {
        return (rank + " of " + suit).toLowerCase();
    }


    public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (rank != other.rank)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }
    @Override
    public int compareTo(Card other) {
    	int rank = this.rank.compareTo(other.rank);
    	int suit = this.suit.compareTo(other.suit);
    	
    	if (rank == 0)
    			return suit;
    	else 
    		return rank;
    	
    }
    
    public void printCard() {
    	System.out.println("_____");
    	System.out.println("|"+abbr+"  |");
    	System.out.println("| " + rankAbbr+ " |");
    	System.out.println("|  "+abbr+"|");
    	System.out.println("-----");
    }
    	
}
