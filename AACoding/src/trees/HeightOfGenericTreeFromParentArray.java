package trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfGenericTreeFromParentArray extends GenericTree {
	public HeightOfGenericTreeFromParentArray() {
		super();
	}
	
	public void buildTree(int[] parent) {
		this.root.data = 0;
		GenericNode[] nodeArray = new GenericNode[parent.length];
		nodeArray[0] = this.root;
		for(int i = 1; i < parent.length; i++) // It is necessary to initialize all nodes first.
			nodeArray[i] = new GenericNode(i);  // New node with data.
		for(int i = 1; i < parent.length; i++) {
			int parentNode = parent[i];
			nodeArray[parentNode].children.add(nodeArray[i]);
		}
	}
	
	public int heightOfTreeBFS() {
		Queue<GenericNode> queue = new LinkedList<GenericNode>();
		queue.add(this.root);
		int level = 0;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize-- > 0) {
				GenericNode node = queue.remove();
				System.out.println("Level " + level + ": " + node.data + " node");
				for(GenericNode child : node.children)
					queue.add(child);
			}
			level++;
		}
		return level-1;   // Max level gives the height of tree.
	}
	
	// Naive solution.
//	One solution is to traverse up the tree from node till root node is reached with node value -1. While Traversing for each node store maximum path length.
//	Time Complexity of this solution is O(n^2).
	public int naiveSolution(int[] parent) {
		int maxPathLength = 0;
		for(int node = 1; node < parent.length; node++) {
			int pathLength = 0;
			int currentNode = node;
			while(parent[currentNode] != -1) {
				pathLength++;
				currentNode = parent[currentNode];
			}
			maxPathLength = Math.max(pathLength, maxPathLength);
		}
		return maxPathLength;
	}
	
	public static void main(String[] args) {
		int parent[] = {-1, 0, 0, 0, 3, 7, 1, 2};
//		int parent[] = {-1,0,1,2,3};  // Height is 4
		HeightOfGenericTreeFromParentArray t = new HeightOfGenericTreeFromParentArray();
		t.buildTree(parent);
		System.out.println("Height of tree using BFS: " + t.heightOfTreeBFS());
		System.out.println("Height of tree using naive solution: " + t.naiveSolution(parent));
	}
}
