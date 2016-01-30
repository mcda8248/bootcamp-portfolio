package data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class LoadDeckDAO {
	private List<Card> deck = new ArrayList<>();
	@Autowired
	private LoadCardsDAO LoadCardsDAO;

	@PostConstruct
	public void init() {

	}

	public void addCard(String n) {
		boolean add = false;
		String check = "Legendary";
		Card c = null;
		List<Card> toCheck = new ArrayList<>();
		toCheck = LoadCardsDAO.getCardList("all");
		for (Card iter : toCheck) {
			if (iter.getName().equals(n))
				c = iter;
		}
		if (deck.size() != 30) {
			int count = 0;
			for (Card d : deck) {
				if (d.equals(c)) {

					if (c.getRarity().equals(check)) {
						break;
					} else if (count == 2) {
						break;
					} else {
						count++;
						add = true;

					}
				} else {
					add = true;
				}
			}
		}
		else {
			add= true;
		}
		if (add) {
			deck.add(c);
		}
	}

	public List<Card> getDeck() {
		return deck;
	}

	public List<Card> deleteCard(String n) {
		int remove = -1;
		for (int i = 0; i < deck.size(); i++) {
			if (deck.get(i).getName().equals(n)) {
				remove = i;
			}
		}
		deck.remove(remove);
		return deck;
	}
}
