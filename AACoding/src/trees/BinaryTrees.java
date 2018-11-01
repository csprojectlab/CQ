package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
	int data;
	Node right, left;
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.right = right;
		this.left = left;
	}
}

public class BinaryTrees {
   private Node root;
   private int size;
   
   // Constructor.
   public BinaryTrees() {
	   Scanner input = new Scanner(System.in);
	   this.root = this.takeInput(input, null, false);
	   this.size = 0;
   }   
   /**
    * 
    * @return
    */
   public int getSize() {
	   return this.size;
   }
   @SuppressWarnings("unused")
   public int getHeight() {
	   return this.getHeight(root);
   }
   /**
    * 
    * @return
    */
   public boolean isBST() {
	   return isBST(this.root);
   }
   /**
    * 
    * @param node
    * @return
    */
   private boolean isBST(Node node) {
	   if(node == null)
		   return true;
	   if(node.left.data > node.data || node.right.data < node.data)
		   return false;
	   return (isBST(node.left) && isBST(node.right));
   }
   /**
    * 
    * @return
    */
   public int getDiameter() {
	   return this.getDiameter(this.root);
   }
   /**
    * 
    * @param node
    * @return
    */
   private int getDiameter(Node node) {
	   if(node == null)
		   return 0;
	   int f1 = this.getDiameter(node.left);
	   int f2 = this.getDiameter(node.right);
	   int f3 = this.getHeight(node.left) + this.getHeight(node.right) + 2;
	   return Math.max(f1, Math.max(f2, f3));
   }
   /**
    * 
    * @param node
    * @return
    */
   private int getHeight(Node node) {
	   if(node.left == null && node.right == null)   // Empty tree. 
		   return 0;
	   int h1 = 0; 
	   int h2 = 0;
	   if(node.left != null) 
		   h1 = getHeight(node.left);	
	   if(node.right != null)
		   h2 = getHeight(node.right);		
	   return 1 + Math.max(h1, h2); 
   }
   /**
    * 
    */
   public void display() {
	   this.display(root);
   }
   /**
    * 
    * @param node
    */
   private void display(Node node) {
	   if(node.left != null)
		   System.out.print(node.left.data + " =>");
	   else
		   System.out.print("END =>");
	   System.out.print(" " + node.data + " ");
	   if(node.right != null)
		   System.out.print(" <= " + node.right.data);
	   else
		   System.out.print(" <= END");
	   
	   System.out.println();	   
	   if(node.left != null)
	      display(node.left);
	   if(node.right != null)
		   display(node.right);	   
   }
   /**
    * 
    * @param input
    * @param parent
    * @param isLeftOrRight
    * @return
    */
   private Node takeInput(Scanner input, Node parent, boolean isLeftOrRight) {
	   if(parent == null) 
		   System.out.println("Enter the data for the root: ");
	   else {
		   if(isLeftOrRight) {
			   System.out.println("Enter the data for the left child of " + parent.data);
		   }else {
			   System.out.println("Enter the data for the right child of " + parent.data);
		   }
	   }
	   
	   int data = input.nextInt();
	   Node node = new Node(data, null, null);
	   
	   boolean hasChild = false;
	   System.out.println("Do you have left child for " + node.data);
	   hasChild = input.nextBoolean();
	   if(hasChild) 
		   node.left = takeInput(input, node, true);
	   
	   System.out.println("Do you have right child for " + node.data);
	   hasChild = input.nextBoolean();
	   if(hasChild)
		   node.right = takeInput(input, node, false);
	   this.size++;
	   return node;
   }
   
   public void levelOrderT() {
	   Queue<Node> queue = new LinkedList<Node>();
	   queue.add(this.root);
	   while(!queue.isEmpty()) {
		   Node node = queue.poll();
		   System.out.println(node.data);
		   if(node.left != null)
			   queue.add(node.left);
		   if(node.right != null)
			   queue.add(node.right);
	   }	   
   }
   
   public void reverseLevelOrderT() {
	   Queue<Node> queue = new LinkedList<Node>();
	   Stack<Node> stack = new Stack<Node>();
	   queue.add(this.root);
	   while(!queue.isEmpty()) {
		   Node node = queue.poll();
		   stack.add(node);
		   if(node.right != null)
			   queue.add(node.right);
		   if(node.left != null)
			   queue.add(node.left);		   
	   }
	   while(!stack.isEmpty()) {
		   Node node = stack.peek();
		   System.out.println(node.data);
		   stack.pop();
	   }	   
	   
   }
   private Node lca(Node node, int d1, int d2) {
		if (node == null) {
			return null;
		}
		if (node.data == d1 || node.data == d2) {
			return node;
		}
		Node llca = this.lca(node.left, d1, d2);
		Node rlca = this.lca(node.right, d1, d2);
		if (llca != null && rlca != null) {
			return node;
		} else if (llca != null) {
			return llca;
		} else if (rlca != null) {
			return rlca;
		} else {
			return null;
		}
	}
    private int findLevel(Node node, int key, int distance) {
    	if(node == null)
    		return -1;
    	if(node.data == key)
    		return distance;
    	int fac = findLevel(node.left, key, distance+1);
    	if(fac == -1)
    		return findLevel(node.right, key, distance+1);
    	return fac;   	
    }
   
    public int findDistance(int n1, int n2) {
    	Node lca = lca(this.root, n1,n2);    	
    	int d1 = findLevel(lca, n1, 0);
    	int d2 = findLevel(lca, n2, 0);
    	return d1 + d2;   	
    }
    public boolean hasPathSum(int sum) {
    	return this.hasPathSum(this.root, sum);    	
    }
    private boolean hasPathSum(Node node, int sum) {
    	if(node == null)
    		return sum == 0;    	
    	int subSum = sum - node.data;
    	if(subSum == 0 && node.left == null && node.right == null) 
    		return true;
    	boolean ans = false;
    	if(node.left != null) 
    		ans = hasPathSum(node.left, subSum);
    	if(!ans && node.right != null)
    		ans = hasPathSum(node.right, subSum);
    	return ans;   	
    	
    }
    
    public boolean childrenSumProperty() {
    	return this.childrenSumProperty(this.root);
    }
    private boolean childrenSumProperty(Node node) {
    	if(node == null || node.left == null || node.right == null)
    		return true;
    	int leftData = 0;
    	int rightData = 0;
    	if(node.left != null)
    		leftData = node.left.data;
    	if(node.right != null)
    		rightData = node.right.data;
    	if(node.data == (leftData + rightData) &&
    	   (childrenSumProperty(node.left)) &&
    	   (childrenSumProperty(node.right)))
    		  return true;
    	return false;    	
    }
    public int getLeafNodes() {
    	return this.getLeafNodes(this.root);
    }
    private int getLeafNodes(Node node) {
    	if(node == null)
    		return 0;
    	if(node.left == null && node.right == null)
    		return 1;
    	return getLeafNodes(node.left) + getLeafNodes(node.right);   	
    }
    public void printRootToAllLeaves() {
    	int[] strg = new int[100];
    	printRootToAllLeaves(this.root, strg, 0);
    }
    private void printRootToAllLeaves(Node node, int[] strg, int index) {
    	if(node == null)
    		return;
    	strg[index] = node.data;
    	index++;
    	if(node.left == null && node.right == null) {
    		for(int i = 0; i < index; i++) {
    			System.out.print(strg[i] + " ");
    		}
    		System.out.println();
    	}
    	else {
    		printRootToAllLeaves(node.left, strg, index);
    		printRootToAllLeaves(node.right, strg, index);   		
    	}    	
    }
    public boolean isSumTree() {
    	return this.isSumTree(this.root);
    }
    private int sum(Node node) {
    	if(node == null)
    		return 0;
    	return (sum(node.left) + node.data + sum(node.right));
    }
    private boolean isSumTree(Node node) {
    	if(node == null || (node.left == null && node.right == null))
    		return true;
    	int lSum = sum(node.left);
    	int rSum = sum(node.right);
    	if((node.data == lSum + rSum)
    		&& (isSumTree(node.left))
    		&& (isSumTree(node.right)))
    		return true;
    	return false;
    }
    public boolean printAncestors(int key) {
    	return this.printAncestors(this.root, key);
    }
    private boolean printAncestors(Node node, int key) {
    	if(node == null)
    		return false;
    	
    	if(node.data == key)
    		return true;
    	if(printAncestors(node.left, key) || printAncestors(node.right, key)) {
    		System.out.print(node.data + " ");
    		return true;
    	}
    	return false;  // Key not found    	
    }
    public int levelOfNode(int key) {
    	return this.levelOfNode(this.root, key, 1);
    }
    private int levelOfNode(Node node, int key, int level) {
    	if(node == null)
    		return 0;    	
    	if(node.data == key)
    		return level;
    	int factor = levelOfNode(node.left, key, level+1);
    	if(factor == 0)  // Not found in left tree.
    		factor = levelOfNode(node.right, key, level+1);
    	return factor;    	
    }
    public void printNodesAtLevel(int level) {
    	printNodesAtLevel(this.root, level, 1);
    }
    private void printNodesAtLevel(Node node, int level, int currLevel) {
    	if(node == null)
    		return;
    	if(currLevel == level) {
    		System.out.print(node.data + " ");
    		return;
    	}
    	printNodesAtLevel(node.left, level, currLevel+1);
    	printNodesAtLevel(node.right, level, currLevel+1);    	
    }
    public int maxWidth() {
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(this.root);
    	int result = 0;
    	while(!queue.isEmpty()) {
    		int count = queue.size();
    		result = Math.max(result, count);
    		while(count-- > 0) {
    			Node temp = queue.remove();
    			if(temp.left != null)
    				queue.add(temp.left);
    			if(temp.right != null)
    				queue.add(temp.right);
    		}   		
    	}
    	return result;    	
    }
    private class Maximum {
    	int max = -999;
    }
    public int getMaxSumLeafPath() {
    	Maximum m = new Maximum();
    	getMaxSumLeafPath(this.root, m, 0);
    	return m.max;    	
    }
    private void getMaxSumLeafPath(Node node, Maximum m, int currSum) {
    	if(node == null)
    		return;
    	currSum = currSum + node.data;
    	if(node.left == null && node.right == null) {
    		if(currSum > m.max)
    			m.max = currSum;
    	}
    	getMaxSumLeafPath(node.left, m, currSum);
    	getMaxSumLeafPath(node.right, m, currSum);    	
    }
    private class SaveNodeData {
    	Node key = null;
    	int level = 0;
    }
    public int getDeepestLeftLeafNode() {
    	SaveNodeData d = new SaveNodeData();    	
    	this.getDeepestLeftLeafNode(this.root, d, 1);
    	return d.key.data;
    }
    private void getDeepestLeftLeafNode(Node node, SaveNodeData d, int level) {
    	if(node == null)
    		return;
    	if(node.left == null && node.right == null) {
    		if(level > d.level) {
    			d.key = node;
    			d.level = level;
    		}    			
    	}
    	getDeepestLeftLeafNode(node.left, d, level+1);
    	getDeepestLeftLeafNode(node.right, d, level+1);
    }
    private class Save {
    	int sum = -999;
    }
    public int getMaxSumBetweenLeaves() {
    	Save s = new Save();
    	getMaxSumBetweenLeaves(this.root, s);
    	return s.sum;
    }
    private int getMaxSumBetweenLeaves(Node node, Save s) {
    	if(node == null)
    		return 0;
    	if(node.left == null && node.right == null)
    		return node.data;
        int leftside = getMaxSumBetweenLeaves(node.left, s);
        int rightside = getMaxSumBetweenLeaves(node.right, s);
        if(node.left != null && node.right != null) {
        	int r = node.data + leftside + rightside;
        	s.sum = Math.max(s.sum, r);
        	return Math.max(leftside, rightside) + node.data;
        }
        if(node.left != null) 
        	return leftside + node.data;
        else
        	return rightside + node.data;
    }
    
    public void nodesWithoutSiblings() {
    	this.nodesWithoutSiblings(this.root);
    }
    private void nodesWithoutSiblings(Node node) {
    	if(node == null)
    		return;
    	if(node.left != null && node.right != null) {
    		nodesWithoutSiblings(node.left);
    		nodesWithoutSiblings(node.right);
    	}
    	else if(node.right != null) {
    		System.out.print(node.right.data + " ");
    		nodesWithoutSiblings(node.right);
    	}
    	else if(node.left != null) {
    		System.out.print(node.left.data + " ");
    		nodesWithoutSiblings(node.left);
    	}    		
    }
    public int maxSumPath() {
		Save s = new Save();
		this.maxSumPath(this.root, s);
		return s.sum;    	
    }
    private int maxSumPath(Node node, Save s) {
    	if(node == null)
    		return 0;
    	if(node.left == null && node.right == null)
    		return node.data;
    	int l = maxSumPath(node.left, s);
    	int r = maxSumPath(node.right, s);
    	int fac1 = Math.max(Math.max(l, r) + node.data, node.data);
		int fac2 = Math.max(fac1, l + r + node.data);
		s.sum = Math.max(s.sum, fac2);
		return fac1;    	
    }
   
   
   
   
   
   
   
   
}  // End of class.
