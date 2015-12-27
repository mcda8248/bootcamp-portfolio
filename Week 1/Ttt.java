package TicTacToe;

import java.util.*;

public class Ttt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char board[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

		String p1String;
		char p1Symbol;
		char p2Symbol = 'Z';
		int rowchoice;
		int columnchoice;
		boolean win = false;
		int turn = 0;
		boolean choice = true;
		String stillPlaying;
		boolean error = false;

		System.out.println("Welcome to TIC TAC TOE!");
		printBoard(board);

		do {

			System.out.println("Player one, What symbol would you like to be? X or O? ");
			p1String = scanner.next();

			if (p1String.equalsIgnoreCase("x")) {
				p2Symbol = 'O';
			} else if (p1String.equalsIgnoreCase("o")) {
				p2Symbol = 'X';
			} else {
				System.out.println("You must choose X or O");
			}
			p1Symbol = p1String.charAt(0);
			System.out.println("Player one is " + p1Symbol + " and Player two is " + p2Symbol);
			reinitalizeBoard(board);

			do {
				System.out.println("Turn: " + turn);

				do {
					System.out.println("Player one, what is your choice for your x dimension? (1-3)");
					rowchoice = scanner.nextInt();

					System.out.println("Player one, what is your choice for your y dimension? (1-3)");
					columnchoice = scanner.nextInt();

					if ((columnchoice > 3 || columnchoice < 1) || (rowchoice > 3 || rowchoice < 1)) {
						error = true;
						
					} else if (board[rowchoice - 1][columnchoice - 1] == 'X'
							|| board[rowchoice - 1][columnchoice - 1] == 'O')
						error = true;

					else
						error = false;

					if (error == true)
						System.out.println(
								"Hey, dummy, either there's already something there or you typed in a bad number.");
				} while (error == true);

				board[rowchoice - 1][columnchoice - 1] = p1Symbol;
				printBoard(board);
				win = winCheck(board, p1Symbol, p2Symbol, turn);

				turn = turn + 1;

				// end do
				if (win == true)
					break;
				else {
					System.out.println("Turn: " + turn);
					do {
						System.out.println("Player two, what is your choice for your x dimension? (1-3)");
						rowchoice = scanner.nextInt();

						System.out.println("Player two, what is your choice for your y dimension? (1-3)");
						columnchoice = scanner.nextInt();

						if ((columnchoice > 3 || columnchoice < 1) || (rowchoice > 3 || rowchoice < 1)) {
							error = true;
							
						}
						if (board[rowchoice - 1][columnchoice - 1] == 'X'
								|| board[rowchoice - 1][columnchoice - 1] == 'O')
							error = true;

						else
							error = false;

						if (error == true)
							System.out.println(
									"Hey, dummy, either there's already something there or you typed in a bad number.");
					} while (error == true);

					board[rowchoice - 1][columnchoice - 1] = p2Symbol;
					printBoard(board);
					win = winCheck(board, p1Symbol, p2Symbol, turn);

					turn = turn + 1;

				}
			} // end do
			while (win == false);

			System.out.println("There is a winner!");
			if (turn % 2 == 0) {
				System.out.println("Congratulations Player 2! If you see this your opponent is bad.");
			} // end if
			else {
				System.out.println("You win! Of course.");
			} // end else

			System.out.println("Would you like to play again? Y or N.");
			stillPlaying = scanner.next();

			if (stillPlaying.equalsIgnoreCase("Y"))
				choice = true;

			else
				choice = false;

		} // end do
		while (choice);

	} // end main

	public static void printBoard(char[][] board) {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				System.out.print(board[column][row]);
			} // end for2
			System.out.println();
		} // end for
	} // end method

	public static void reinitalizeBoard(char[][] board) {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				board[row][column] = ' ';
			} // end for2

		} // end for
	} // end method

	public static boolean winCheck(char[][] board, char p1Symbol, char p2Symbol, int turn) {
		char sym2check;
		boolean win = false;
		int i, j;

		if (turn % 2 == 0) {
			sym2check = p1Symbol;
		} // end if else
		else {
			sym2check = p2Symbol;
		}
		// end else

		// Check win by a row
		for (i = 0; i < board.length && !win; i++) {
			for (j = 0; j < board[0].length; j++) {
				if (board[i][j] != sym2check)
					break;
			}
			if (j == board[0].length)
				win = true;
		}

		// Check win by a column
		for (j = 0; j < board[0].length && !win; j++) {
			for (i = 0; i < board.length; i++) {
				if (board[i][j] != sym2check)
					break;
			}
			if (i == board.length)
				win = true;
		}

		// Check win by a diagonal (1)
		if (!win) {
			for (i = 0; i < board.length; i++) {
				if (board[i][i] != sym2check)
					break;
			}
			if (i == board.length)
				win = true;
		}

		// Check win by a diagonal (2)
		if (!win) {
			for (i = 0; i < board.length; i++) {
				if (board[i][board.length - 1 - i] != sym2check)
					break;
			}
			if (i == board.length)
				win = true;
		}

		// Finally return win
		return win;
	}
}