package backtracking;

public class NQueens {
	public int size = 8;
	public int[] board;
	int numberOfSolutions = 0;
	
	public NQueens() {
		this(8);
	}
	public NQueens(int size) {
		this.size = size;
		this.board = new int[this.size];
		for(int i = 0; i < this.size; i++)
			this.board[i] = -1;
	}
	
	// K is row and i is column.
	public boolean canPlace(int k, int i, int[] arr) {
		 for (int j = 0; j <= k - 1; j++){
		        if (arr[j] == i || 
		            (Math.abs(arr[j] - i) == Math.abs(j - k)))
		           return false;
		    }
		    return true;
	}
	
	public void search(int row, int[] board) {
		if(row == board.length) {
		/*	for(int i = 0; i < board.length; i++)    // Uncomment to print the board
				System.out.println(board[i]);
			System.out.println();*/
			this.numberOfSolutions++;
			return;
		}
		for(int i = 0; i < size; i++) {  // for each column.
			board[row] = i;  // place the queen.
			if(canPlace(row, i, board)) {
				search(row+1,  board);
			}
			board[row] = -1;
		}		
	}
	
	public static void main(String[] args) {
		NQueens q = new NQueens();
		q.search(0, q.board);
		System.out.println("Solutions: " + q.numberOfSolutions);
		
	}

}
