package sudokusolver;

public class Main {

	public static void main(String[] args) 
	{
		int[][] board = new int[][]
			{
				{9, 0, 8, 2, 4, 0, 0, 0, 0},
				{6, 0, 0, 9, 0, 8, 0, 0, 0},
				{0, 7, 0, 0, 0, 0, 0, 0, 0},
				{3, 0, 0, 0, 0, 6, 0, 0, 7},
				{0, 0, 4, 7, 0, 0, 0, 9, 0},
				{0, 1, 9, 0, 0, 0, 0, 0, 2},
				{0, 0, 0, 4, 0, 9, 0, 8, 0},
				{0, 0, 0, 6, 7, 0, 0, 0, 0},
				{0, 9, 0, 0, 1, 2, 0, 0, 0},
			};
		SudokuSolver s = new SudokuSolver(board);

		if (s.solveBoard(s.board, s.getN()) == 1)
		{
			s.printBoard(s.board);
		}
		else
		{
			System.out.println("No solution.");
			s.printBoard(s.board);
			
		}
	}

}
