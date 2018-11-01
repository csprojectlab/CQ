package backtracking;

public class RatInMazeWIthMultipleSteps {
	public int[][] output;
	public boolean isSafe(int x, int y, int size) {
		if (x < 0 || y < 0 || x >= size || y >= size)
			return false;
		return true;
	}

	public boolean blocked(int x, int y, int[][] m) {
		if (m[x][y] == 0)
			return true;
		return false;
	}

	public boolean findSolution(int x, int y, int[][] maze) {
		if (x == maze.length - 1 && y == maze.length - 1) {
			this.output[x][y] = 1;   // Start writing the output when we find the solution.
			return true;
		}
		for (int i = 1; i <= maze[x][y]; i++)
			if (this.isSafe(x + i, y, maze.length) && !this.blocked(x+i, y, maze) && this.findSolution(x + i, y, maze)) {
				this.output[x][y] = 1;  // This is written when the stack is dropping.
				return true;
			}
		for (int i = 1; i <= maze[x][y]; i++)
			if (this.isSafe(x, y + i, maze.length) && !this.blocked(x, y+i, maze) && this.findSolution(x, y + i, maze)) {
				this.output[x][y] = 1;
				return true;
			}
		this.output[x][y] = 0;
		return false; // Means it is blocked or no path found so far.
	}

	public static void main(String[] args) {
		int[][] maze = { { 2, 1, 0, 0 }, { 3, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 0, 0, 1 } };
		RatInMazeWIthMultipleSteps m = new RatInMazeWIthMultipleSteps();
		m.output = new int[maze.length][maze[0].length];
		System.out.println(m.findSolution(0, 0, maze));
		for(int i = 0; i < m.output.length; i++) {
			for(int j = 0; j < m.output[i].length; j++)
				System.out.print(m.output[i][j] + " ");
			System.out.println();
		}
	}

}
