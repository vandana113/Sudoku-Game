import java.util.ArrayList;
import java.util.Collections;

public class Grid {
	int[][] solution;
	int[][] game;
	int[][] check;
	int selectedNumber;

	Grid() {
		game = new int[9][9];
		// check = new int[9][9];
		newGame();

	}

	public void newGame() {
		solution = new int[9][9];
		generateSolution(solution, 0);
		int[][] game1 = copy(solution);
		game = generateGame(game1);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(game[i][j] + " ");
			}
			System.out.println("(" + i + ")");
			System.out.println();
		}

	}

	public void setSelectedNo(int number) {
		selectedNumber = number;
	}

	public int getSelectedNumber() {
		return selectedNumber;
	}

	public void setNumber(int x, int y, int number) {
		game[x][y] = number;
	}

	public int getNumber(int x, int y) {
		return game[x][y];
	}

	private boolean generateSolution(int game[][], int index) {
		if (index > 80)
			return true;
		ArrayList<Integer> numbers = new ArrayList<>();
		int x = index / 9;
		int y = index % 9;
		for (int i = 1; i <= 9; i++)
			numbers.add(i);
		Collections.shuffle(numbers);
		while (numbers.size() > 0) {
			int number = nextPossible(game, numbers, x, y);
			if (number == -1)
				return false;
			game[x][y] = number;
			if (generateSolution(game, index + 1))
				return true;
			game[x][y] = 0;
		}

		return false;
	}

	private int nextPossible(int solution[][], ArrayList<Integer> numbers, int x, int y) {
		while (numbers.size() > 0) {
			int num = numbers.remove(0);
			int flag = 0;
			for (int i = 0; i < 9; i++) {
				if (num == solution[x][i]) {
					flag = 1;
					break;
				}
			}
			if (flag == 1)
				continue;
			flag = 0;
			for (int i = 0; i < 9; i++)
				if (solution[i][y] == num) {
					flag = 1;
					break;
				}
			if (flag == 1)
				continue;
			flag = 0;
			int end_i = 3 * (x / 3 + 1);
			int start_i = end_i - 3;
			int end_j = 3 * (y / 3 + 1);
			int start_j = end_j - 3;
			for (int i = start_i; i < end_i; i++)
				for (int j = start_j; j < end_j; j++)
					if (solution[i][j] == num) {
						flag = 1;
						break;
					}
			if (flag == 1)
				continue;
			return num;
		}
		return -1;
	}

	private int[][] generateGame(int[][] game) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for (int i = 0; i < 81; i++)
			positions.add(i);
		Collections.shuffle(positions);
		return generateGame(game, positions);
	}

	private int[][] generateGame(int[][] game, ArrayList<Integer> positions) {
		while (positions.size() > 0) {
			int position = positions.remove(0);
			int x = position % 9;
			int y = position / 9;
			int temp = game[y][x];
			game[y][x] = 0;

			if (!isValid(copy(game)))
				game[y][x] = temp;
		}

		return game;
	}

	private boolean isValid(int[][] game) {
		return isValid(game, 0, new int[1]);
	}

	private boolean isValid(int[][] game, int index, int[] numberOfSolutions) {
		if (index > 80) {
			numberOfSolutions[0] += 1;
			if (numberOfSolutions[0] > 1)
				return false;
			else
				return true;
		}

		int x = index % 9;
		int y = index / 9;

		if (game[y][x] == 0) {
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			for (int i = 1; i <= 9; i++)
				numbers.add(i);

			while (numbers.size() > 0) {
				int number = nextPossible(game, numbers, y, x);
				if (number == -1)
					return true;
				game[y][x] = number;

				if (!isValid(game, index + 1, numberOfSolutions)) {
					game[y][x] = 0;
					return false;
				}
				game[y][x] = 0;
			}
		} else if (!isValid(game, index + 1, numberOfSolutions))
			return false;

		return true;
	}

	private int[][] copy(int arr[][]) {
		int[][] copyarr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				copyarr[i][j] = arr[i][j];
			}
		}
		return copyarr;
	}

}
