package graph;
//Minimum initial vertices to traverse whole matrix with given conditions
//We are given a matrix that contains different values in its each cell. Our aim is to find the minimal set of positions in the matrix such that entire matrix can be traversed starting from the positions in the set.
//We can traverse the matrix under below conditions:
//
//We can move only to those neighbors that contain value less than or to equal to the current cell’s value. A neighbor of cell is defined as the cell that shares a side with the given cell.
//Examples:
//
//Input : 1 2 3
//        2 3 1
//        1 1 1
//Output : 1 1
//         0 2
//If we start from 1, 1 we can cover 6 
//vertices in the order 1, 1 -> 1, 0 -> 2, 0 
//-> 2, 1 -> 2, 2 -> 1, 2. We cannot cover
//the entire matrix with this vertex. Remaining 
//vertices can be covered 0, 2 -> 0, 1 -> 0, 0. 
//
//Input : 3 3
//        1 1
//Output : 0 1
//If we start from 0, 1, we can traverse 
//the entire matrix from this single vertex 
//in this order 0, 0 -> 0, 1 -> 1, 1 -> 1, 0. 
//Traversing the matrix in this order 
//satisfies all the conditions stated above. 

class Pair {
	int x, y;
	public Pair() {}
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "{" + this.x + "," + this.y + "}";
	}
}

public class TraverseMatrixWithGivenCondition {
	
	public static Pair findMaxIndex(int[][] matrix) {
		int max = Integer.MIN_VALUE;
		Pair p = new Pair();
		for(int i = 0; i < matrix.length; i++) 
			for(int j = 0; j < matrix[i].length; j++) 
				if(matrix[i][j] > max) {
					max = matrix[i][j];
					p.x = i;
					p.y = j;
				}
		return p;
	}
	
	public static boolean allVisited(boolean[][] matrix) {
		for(int i = 0; i < matrix.length; i++) 
			for(int j = 0; j < matrix[i].length; j++)
				if(!matrix[i][j])
					return false;
		return true;
	}
	
	public static boolean dfsTraverse(Pair cell, boolean[][] isVisited, int[][] matrix) {
		isVisited[cell.x][cell.y] = true;  // Keeping this statement here is very crucial.
		if(allVisited(isVisited)) 
			return true;
		int value = matrix[cell.x][cell.y];
		if(cell.x - 1 >= 0 && value >= matrix[cell.x-1][cell.y] && !isVisited[cell.x-1][cell.y] &&
		   dfsTraverse(new Pair(cell.x - 1, cell.y), isVisited, matrix))  // One step up. 
			return true;
		if(cell.x + 1 < matrix.length && value >= matrix[cell.x+1][cell.y] && !isVisited[cell.x+1][cell.y] &&
		   dfsTraverse(new Pair(cell.x + 1, cell.y), isVisited, matrix))  // One step down.
			return true;
		if(cell.y - 1 >= 0 && value >= matrix[cell.x][cell.y-1] && !isVisited[cell.x][cell.y-1] &&
		   dfsTraverse(new Pair(cell.x, cell.y-1), isVisited, matrix))  // One step left.
			 return true;
		if(cell.y + 1 < matrix[cell.x].length && value >= matrix[cell.x][cell.y+1] && !isVisited[cell.x][cell.y+1] &&
		   dfsTraverse(new Pair(cell.x, cell.y+1), isVisited, matrix))  // One step right.
			 return true;	
		isVisited[cell.x][cell.y] = false;
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{3,3},
				{1,1}
//				{1,2}
		};
		boolean isVisited[][] = new boolean[matrix.length][matrix[0].length];
		// Finding the minimum coordinate from where we can traverse the whole matrix.
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				if(dfsTraverse(new Pair(row,col), isVisited, matrix)) {
					System.out.println("You can start from: (" + row + "," + col + ")" );
					break;
				}
			}
		}
	}

}
