//Name: Corey Everett
//Date: January 30th, 2018
//Program: Tic Tac Toe
//Purpose: To play a game of Tic Tac Toe.

import java.util.Scanner;
public class Lab3TicTacToeSpring2018 {
	
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Welcome to Tic Tac Toe! Input column and row to try and get three in a row!");
		
		char[][] board; board = new char[][]{{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};printBoard(board);

		for (int i = 1; i <=9; i++) {
			if (i%2 == 0) {turn(board,'O');}
			else {turn(board, 'X');}
			printBoard(board);
		}
		System.out.print("Tie! Try again."); System.exit(0);
	}

	public static char[][] turn(char[][] board, char character) {
		// This method does a turn - character variable allows same method for each player.
		// Gets row value and error-checks
		System.out.print(character + "'s turn! Input row (1-3): "); int row = input.nextInt(); if (row > 3 || row < 1) {System.out.print("Invalid row! Try again.");board = turn(board, character);}
		// Gets column value and error-checks
		System.out.print("Input column (1-3): "); int column = input.nextInt(); if (column > 3 || column < 1) {System.out.print("Invalid column! Try again.");board = turn(board, character);}
		// Makes sure space is empty
		if (board[row-1][column-1] == ' ') {board[row-1][column-1] = character;}
		else {System.out.print("Space already occupied! Try again."); board = turn(board, character);}
		// These three lines of code check for victory - either in row, column, or diagonally
		for(int i = 0; i<=2; i++) {if ( board[i][0] == character && board[i][1] == character && board[i][2] == character) {System.out.println(character+" wins!");printBoard(board);System.exit(0);}	}
		for(int i = 0; i<=2; i++) {if ( board[0][i] == character && board[1][i] == character && board[2][i] == character) {System.out.println(character+" wins!");printBoard(board);System.exit(0);}	}
		if ((board[0][0] == character && board[1][1] == character && board[2][2] == character) || (board[0][2] == character && board[1][1] == character && board[2][0] == character)) {System.out.println(character+" wins!");printBoard(board);System.exit(0);	}
		return board;
	}
	
	// This method prints the board.
	public static void printBoard(char[][]board) { 
		System.out.println(" | " + board[0][0] + " | " +board[0][1] + " | " + board[0][2] + " | \n | " + board[1][0] + " | " +board[1][1] + " | " + board[1][2] + " | \n | " + board[2][0] + " | " +board[2][1] + " | " + board[2][2] + " | ");
	}
}
