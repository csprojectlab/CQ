package trees;

public class CountNumberOfBinaryTreeFromN {
	public static int BT[] = new int[20];   // can hold result of 20 nodes.
	public static int fact[] = new int[50];
	public static int BTForN(int n) {
		if(n == 0)  // tree with no node.
			return 1;
		if(BT[n] != 0) {
			System.out.println("DP");  // Using saved result.
			return BT[n];
		}
		int leftNodes;
		int subNodes = n - 1;
		for(leftNodes = 0; leftNodes < n; leftNodes++) 
			BT[n] += BTForN(leftNodes)*BTForN(subNodes - leftNodes);
		return BT[n];
	}
	
	public static int factorial(int n) {
		if(n == 0 || n == 1)
			return 1;
		if(fact[n] != 0)
			return fact[n];
		fact[n] = factorial(n-1)*n;
		return fact[n];
	}
	
	// This can also be done using the catalan number.
	public static int catalanNumber(int n) {
       return (factorial(2*n) / (factorial(n+1)*factorial(n)));
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println("Number of binary trees with " + n + " nodes: " + BTForN(n));
		System.out.println("Using catalan number: " + catalanNumber(n));
	}
}
