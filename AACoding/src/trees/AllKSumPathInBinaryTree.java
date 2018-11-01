package trees;

import java.util.ArrayList;
import java.util.List;

public class AllKSumPathInBinaryTree extends BinaryTree {
	List<Integer> nodeList;
	public AllKSumPathInBinaryTree() {
		super();
		this.nodeList = new ArrayList<Integer>();
	}
	
	public void printAllPathsPreOrder(Node node, int k) {
		if(node == null)
			return;
		this.nodeList.add(node.data);
		this.printAllPathsPreOrder(node.left, k);
		this.printAllPathsPreOrder(node.right, k);
		// Till this point the list is filled with all nodes from root to the leaf node.
		int sum = 0;
		for(int i = this.nodeList.size() - 1; i >= 0; i--) {
			sum += this.nodeList.get(i);
			if(sum == k) {
				int lastIndex = this.nodeList.size() - 1;
				while(lastIndex >= i)
					System.out.print(this.nodeList.get(lastIndex--) + " ");
				System.out.println();
			}
		}
		this.nodeList.remove(this.nodeList.size()-1);
	}
	

	public static void main(String[] args) {
		AllKSumPathInBinaryTree t = new AllKSumPathInBinaryTree();
		t.display(t.root);
		System.out.println("All Sum paths: ");
		t.printAllPathsPreOrder(t.root, 5);
	}

}
