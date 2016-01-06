package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {

		BlackJack d = new BlackJack();
		List<Card> shuffledDeck = d.CreateDeck();
		d.Play(shuffledDeck);
	}
	
	public List<Card> CreateDeck()

	{
		List<Card> deck = new ArrayList<>(52);
		String[] Rank = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
				"King", "Ace" };
		String[] Suit = { "Clubs", "Hearts", "Spades", "Diamonds" };
		for (String s : Suit) {
			int i = 2;
			for (String r : Rank) {
				if (r.equalsIgnoreCase("ace")) {
					deck.add(new Card(r, s, -1));
				} else
					deck.add(new Card(r, s, i));

				if (i >= 10) {
					i = 10;
				} else
					i++;

			}
		}
		Collections.sort(deck);
		Collections.shuffle(deck);
		return deck;
	}

	public void Play(List<Card> shuffledDeck) {

		boolean initial = true;
		int count = 0;

		Card face = shuffledDeck.get(3);
		Scanner scanner = new Scanner(System.in);
		Player player = new Player(false);
		Player dealer = new Player(true);

		System.out.println("Welcome to BlackJack");

		for (int i = 0; i < 4; i = i + 2) {
			if (initial) {
				System.out.println("The dealer deals you " + shuffledDeck.get(count));
				player.addCard(shuffledDeck.get(count));
				System.out.println("The dealer deals himself " + shuffledDeck.get(count + 1));
				dealer.addCard(shuffledDeck.get(count + 1));
				initial = false;
				count = i + 2;
			} else {
				System.out.println("The dealer deals you " + shuffledDeck.get(count));
				player.addCard(shuffledDeck.get(count));
				player.printHand();
				System.out.println("The dealer deals himself a face down card");
				dealer.addCard(shuffledDeck.get(count + 1));
				dealer.printHand();
				count = i + 2;
			}
		}
		if (player.isSplitable() == false) {
			count = playerHand(shuffledDeck, count, player);
			dealerHand(shuffledDeck, count, dealer);
			checkWin(player, dealer);

		} else if (player.isSplitable() == true) {
			System.out.println("Would you like to split? Y/N");
			String split = scanner.nextLine();
			if (split.equals("Y")) {
				Player split1 = new Player(false);
				Player split2 = new Player(false);
				split1.addCard(shuffledDeck.get(0));
				split2.addCard(shuffledDeck.get(2));
				count = playerHand(shuffledDeck, count, split1);
				count = playerHand(shuffledDeck, count, split2);
				dealerHand(shuffledDeck, count, dealer);
				checkWin(split1, dealer);
				checkWin(split2, dealer);
			} else {
				count = playerHand(shuffledDeck, count, player);
				dealerHand(shuffledDeck, count, dealer);
				checkWin(player, dealer);
			}

		}

	}

	public void checkWin(Player player, Player dealer) {
		if (player.getHighValue() <= 21) {
			player.setValue(player.getHighValue());
		}

		if (player.getValue() > 21) {
			System.out.println("Bust");
			return;
		}
		if (dealer.getValue() > 21) {
			System.out.println("Dealer bust, you win!");
			return;
		} else {
			if (dealer.getValue() > player.getValue()) {
				System.out.println("Dealer value: " + dealer.getValue() + " vs your value: " + player.getValue()
						+ ". Sorry, you lose!");
				return;
			} else if (dealer.getValue() == player.getValue()) {
				System.out.println("Dealer value: " + dealer.getValue() + " vs your value: " + player.getValue()
						+ ". It's a push.");
				return;
			} else if (dealer.getValue() < player.getValue()) {
				System.out.println(
						"Dealer value: " + dealer.getValue() + " vs your value: " + player.getValue() + ". You win!");
				return;
			}

		}

	}

	public void dealerHand(List<Card> shuffledDeck, int count, Player dealer) {
		
		System.out.println("The dealer reveals his face down card as " + shuffledDeck.get(3).toString());
		dealer.setIsFaceDown(false);
		dealer.printHand();
		if (dealer.getHighValue() == 17)
			if ((dealer.getHighValue() + shuffledDeck.get(count).getValue() > 21)) {
				dealer.setValue(dealer.getValue()+shuffledDeck.get(count).getValue());
				System.out.println("The dealer deals himself " + shuffledDeck.get(count));
				dealer.printHand();
				count++;
			} else {
				dealer.setValue(dealer.getHighValue()+shuffledDeck.get(count).getValue());
				System.out.println("The dealer deals himself " + shuffledDeck.get(count));
				dealer.printHand();
				count++;
			}
		while (dealer.getValue() < 17)

		{
			System.out.println("The dealer deals himself " + shuffledDeck.get(count));
			dealer.addCard(shuffledDeck.get(count));
			dealer.printHand();
			count++;
		}	
	}

	public int playerHand(List<Card> shuffledDeck, int count, Player player) {
		Scanner scanner = new Scanner(System.in);
		boolean stay = false;
		while (!stay)

		{
			System.out.println("Your hand is: ");
			player.printHand();
			System.out.println("Would you like to hit, double, or stand?");
			String choice = scanner.next();
			if (choice.equals("hit")) {
				System.out.println("The dealer deals you " + shuffledDeck.get(count));
				player.addCard(shuffledDeck.get(count));
				player.printHand();
				System.out.println(player.getValue());
				count++;
			} else if (choice.equals("double")) {
				System.out.println("The dealer deals you " + shuffledDeck.get(count));
				player.addCard(shuffledDeck.get(count));
				player.printHand();
				System.out.println(player.getValue());
				count++;
				stay = true;
			} else
				stay = true;
		}
		return count;
	}

}