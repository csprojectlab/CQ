package trees;

//Given a binary tree, a complete path is defined as a path from root to a leaf. The sum of all nodes on that path is defined as the sum of that path. Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.
//Note: A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.

//Consider the following Binary Tree
//1 
///      \
//2        3
///   \     /  \
//4     5   6    7
/// \    /       /
//8   9  12      10
/// \           \
//13  14         11
/// 
//15 
//
//For input k = 20, the tree should be changed to following
//(Nodes with values 6 and 8 are deleted)
//1 
///      \
//2        3
///   \        \
//4     5        7
//\    /       /
//9  12      10
/// \           \
//13  14         11
/// 
//15 
//
//For input k = 45, the tree should be changed to following.
//1 
/// 
//2   
/// 
//4  
//\   
//9    
//\   
//14 
///
//15 

public class RemovingNodesNotLyingInAnySumPath extends BinaryTree {
	public RemovingNodesNotLyingInAnySumPath() {
		super();
	}
	
	public Node pruneTree(Node node, int sum, int k) {
		if(node.left == null && node.right == null) {
			if(sum + node.data < k)  // Also add current node data. 
				return null;
			return node;
		}
		if(node.left != null) 
			node.left = this.pruneTree(node.left, sum + node.data, k);
		if(node.right != null)
			node.right = this.pruneTree(node.right, sum + node.data, k);
		// After checks.
		if(node.left == null && node.right == null) // Important point for null propagation.
			return null;
		return node;		
	}
	
	public static void main(String[] args) {
//		1 true 2 true 4 true 8 false false true 9 true 13 false false true 14 true 15 false false false true 5 true 12 false false false true 3 true 6 false false true 7 true 10 false true 11 false false false
		RemovingNodesNotLyingInAnySumPath t = new RemovingNodesNotLyingInAnySumPath();
		System.out.println();
		System.out.println("Before Pruning: ");
		t.display(t.root);
		int k = 45;
		t.root = t.pruneTree(t.root, 0, k);
		System.out.println();
	    System.out.println("After pruning: ");
	    t.display(t.root);
	}

}   
