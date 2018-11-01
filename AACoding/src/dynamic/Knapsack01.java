package dynamic;

import java.util.HashSet;
import java.util.Set;

public class Knapsack01 {

	public Set<Integer> getItems(int[][] k, int[] weight) {
		Set<Integer> items = new HashSet<>();
		int i = k.length - 1;
		int j = k[i].length - 1;
		while(k[i][j] != 0) {   // Till we reach the value zero.
			if(k[i-1][j] == k[i][j])   // if value matches the top value, It is not considered in result.
				i--;
			else {
				items.add(i-1);    // Index of the item.
				j -= weight[i-1];
				i--;  
			}
		}
		System.out.println("Items at the index: " + items + " are selected.");
		return items;
	}
	
	public int knapsack(int[] weight, int[] value, int W) {
		int k[][] = new int[1 + value.length][1 + W];   // W is max weight.
		for(int i = 1; i < k.length; i++) {   // For objects till i
			for(int j = 1; j < k[i].length; j++) {    // For sack weight to be j.
				if(weight[i-1] <= j) {  // value can be compensated.
					// Don't consider the item, consider the item.
					k[i][j] = Math.max(k[i-1][j], value[i-1] + k[i-1][j-weight[i-1]]);
				} else
					k[i][j] = k[i-1][j];    // Don't consider the item.
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Max Value: " + k[k.length-1][k[0].length-1]);
		
		this.getItems(k, weight);
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		Knapsack01 k = new Knapsack01();
		int[] weight = new int[] {1,3,4,5};
		int[] value = new int[] {1,4,5,7};
		int W = 7;
		k.knapsack(weight, value, W);
	}
	
	
}
