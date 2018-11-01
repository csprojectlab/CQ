package dynamic;

public class MaximumSizeRectangleOfAll1s {

	public int maxSizeRectangle(int[][] m) {
		// We will solve this using the concept of bar charts.
		// and finding the maximum area from the bar chart.
		int[] k = new int[m[0].length];
		// Copy the first row in the array.
		for(int i = 0; i < k.length; i++)
			k[i] = m[0][i];
		stack.MaximumRectangularAreaInHistogram h = new stack.MaximumRectangularAreaInHistogram();
		int maxArea = h.maxArea(k);   // Initialize a variable.
		for(int i = 1; i < m.length; i++) {  // adding till i'th row.
			for(int j = 0; j < m[i].length; j++) {
				if(m[i][j] == 0)
					k[j] = 0;
				else
					k[j] += m[i][j];
			}
			maxArea = Math.max(maxArea, h.maxArea(k));
		}
		System.out.println("Maximum size rectangle of all 1's: " + maxArea);
		return maxArea;
		
	}
	
	public static void main(String[] args) {
		MaximumSizeRectangleOfAll1s m = new MaximumSizeRectangleOfAll1s();
		int[][] input = new int[][] {
			{1,0,0,1,1,1}, {1,0,1,1,0,1}, {0,1,1,1,1,1}, {0,0,1,1,1,1}
		};
		m.maxSizeRectangle(input);
	}
	
}
