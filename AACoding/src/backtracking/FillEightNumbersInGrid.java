package backtracking;

//Place the numbers 1, 2, 3, 4, 5, 6, 7, 8 into the eight circles in the figure given below, in such a way that no number is 
//adjacent to a number that is next to it in the sequence. For example, 1 should not be adjacent to 2 but can be adjacent 
//to 3, 4, 5, 6, 7, 8. Similarly for others.

public class FillEightNumbersInGrid {
	public static final int BLOCKED = 0;
	public static final int UNASSIGNED = -1;
	public int count = 0;
	
	public boolean isSafe(int x, int y, int num, int[][] grid) {
		// Eight directions.
		if(x - 1 >= 0) {
			if(grid[x-1][y] != BLOCKED && (grid[x-1][y] == num - 1 || grid[x-1][y] == num + 1))  // Top.
				return false;
			if(y - 1 >= 0 && grid[x-1][y-1] != BLOCKED && (grid[x-1][y-1] == num - 1 || grid[x-1][y-1] == num + 1))
				return false;    // top left.
			if(y + 1 <= grid[x].length - 1 && grid[x-1][y+1] != BLOCKED && (grid[x-1][y+1] == num - 1 || grid[x-1][y+1] == num + 1))
				return false;   // top right.
		}
		if(y - 1 >= 0 && grid[x][y-1] != BLOCKED && (grid[x][y-1] == num - 1 || grid[x][y-1] == num + 1))
			return false;    // left.
		if(y + 1 <= grid[x].length - 1 && grid[x][y+1] != BLOCKED && (grid[x][y+1] == num - 1 || grid[x][y+1] == num + 1))
			return false;
		if(x + 1 <= grid.length - 1) {  
			if(grid[x+1][y] != BLOCKED && (grid[x+1][y] == num - 1 || grid[x+1][y] == num + 1))  // bottom
				return false;
			if(y - 1 >= 0 && grid[x+1][y-1] != BLOCKED && (grid[x+1][y-1] == num - 1 || grid[x+1][y-1] == num + 1))
				return false;   // bottom left.
			if(y + 1 <= grid[x].length - 1 && grid[x+1][y+1] != BLOCKED && (grid[x+1][y+1] == num - 1 || grid[x+1][y+1] == num + 1))
				return false;  // bottom right.			
		}		
		return true;
	}
	
	public void print(int[][] grid) {
		System.out.println("Solution " + this.count + ":");
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public void fillNumbers(int[][] grid) {
		int limit = grid.length * grid[0].length - 4;
		boolean[] used = new boolean[limit+1];   // 0 position is not used.
		this.fillNumbers(grid, 0, 0, used, limit);
	}
	
	public void fillNumbers(int[][] grid, int x, int y, boolean[] used, int limit) {
		if(x == grid.length) {
			this.count++;
			this.print(grid);
		} else if(y == grid[x].length) {
			this.fillNumbers(grid, x+1, 0, used, limit);
		} else if(grid[x][y] == BLOCKED) {
			this.fillNumbers(grid, x, y+1, used, limit);
		} else {
			for(int i = 1; i <= limit; i++) {
				if(!used[i] && this.isSafe(x, y, i, grid)) {  // if i'th number is not used.
					used[i] = true;
					grid[x][y] = i;
					this.fillNumbers(grid, x, y+1, used, limit);
					used[i] = false;
					grid[x][y] = UNASSIGNED;   // This is necessary as we are using isSafe function.
				}
			}
		}
	}
	
	public static void main(String[] args) {
		FillEightNumbersInGrid f = new FillEightNumbersInGrid();
		@SuppressWarnings("unused")
		int[][] grid = { { 0, -1, -1, -1, 0 },
                { -1, -1, -1, -1 , -1},
                { 0, -1, -1, -1, 0 } };
		int[][] g = { { 0, -1, -1, 0 },
                { -1, -1, -1, -1 },
                { 0, -1, -1, 0 } };
		f.fillNumbers(g);
	}
}
