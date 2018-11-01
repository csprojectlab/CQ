package graphadjacency;

//Given a rectangular matrix, we can move from current cell in 4 directions with equal probability.
//The 4 directions are right, left, top or bottom. Calculate the Probability that after N moves from a 
//given position (i, j) in the matrix, we will not cross boundaries of the matrix at any point.

public class MatrixProbability {

	public MatrixProbability() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isSafe(int x, int y, int m, int n) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	public static double findProbabilityDFS(int x, int y, int m, int n, int steps) {
		if(!isSafe(x, y, m, n))
			return 0;
		if(steps == 0)
			return 1.0;
		double p = 0.0;
		p += findProbabilityDFS(x, y-1, m, n, steps-1)*0.25;
		p += findProbabilityDFS(x, y+1, m, n, steps-1)*0.25;
		p += findProbabilityDFS(x-1, y, m, n, steps-1)*0.25;
		p += findProbabilityDFS(x+1, y, m, n, steps-1)*0.25;
		return p;
	}
	
	public static void main(String[] args) {
		int m = 5;
		int n = 5;
		int steps = 2;
		int x = 1;
		int y = 1;
		System.out.println("Probability: " + findProbabilityDFS(x, y, m, n, steps));
	}

}
