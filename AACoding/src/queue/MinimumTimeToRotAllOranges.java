package queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 0 means no orange there.
 * 1 means fresh orange.
 * 2 means rotten orange.
 * Find the minimum time to rot all the oranges.
 */
public class MinimumTimeToRotAllOranges {

	class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return "{" + this.x + "," + this.y + "}";
		}
	}
	
	public boolean isDelimeter(Pair p) {
		return (p.x == -1 && p.y == -1);
	}
	
	public int timeToRot(int[][] matrix) {
		Queue<Pair> queue = new LinkedList<>();  // This will store all the rotten oranges.
		for(int i = 0; i < matrix.length; i++) 
			for(int j = 0; j < matrix[i].length; j++) 
				if(matrix[i][j] == 2)
					queue.add(new Pair(i, j));  // Indexes of rotten.
		// Adding a delimiter.
		queue.add(new Pair(-1,-1));	
		System.out.println("Initial rotten oranges: " + queue);
		int time = 0;
		while(!queue.isEmpty()) {
			boolean flag = false;     // Flags the start of a new frame only once.
			while(!this.isDelimeter(queue.peek())) {
				Pair p = queue.poll();
				// Looking right.
				if(p.y + 1 < matrix[0].length && matrix[p.x][p.y+1] == 1) {
					matrix[p.x][p.y+1] = 2;  // rot the orange.
					if(!flag) { time++;  flag = !flag;}
					queue.add(new Pair(p.x, p.y+1));
				}
				if(p.y - 1 >= 0 && matrix[p.x][p.y-1] == 1) {   // left
					matrix[p.x][p.y-1] = 2;
					if(!flag) { time++;  flag = !flag;}
					queue.add(new Pair(p.x, p.y-1));
				}
				if(p.x + 1 < matrix.length && matrix[p.x+1][p.y] == 1) {
					matrix[p.x+1][p.y] = 2;
					if(!flag) { time++;  flag = !flag;}
					queue.add(new Pair(p.x+1, p.y));
				}
				if(p.x - 1 >= 0 && matrix[p.x-1][p.y] == 1) {
					matrix[p.x-1][p.y] = 2;
					if(!flag) { time++;  flag = !flag;}
					queue.add(new Pair(p.x-1, p.y));
				}
			}
			queue.poll();   // Deque the delimiter
			System.out.println("New Rotten: " + queue);
			if(!queue.isEmpty())  // if queue is not empty. Means some rotten are left.
				queue.add(new Pair(-1,-1));
		}
		System.out.println("Time required to rot all oranges: " + time);
		return -1;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{2,1,0,2,1}, {1,0,1,2,1}, {1,0,0,2,1}
		};
		MinimumTimeToRotAllOranges m = new MinimumTimeToRotAllOranges();
		m.timeToRot(matrix);
	}
	
}
