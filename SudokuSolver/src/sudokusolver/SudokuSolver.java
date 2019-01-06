package sudokusolver;

public class SudokuSolver 
{
	private final int N = 9;
	int board[][];
	
	public SudokuSolver(int [][] board)
	{
		this.board = board;
	}
	
	public boolean isSpotTaken(int spot)
	{
		return spot > 0 ? true : false;
	}
	
	public boolean isSubsectionConflict(
			int spot, int[][] board, 
			int curr_row, int curr_col, 
			int start_row, int start_col, 
			int end_row, int end_col)
	{
		int i, j;
		for (i = start_row; i < end_row; i++)
		{
			for (j = start_col; j < end_col; j++)
			{
				if (board[i][j] == spot && i != curr_row && j != curr_col)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isConflict(int[][] board, int curr_row, int curr_col, int val)
	{
		int spot = val;
		int i, j;
		int sqrt, start_row, start_col, end_row, end_col;
		
		// Rows and columns check.
		for (i = 0; i < getN(); i++)
		{	
			// Check each value in the i'th row, and same column.
			if (board[i][curr_col] == spot && i != curr_row)
			{
				return true;
			}
		}
		
		for (j = 0; j < getN(); j++)
		{	
			// Check each value in the same row, and j'th column.
			if (board[curr_row][j] == spot && j != curr_col)
			{
				return true;
			}
		}
		
		sqrt = (int) Math.sqrt(getN());
		start_row = curr_row - (curr_row % sqrt);
		start_col = curr_col - (curr_col % sqrt);
		end_row = start_row + sqrt;
		end_col = start_col + sqrt;
		
		if (isSubsectionConflict(spot, board, curr_row, curr_col, start_row, start_col, end_row, end_col))
		{
			return true;
		}
	
		return false;	
	}
	
	public int solveBoard(int[][] board, int n)
	{
		int i, j, row = -1, col = -1;
		boolean is_filled = true;
			
		// Find the next available box on the board.
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < n; j++)
			{
				if (!isSpotTaken(board[i][j]))
				{
					row = i; 
					col = j;
					
					is_filled = false;
					break;
				}
			}
			if (!is_filled)
			{
				break;
			}
		}
		// If this returns 1, then we have filled the board with our solution.
		if (is_filled)
		{
			return 1;
		}
		
		// Otherwise, try to place a value in the available box.
		for (i = 1; i <= n; i++)
		{
			if (!isConflict(board, row, col, i))
			{
				board[row][col] = i;
				
				if (solveBoard(board, n) == 1)
				{
					return 1;
				}
				else
				{
					board[row][col] = 0;
				}
			}
		}
		
		return 0;
	}

	public void printBoard(int[][] board)
	{
		int i, j; 
		
		for (i = 0; i < board.length; i++)
		{
			for (j = 0; j < board.length; j++)
			{
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println("\n");
		}
	}

	public int getN() 
	{
		return N;
	}
}








