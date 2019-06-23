package util;

public class Util {
	
	// Prints the matrix with spacing.
	public static void printMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printMatrix(char[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void printMatrix(boolean[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void swap(int[] arr, int i , int j) {
		if(arr[i] == arr[j])
			return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void print(int[] arr) {
		Util.print(arr, 0, arr.length-1);
	}
	
	public static void print(int[] arr, int start, int end) {
		for(int i = start; i <= end; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
