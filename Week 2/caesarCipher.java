package OO;

import java.util.*;

public class caesarCipher {
	public static void main(String[] args) {

		boolean encrypt = true;
		Scanner scanner = new Scanner(System.in);
		String word;
		int shift;

		System.out.println("Would you like to decrypt? Y for decrypt, N for encrypt.");
		String option = scanner.next();
		char selection = option.charAt(0);

		switch (selection) {
		case 'Y':
			encrypt = false;
			break;
		case 'N':
			encrypt = true;
			break;
		default:
			System.out.println("Invalid selection");
			break;
		} // switch statement to determine if user is encrypting or decrypting

		System.out.println("Please enter the word in question.");
		scanner.nextLine();
		word = scanner.nextLine();

		System.out.println("Please enter the amount to shift.");
		shift = scanner.nextInt();

		char[] wordToCrypt = new char[word.length()];

		for (int i = 0; i < wordToCrypt.length; i++) {
			wordToCrypt[i] = word.charAt(i);
		} // creating array of chars holding inputted word

		if (encrypt == true) {
			char[] wordToEncrypt = new char[wordToCrypt.length];

			for (int i = 0; i < wordToCrypt.length; i++) {
				if ((int) wordToCrypt[i] >= 65 && (int) wordToCrypt[i] <= 91) {
					wordToEncrypt[i] = upperCaseCrypt(wordToCrypt[i], shift, encrypt); //if char is upper, send to upper method
				} else if ((int) wordToCrypt[i] >= 97 && (int) wordToCrypt[i] <= 122) {
					wordToEncrypt[i] = lowerCaseCrypt(wordToCrypt[i], shift, encrypt); //if char is lower, send to lower method
				} else if ((int) wordToCrypt[i] == 46 || (int) wordToCrypt[i] == 44 || (int) wordToCrypt[i] == 63) {
					wordToEncrypt[i] = punctCrypt(wordToCrypt[i], shift, encrypt);		//if char is punct, send to punct method
				} else if ((int) wordToCrypt[i] == 32) {
					wordToEncrypt[i] = ' '; // if entry is space, preserve space
				} 
			}

			for (int i = 0; i < wordToEncrypt.length; i++) {
				System.out.print(wordToEncrypt[i]); // print encrypted word
			}
		} else if (encrypt == false) {
			char[] wordToDecrypt = new char[wordToCrypt.length];

			for (int i = 0; i < wordToCrypt.length; i++) {
				if (((int) wordToCrypt[i]) >= 65 && ((int) wordToCrypt[i]) <= 91) {
					wordToDecrypt[i] = upperCaseCrypt(wordToCrypt[i], shift, encrypt); //if char is upper, send to upper method
				} else if (((int) wordToCrypt[i]) >= 97 && ((int) wordToCrypt[i]) <= 122) {
					wordToDecrypt[i] = lowerCaseCrypt(wordToCrypt[i], shift, encrypt); //if char is lower, send to lower method
				} else if ((int) wordToCrypt[i] == 46 || (int) wordToCrypt[i] == 44 || (int) wordToCrypt[i] == 63) {
					wordToDecrypt[i] = punctCrypt(wordToCrypt[i], shift, encrypt);		//if char is punct, send to punct method
				} else if ((int) wordToCrypt[i] == 32) {
					wordToDecrypt[i] = ' '; // if entry is space, preserve space
				} 
			}

			for (int i = 0; i < wordToDecrypt.length; i++) {
				System.out.print(wordToDecrypt[i]);

			}
		}
	}

	public static char upperCaseCrypt(char upper, int shift, boolean encrypt) {

		int check = 0;
		if (encrypt) {
			check = upper + shift;
		} else {
			check = upper - shift; // if we are encrypting, shift number to
									// right, else shift left
		}
		char giveback;

		if (check > 90) { // if shifted character is outside bounds of uppercase
							// letters, wrap around
			giveback = (char) (check - 26);
		} else if (check < 65) {
			giveback = (char) (check + 26);
		} else {
			giveback = (char) check;
		}
		return giveback;
	}

	public static char lowerCaseCrypt(char lower, int shift, boolean encrypt) {

		int check = 0;
		if (encrypt) {
			check = lower + shift;
		} else {
			check = lower - shift; //if we are encrypting, shift alphabet right, else left
		}
		char giveback;

		if (check > 122) {
			giveback = (char) (check - 26);
		} else if (check < 97) {
			giveback = (char) (check + 26);
		} else {
			giveback = (char) check;  //if shifted character is now outside bounds, wrap around
		}
		return giveback;

	}

	public static char punctCrypt(char punct, int shift, boolean encrypt) {

		int position = 0;
		char[] punc = { '.', ',', '?' };
		for (int i = 0; i < punc.length; i++) {
			if (punct == punc[i]) {
				position = i;
			}									//define array of punct marks to compare to then
		}										//get position of punct mark passed in
		int check = 0;
		if (encrypt) {
			check = position + (shift % (punc.length));
		} else {
			check = position - (shift % (punc.length));
		}										//if encrypting, shift right along array, else shift left
		char giveback;

		if (check > 2) {
			giveback = punc[check - punc.length];
		} else if (check < 0) {
			giveback = punc[check + punc.length];
		} else
			giveback = punc[check];				//be sure output wraps around punc[] array bounds

		return giveback;

	}
}