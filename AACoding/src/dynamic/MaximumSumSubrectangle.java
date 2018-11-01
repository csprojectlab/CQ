package dynamic;



public class MaximumSumSubrectangle {
	
	class Pair {
		int top;
		int bottom;
		int sum;
	}

	public void reset(int[] k) {
		for(int i = 0; i < k.length; i++)
			k[i] = 0;
	}
	
	public Pair maxContiguousSubArray(int[] k) {
		int top = 0;
		int bottom = 0;
		int sum = Integer.MIN_VALUE;
		int currentSum = 0;
		for(int i = 0; i < k.length; i++) {
			currentSum += k[i];
			if(currentSum < 0)
				currentSum = 0;
			if(currentSum > sum) {
				sum = currentSum;
				bottom = i;
			}
		}
		currentSum = sum;
		int i = bottom;
		while(currentSum != 0) {
			top = i;
			currentSum -= k[i--];
		}
		Pair p = new Pair();
		p.top = top;
		p.bottom = bottom;
		p.sum = sum;
		return p;
	}
	
	public void maxSubRectangle(int[][] matrix) {
		int[] k = new int[matrix.length];
		int maxLeft = -1;
		int maxRight = -1;
		int maxTop = -1;
		int maxBottom = -1;
		int maxSum = Integer.MIN_VALUE;
		for(int left = 0; left < matrix[0].length; left++) {
			// Fill the k.
			for(int i = 0; i < k.length; i++)
				k[i] = matrix[i][left];
			for(int right = left; right < matrix[0].length; right++) {
				if(left != right)
					for(int i = 0; i < k.length; i++)
						k[i] += matrix[i][right];
				Pair p = this.maxContiguousSubArray(k);
				if(p.sum > maxSum) {
					maxSum = p.sum;
					maxLeft = left;
					maxRight = right;
					maxTop = p.top;
					maxBottom = p.bottom;
				}
			}
		}
		System.out.println("MaxLeft: " + maxLeft + " MaxRight: " + maxRight + " maxTop: " + maxTop + " maxBotoom: " + maxBottom);
		System.out.println("Maximum Sum is: " + maxSum);
	}
	
	public static void main(String[] args) {
		MaximumSumSubrectangle s = new MaximumSumSubrectangle();
		int[] arr = new int[] {2,4,-3,-4,5};
		Pair p = s.maxContiguousSubArray(arr);
		System.out.println(p.sum + " " + p.top + " " + p.bottom);
		
		int[][] matrix = new int[][] {
				{2,1,-3,-4,5}, {0,6,3,4,1}, {2,-2,-1,4,-5}, {-3,3,1,0,3}	
		};
		
		s.maxSubRectangle(matrix);
	}
}
