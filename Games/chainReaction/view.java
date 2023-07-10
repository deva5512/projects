package PreparationQuestions.ChainReaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	static Scanner s = new Scanner(System.in);

	private Model model = new Model();

	public static void main(String[] args) {
		View view = new View();
		view.createBoard();
	}

	private void createBoard() {
		System.out.println("Enter the size of the board : ");
		int size = s.nextInt();
		System.out.println("Enter the number of players ");
		int num = s.nextInt();
		s.nextLine();
		List<String> names = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			System.out.print("Enter player " + (i + 1) + " name :");
			names.add(s.nextLine());
		}
		model.createBoard(size, names);
		startGame();
	}

	private void startGame() {
		boolean won = false;
		Player current = null;
		while (!won) {
			printBoard();
			current = model.getPlayer();
			boolean placed = false;
			while (!placed) {
				System.out.print(current.getPlayerName() + "'s turn enter the row & column :");
				String[] index = s.nextLine().split(" ");
				int r = Integer.parseInt(index[0]);
				int c = Integer.parseInt(index[1]);
				placed = model.isValidIndex(r, c, current.getPlayerid());
				if (placed) {
					model.placeMode(r, c, current.getPlayerid());
				} else {
					System.out.println("invalid index please enter again");
				}
			}
			won = model.isPlayerWon(current.getPlayerid());
		}
		System.out.println(current.getPlayerName() + " is the winner ");
	}

	private void printBoard() {
		int[][][] board = model.getBoard();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print("id:" + board[i][j][1] + " (" + board[i][j][0]+") | ");
			}
			System.out.println();
		}
	}

}
