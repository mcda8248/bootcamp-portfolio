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
		int dealerValue = 0;
		int highDealerValue = 22;
		int highPlayerValue = 22;
		int playerValue = 0;
		boolean stay = false;
		Card face = shuffledDeck.get(3);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to BlackJack");

		for (int i = 0; i < 4; i = i + 2) {
			if (initial) {
				System.out.println("The dealer deals you " + shuffledDeck.get(count));
				shuffledDeck.get(count).printCard();
				if ((shuffledDeck.get(count)).getValue() == -1) {
					highPlayerValue = playerValue + 11;
					playerValue = playerValue + 1;
				} else {
					playerValue = playerValue + (shuffledDeck.get(count)).getValue();
				}
				System.out.println(playerValue);
				System.out.println("The dealer deals himself " + shuffledDeck.get(count + 1));
				if ((shuffledDeck.get(count + 1)).getValue() == -1) {
					highDealerValue = dealerValue + 11;
					dealerValue = dealerValue + 1;
				} else {
					dealerValue = dealerValue + (shuffledDeck.get(count + 1)).getValue();
				}
				System.out.println(dealerValue);
				initial = false;
				count = i + 2;
			} else {
				System.out.println("The dealer deals you " + shuffledDeck.get(count));
				if ((shuffledDeck.get(count)).getValue() == -1) {
					highPlayerValue = playerValue + 11;
					playerValue = playerValue + 1;
				} else {
					playerValue = playerValue + (shuffledDeck.get(count)).getValue();
				}
				System.out.println(playerValue);
				System.out.println("The dealer deals himself a face down card");
				if ((shuffledDeck.get(count + 1)).getValue() == -1) {
					highDealerValue = dealerValue + 11;
					dealerValue = dealerValue + 1;
				} else {
					dealerValue = dealerValue + (shuffledDeck.get(count + 1)).getValue();
				}
				System.out.println(dealerValue);
				count = i + 2;
			}
		}
		while (!stay) {
			System.out.println("Would you like to hit or stand?");
			String choice = scanner.next();
			if (choice.equals("hit")) {
				System.out.println("The dealer deals you " + shuffledDeck.get(count));
				if ((shuffledDeck.get(count)).getValue() == -1) {
					highPlayerValue = playerValue + 11;
					playerValue = playerValue + 1;
				} else {
					playerValue = playerValue + (shuffledDeck.get(count)).getValue();
				}
				System.out.println(playerValue);
				count++;
			} else {
				stay = true;
			}
		}
		if (highDealerValue <= 21) {
			dealerValue = highDealerValue;
		}

		if (highPlayerValue <= 21) {
			playerValue = highPlayerValue;
		}

		if (playerValue > 21) {
			System.out.println("Bust");
			return;
		} else
			System.out.println("The dealer reveals his face down card as " + face.toString());

		while (dealerValue < 17) {
			System.out.println("The dealer deals himself " + shuffledDeck.get(count));
			if ((shuffledDeck.get(count)).getValue() == -1) {
				highDealerValue = dealerValue + 11;
				dealerValue = dealerValue + 1;
			} else {
				dealerValue = dealerValue + (shuffledDeck.get(count)).getValue();
			}
			System.out.println(dealerValue);
			count++;
		}
		
		if (dealerValue > 21) {
			System.out.println("Dealer bust, you win!");
			return;
		} else {
			if (dealerValue > playerValue) {
				System.out.println("Dealer value: " + dealerValue + " vs your value: " + playerValue + ". Sorry, you lose!");
				return;
			} else if (dealerValue == playerValue) {
				System.out.println("Dealer value: " + dealerValue + " vs your value: " + playerValue + ". It's a push.");
				return;
			} else if (dealerValue < playerValue) {
				System.out.println("Dealer value: " + dealerValue + " vs your value: " + playerValue + ". You win!");
				return;
			}
			
			
		}

	}
	
}