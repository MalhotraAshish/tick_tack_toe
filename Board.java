package tick_tack_toe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Board {
	int boardSize;
	char board[][];
	Scanner input;
	Queue<Player> turn;

	public Board(int boardSize, Player[] players) {
		this.boardSize = boardSize;
		this.board = new char[2 * boardSize - 1][2 * boardSize - 1];
		initilazeBoard(board);
		turn = new LinkedList<>();
		turn.add(players[0]);
		turn.add(players[1]);
		input = new Scanner(System.in);
	}

	private void initilazeBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i % 2 == 0 && j % 2 != 0) {
					board[i][j] = '|';
				} else if (i % 2 != 0 && j % 2 == 0) {
					board[i][j] = '-';
				} else if (i % 2 != 0 && j % 2 != 0) {
					board[i][j] = '+';
				}
			}
		}
	}

	public void startGame() {
		int count = 0;
		while (true) {
			printBoard();
			count++;
			if (count == ((boardSize * boardSize) + 1)) {
				System.out.println("Match Draw");
				break;
			}
			Player p = turn.poll();
			int position = getUserInput(p);
			int row = 2 * ((position % boardSize == 0) ? (position / boardSize) - 1 : position / boardSize);
			int col = 2 * ((position % boardSize == 0 ? boardSize : position % boardSize) - 1);
			board[row][col] = p.getSymbol();
			if (count >= boardSize && checkWinner(p, row, col)) {
				break;
			}
			turn.offer(p);
		}
	}

	private boolean checkWinner(Player p, int row, int col) {
		String winString = "";
		for (int i = 0; i < boardSize; i++) {
			winString += String.valueOf(p.getSymbol());
		}
		String rowString = "";
		String colString = "";
		String diagonalString = "";
		String reverseDiagonalString = "";
		for (int i = 0; i < board.length; i = i + 2) {
			rowString += board[row][i];
			colString += board[i][col];
			if (row == col) {
				diagonalString += board[i][i];
			}
			if ((row + col) == board.length - 1) {
				reverseDiagonalString += board[board.length - 1 - i][i];
			}
		}
		if (winString.equals(rowString) || winString.equals(colString) || winString.equals(diagonalString)
				|| winString.equals(reverseDiagonalString)) {
			printBoard();
			System.out.println(p.getName() + " Has won the game");
			return true;
		}
		return false;
	}

	private int getUserInput(Player p) {

		System.out.println(p.getName() + " please enter a number from 1 - " + boardSize * boardSize);
		int val = input.nextInt();
		while (!validInput(val)) {
			System.out.println(
					"Wrong Position: " + p.getName() + " please enter a number from 1 - " + boardSize * boardSize);
			val = input.nextInt();
		}
		return val;
	}

	private void printBoard() {
		for (char[] row : board) {
			for (char col : row) {
				System.out.print(col);
			}
			System.out.println("");
		}

	}

	private boolean validInput(int val) {
		if (val < 1 || val > (boardSize * boardSize)) {
			return false;
		}
		int row = 2 * ((val % boardSize == 0) ? (val / boardSize) - 1 : val / boardSize);
		int col = 2 * ((val % boardSize == 0 ? boardSize : val % boardSize) - 1);
		if ((int) board[row][col] != 0) {
			System.out.println("Input already exist");
			return false;
		}
		return true;
	}

}
