package queue;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {

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
	
	public boolean isDelimiter(Pair p) {
		return (p.x == -1 && p.y == -1);
	}
	
	public int[][] distanceOfNearestCell(int[][] m) {
		int result[][] = new int[m.length][m[0].length];
		Queue<Pair> queue = new LinkedList<>();    //  Store the cells having one.
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++)
				if(m[i][j] == 1)
					queue.add(new Pair(i, j));   
		queue.add(new Pair(-1,-1));
		while(!queue.isEmpty()) {
			while(!this.isDelimiter(queue.peek())) {
				Pair p = queue.poll();    // Getting the current one.
				if(p.y + 1 < m[0].length && m[p.x][p.y + 1] == 0) {   // right side.
					result[p.x][p.y + 1] = 1 + result[p.x][p.y];
					m[p.x][p.y + 1] = 1;
					queue.add(new Pair(p.x, p.y + 1));
				}
				if(p.y - 1 >= 0 && m[p.x][p.y - 1] == 0) {  // left side.
					result[p.x][p.y - 1] = 1 + result[p.x][p.y];
					m[p.x][p.y - 1] = 1;
					queue.add(new Pair(p.x, p.y - 1));
				}
				if(p.x + 1 < m.length && m[p.x + 1][p.y] == 0) {   // down
					result[p.x + 1][p.y] = 1 + result[p.x][p.y];
					m[p.x + 1][p.y] = 1;
					queue.add(new Pair(p.x + 1, p.y));
				}
				if(p.x - 1 >= 0 && m[p.x - 1][p.y] == 0) {  // top
					result[p.x - 1][p.y] = 1 + result[p.x][p.y];
					m[p.x - 1][p.y] = 1;
					queue.add(new Pair(p.x - 1, p.y));
				}				
			}
			// Popping the delimiter.
			queue.poll();
			if(!queue.isEmpty()) {
				queue.add(new Pair(-1,-1));
			}
		}
		util.Util.printMatrix(result);
		return result;
	}
	
	public static void main(String[] args) {
		int[][] m = new int[][] {
			{0,0,0,1}, {0,0,1,1}, {0,1,1,0}
		};
		DistanceOfNearestCellHavingOne d = new DistanceOfNearestCellHavingOne();
		System.out.println("Given matrix: ");
		util.Util.printMatrix(m);
		d.distanceOfNearestCell(m);
	}
}
