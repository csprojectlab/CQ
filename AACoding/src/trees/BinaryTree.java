package trees;

import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	public Node root;
	public int size;

	public BinaryTree() {
		Scanner input = new Scanner(System.in);
		this.root = this.takeInput(input, null, false);
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		this.size = 0;
	}

	public Node takeInput(Scanner input, Node parent, boolean isLeft) {
		if (parent == null)
			System.out.println("Enter the data for the root: ");
		else {
			if (isLeft) {
				System.out.println("Enter the data for the left child of " + parent.data);
			} else {
				System.out.println("Enter the data for the right child of " + parent.data);
			}
		}

		int data = input.nextInt();
		Node node = new Node(data, null, null);

		boolean hasChild;
		System.out.println("Do you want left child for " + node.data);
		hasChild = input.nextBoolean();
		if (hasChild) {
			node.left = this.takeInput(input, node, true);
		}
		System.out.println("Do you have right child for " + node.data);
		hasChild = input.nextBoolean();
		if (hasChild)
			node.right = takeInput(input, node, false);
		this.size++;
		return node;
	}

	public void display(Node node) {
		if (node.left != null)
			System.out.print(node.left.data + " => ");
		else
			System.out.print("END=> ");
		System.out.print(node.data + " ");
		if (node.right != null)
			System.out.print("<= " + node.right.data);
		else
			System.out.print("<=END");
		System.out.println();
		if (node.left != null)
			display(node.left);
		if (node.right != null)
			display(node.right);
	}

	public int getHeight(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 0; // empty tree.
		int leftHeight = 0;
		int rightHeight = 0;
		if (node.left != null)
			leftHeight = this.getHeight(node.left);
		if (node.right != null)
			rightHeight = this.getHeight(node.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public int getDiameter(Node node) {
		if (node == null)
			return 0;
		int leftDiameter = this.getDiameter(node.left);
		int rightDiameter = this.getDiameter(node.right);
		int heightFactor = this.getHeight(node.left) + this.getHeight(node.right) + 2;
		return Math.max(leftDiameter, Math.max(rightDiameter, heightFactor));
	}

	public boolean isBst(Node node) {
		if (node == null)
			return true;
		if (node.left.data > node.data || node.right.data < node.data)
			return false;
		return this.isBst(node.left) && this.isBst(node.right);
	}

	public void levelOrderTraversal(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			stack.push(currentNode);
			if (currentNode.left != null)
				queue.add(currentNode.left);
			if (currentNode.right != null)
				queue.add(currentNode.right);
		}
		while (!stack.isEmpty())
			System.out.println(stack.pop().data);
	}

	public int levelOfNode(Node node, int key, int level) {
		if (node == null)
			return 0;
		if (node.data == key)
			return level;
		int searchInLeft = this.levelOfNode(node.left, key, level + 1);
		if (searchInLeft == 0) // Not found in left subtree.
			return this.levelOfNode(node.right, key, level + 1);
		else
			return searchInLeft;
	}

	public void reverseLevelOrderTraversal(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			System.out.print(currentNode.data + " ");
			if (currentNode.left != null)
				queue.add(currentNode.left);
			if (currentNode.right != null)
				queue.add(currentNode.right);
		}
	}

	public void printNodesAtLevel(Node node, int currentLevel, int level) {
		if (node == null)
			return;
		if(currentLevel > level) return;
		if (currentLevel == level)
			System.out.println(node.data + " ");
		this.printNodesAtLevel(node.left, currentLevel + 1, level);
		this.printNodesAtLevel(node.right, currentLevel + 1, level);
	}

	public int getLeafNodes(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return this.getLeafNodes(node.left) + this.getLeafNodes(node.right);
	}

	public int getSum(Node node) {
		if (node == null)
			return 0;
		return this.getSum(node.left) + node.data + this.getSum(node.right);
	}

	public boolean isSumTree(Node node) {
		if (node == null || node.left == null || node.right == null)
			return true;
		int leftSum = this.getSum(node.left);
		int rightSum = this.getSum(node.right);
		if (node.data == leftSum + rightSum && this.isSumTree(node.left) &&
			this.isSumTree(node.right))
			return true;
		return false;
	}
	
	public Node lca(Node node, int k1, int k2) {
		if(node == null) 
			return null;
		if(node.data == k1 || node.data == k2)
			return node;
		Node leftAns = this.lca(node.left, k1, k2);
		Node rightAns = this.lca(node.right, k1, k2);
		if(leftAns != null && rightAns != null)
			return node;
		else if(leftAns != null)
			return leftAns;
		else if(rightAns != null)
			return rightAns;
		else 
			return null;		
	}
	
	
	
	//Given a tree and a sum, returns true if there is a path from the root 
	// down to a leaf, such that adding up all the values along the path 
	// equals the given sum. 
	public boolean hasSumPath(Node node, int currentSum, int sum) {
		if(node == null)
			return currentSum == sum;
		if(currentSum == sum && node.left == null && node.right == null)  // leaf.
			return true;
		boolean leftAns = this.hasSumPath(node.left, currentSum + node.data, sum);		
		if(!leftAns)
			return this.hasSumPath(node.right, currentSum + node.data, sum);			
		return leftAns;		
	}

	// For every node, data value must be equal to sum of data values in left and right children. Consider data value 
	// as 0 for NULL children
    public boolean hasChildrenSumProperty(Node node) {
    	if(node == null)
    		return true;
    	int leftData = 0;
    	int rightData = 0;
    	if(node.left != null)
    		leftData = node.left.data;
    	if(node.right != null)
    		rightData = node.right.data;
    	if(node.data == leftData + rightData &&
    	   this.hasChildrenSumProperty(node.left) && this.hasChildrenSumProperty(node.right)) 
    		return true;
    	return false;    	
    }
    
    public void printAllLeavesLeftToRight(Node node) {
    	if(node == null)
    		return;
    	if(node.left == null && node.right == null) {
    		System.out.println(node.data);
    		return;
    	}
    	this.printAllLeavesLeftToRight(node.left);
    	this.printAllLeavesLeftToRight(node.right);
    }
    
    public void printPathToAllLeafNodes(Node node, int[] storage, int level) {
    	if(node == null)
    		return;
    	storage[level] = node.data;
    	if(node.left == null && node.right == null) {
    		for(int i = 0; i <= level; i++) {
    			if(storage[i] == 0) 
    				break;
    			System.out.print(storage[i] + " ");
    		}
    		System.out.println();
    		return;
    	}
    	this.printPathToAllLeafNodes(node.left, storage, level + 1);
    	this.printPathToAllLeafNodes(node.right, storage, level + 1);
    }
    public boolean printAncestors(Node node, int key) {
    	if(node == null)
    		return false;
		if(node.data == key) {
			System.out.print(node.data + " ");
			return true;
		}
		if(this.printAncestors(node.left, key) || this.printAncestors(node.right, key)) {
			System.out.print(node.data + " ");
			return true;
		}
		return false;
	}
    
    public int isSumTreeEfficent(Node node) {
    	if(node.left ==  null && node.right == null) 
    		return node.data;
    	int leftAns = 0;
    	int rightAns = 0;
    	if(node.left != null)
    		leftAns = this.isSumTreeEfficent(node.left);
    	if(node.right != null)
    		rightAns = this.isSumTreeEfficent(node.right);
    	if(leftAns + rightAns == node.data) 
    		return 2 * node.data;
    	else
    		return -1;
    }    
    
    // Width is the maximum number of nodes at a level. Using level order.
    public int getWidth(Node node) {
    	Queue<Node> queue = new LinkedList<Node>();
    	int width = 0;
    	queue.add(node);
    	while(!queue.isEmpty()) {
    		int nodesAtThisLevel = queue.size();
    		width = Math.max(width, nodesAtThisLevel);
    		while(nodesAtThisLevel-- > 0) {
    			Node nodeAtThisLevel = queue.remove();
    			if(nodeAtThisLevel.left != null)
    				queue.add(nodeAtThisLevel.left);
    			if(nodeAtThisLevel.right != null)
    				queue.add(nodeAtThisLevel.right);
    		}
    	}    	
    	return width;
    }
    
    private class Maximum {
    	int max = -999;
    }
    public int getMaxSumLeafPath(Node node) {
    	Maximum m = new Maximum();
    	this.getMaxSumLeafPath(node, 0, m);
    	return m.max;    	
    }
    public void getMaxSumLeafPath(Node node, int currentSum, Maximum m) {
    	if(node == null)
    		return;
        if(node.data + currentSum > m.max && node.left == null && node.right == null)
        	m.max = node.data + currentSum;  // Only change at leaf node.
        this.getMaxSumLeafPath(node.left, currentSum + node.data, m);
        this.getMaxSumLeafPath(node.right, currentSum + node.data, m);    	
    }
    
    private class DecisionData {
    	Node node = null;
    	int level = -1;
    }
    
    public int getDeepestLeafNode(Node node) {
    	DecisionData savedNode = new DecisionData();
    	this.getDeepestLeafNode(node, 1, savedNode); // Level can be 0 or 1.
    	return savedNode.node.data;
    }
    // There can be two or more deep nodes at the same level. You can update this to store multiple nodes.
    public void getDeepestLeafNode(Node node, int level, DecisionData savedNode) {
    	if(node == null)
    	    return;
    	if(level > savedNode.level && node.left == null && node.right == null) {
    		savedNode.node = node;
    		savedNode.level = level;
    		return;
    	}
    	this.getDeepestLeafNode(node.left, level + 1, savedNode);
    	this.getDeepestLeafNode(node.right, level + 1, savedNode);    	
    }
    
    public int getMaximumSumPathBetweenTwoLeaves(Node node) {
    	Maximum m = new Maximum();
    	this.getMaximumSumPathBetweenTwoLeaves(node, m);
    	return m.max;
    }
    
    // Interesting question.
    public int getMaximumSumPathBetweenTwoLeaves(Node node, Maximum m) {
    	if(node == null)
    		return 0;
    	if(node.left == null && node.right == null)
    		return node.data;
    	int leftAns = this.getMaximumSumPathBetweenTwoLeaves(node.left, m);
    	int rightAns = this.getMaximumSumPathBetweenTwoLeaves(node.right, m);
    	if(node.left != null && node.right != null) {
    		int ans = node.data + leftAns + rightAns;
    		m.max = Math.max(m.max, ans);
    		return Math.max(leftAns, rightAns) + node.data;    				
    	}
    	else if(node.left != null)
    		return node.data + leftAns;
    	else
    		return node.data + rightAns;
    }
    
    public void printNodesWithoutSiblings(Node node) {
    	if(node == null)
    		return;
    	if(node.left != null && node.right != null) {
    		this.printNodesWithoutSiblings(node.left);
    		this.printNodesWithoutSiblings(node.right);
    	}
    	else if(node.left != null) {
    		System.out.print(node.left.data + " ");
    		this.printNodesWithoutSiblings(node.left);
    	}
    	else if(node.right != null) {
    		System.out.print(node.right.data + " ");
    		this.printNodesWithoutSiblings(node.right);
    	}
    }
    
    // Path can start and end at any node.
    public int getMaximumSumPath(Node node) {
    	Maximum m = new Maximum();
    	this.getMaximumSumPath(node, m);
    	return m.max;
    }
    
    public int getMaximumSumPath(Node node, Maximum m) {
    	if(node == null)
    		return 0;
    	if(node.left == null && node.right == null)
    		return node.data;
    	int leftAns = this.getMaximumSumPath(node.left, m);
    	int rightAns = this.getMaximumSumPath(node.right, m);
    	int factor1 = Math.max(Math.max(leftAns, rightAns) + node.data, node.data);
    	int factor2 = Math.max(factor1, leftAns + rightAns + node.data);
    	m.max = Math.max(factor2, m.max);
    	return factor1; // Factor2 will make the path and hence we can't return it.
    }
	
	public static void main(String... args) {
		// 50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		BinaryTree tree = new BinaryTree();
		tree.display(tree.root);
		System.out.println("Height of the tree is: " + tree.getHeight(tree.root));
		System.out.println("Diameter of the tree is: " + tree.getDiameter(tree.root));
		System.out.println("lca: " + tree.lca(tree.root, 39, 80).data);
		System.out.println("Has sum path: " + tree.hasSumPath(tree.root, 0, 169));
		tree.printAllLeavesLeftToRight(tree.root);
		tree.printPathToAllLeafNodes(tree.root, new int[100], 0);
		System.out.println("Ancestors of: " + tree.printAncestors(tree.root, 11));
		System.out.println("Is Sum Tree: " + ((tree.isSumTreeEfficent(tree.root) == -1) ? false:true));
	    System.out.println("Width of the tree is: " + tree.getWidth(tree.root));
	    System.out.println("Maximum leaf path: " + tree.getMaxSumLeafPath(tree.root));
	    System.out.println("Deepest Leaf node is: " + tree.getDeepestLeafNode(tree.root));
	    System.out.println("Max sum path between two leaves: " + tree.getMaximumSumPathBetweenTwoLeaves(tree.root));
	    System.out.println("Nodes without siblings:");
	    tree.printNodesWithoutSiblings(tree.root);
	    System.out.println("Maximum Sum Path: " + tree.getMaximumSumPath(tree.root));
	   
	}

}
