package com.ray.algorithm;

import java.util.Random;
import java.util.Scanner;

class TicTacT {
	public static final int X = 1, O = -1;
	public static final int EMPTY = 0;

	public int player = X;
	private int[][] board = new int[3][3];
	public boolean isEmpty = false;

	public void putSign(int x, int y) {
		/*if (x < 0 || x > 2 || y < 0 || y > 2) {
			System.out.println("Invalid board position");
			return;
		}
		if(n<1&&n>9) {
			System.out.println("Invalid board position");
			return;
		}*/
			
				if (board[x][y] != EMPTY) {
			System.out.println("Board position occupied");
			return;
		}
		board[x][y] = player;
		player = -player;
	}

	public boolean isWin(int player) {
		return ((board[0][0] + board[0][1] + board[0][2] == player * 3)
				|| (board[1][0] + board[1][1] + board[1][2] == player * 3)
				|| (board[2][0] + board[2][1] + board[2][2] == player * 3)
				|| (board[0][0] + board[1][0] + board[2][0] == player * 3)
				|| (board[0][1] + board[1][1] + board[2][1] == player * 3)
				|| (board[0][2] + board[1][2] + board[2][2] == player * 3)
				|| (board[0][0] + board[1][1] + board[2][2] == player * 3)
				|| (board[2][0] + board[1][1] + board[0][2] == player * 3));
	}

	public void displayWinner() {
		if (isWin(X)) {
			System.out.println("\n X wins...!!");
			isEmpty = false;
		} else if (isWin(O)) {
			System.out.println("\n Computer wins...!!");
			isEmpty = false;
		} else {
			if (!isEmpty) {
				System.out.println("its a tie");
			}

		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		isEmpty = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				switch (board[i][j]) {
				case X:
					s.append(" X ");
					break;
				case O:
					s.append(" O ");
					break;
				case EMPTY:
					s.append("   ");
					isEmpty = true;
					break;
				}
				if (j < 2) {
					s.append("|");
				}

			}
			if (i < 2) {
				s.append("\n-----------\n");
			}
		}
		return s.toString();
	}
}


public class TicTac {
	
	static int computer() {
		Random ob = new Random();
		int i = ob.nextInt(((10 - 1) + 1) + 1);
		return i;
	}

	static int[] position(int n) {
		int x, y;
		int[] arr = new int[2];
		if(n>0&&n<10) {
			
		if (n == 1) {
			arr[0] = 0;
			arr[1] = 0;
		}
		if (n == 2) {
			arr[0] = 0;
			arr[1] = 1;
		}
		if (n == 3) {
			arr[0] = 0;
			arr[1] = 2;
		}
		if (n == 4) {
			arr[0] = 1;
			arr[1] = 0;
		}
		if (n == 5) {
			arr[0] = 1;
			arr[1] = 1;
		}
		if (n == 6) {
			arr[0] = 1;
			arr[1] = 2;
		}
		if (n == 7) {
			arr[0] = 2;
			arr[1] = 0;
		}
		if (n == 8) {
			arr[0] = 2;
			arr[1] = 1;
		}
		if (n == 9) {
			arr[0] = 2;
			arr[1] = 2;
		}
		
		}
		else {
			System.out.println("Invalid board position");
			System.exit(0);
		}
		return arr;
		
	}

	public static void main(String[] args) throws InterruptedException {

		TicTacT t = new TicTacT();
		Scanner s = new Scanner(System.in);
		int x = 0, y = 0, n = 0;
		int[] arr;
		do {
			if (t.player == t.X) {
				System.out.println("Player X turn");
				System.out.println("Enter postion value::");
				n = s.nextInt();
				arr = position(n);
				x = arr[0];
				y = arr[1];
			} else {
				Thread.sleep(1000);
				System.out.println("Computer played its turn");
				n=computer();
				arr = position(n);
				x = arr[0];
				y = arr[1];

			}
			t.putSign(x, y);
			System.out.println(t.toString());
			System.out.println("_____________________________");
			t.displayWinner();

		} while (t.isEmpty);
	}
}

