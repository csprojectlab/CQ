package backtracking;

public class PrintAllPathsFromTopLeftToBottomRight {

	public void print(int[] path) {
		for(int i = 0; i < path.length; i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}
	
	public void printAllPaths(int[][] matrix) {
		int[] path = new int[matrix.length + matrix[0].length - 1];
		this.printAllPaths(0, 0, path, matrix, 0);
	}
	
	public void printAllPaths(int x, int y, int[] path, int[][] matrix, int index) {
		if(x == matrix.length - 1 && y == matrix[x].length - 1) {
			path[index] = matrix[x][y];
			this.print(path);
			return;
		}
		path[index] = matrix[x][y];  // this value need no to be over-written.
		if(x + 1 <= matrix.length - 1) 
			this.printAllPaths(x+1, y, path, matrix, index+1);
		if(y + 1 <= matrix[x].length - 1) 
			this.printAllPaths(x, y+1, path, matrix, index+1);
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3}, {4,5,6}	
		};
		PrintAllPathsFromTopLeftToBottomRight p = new PrintAllPathsFromTopLeftToBottomRight();
		p.printAllPaths(matrix);
	}
}
