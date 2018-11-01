package trees;

import java.util.HashMap;
import java.util.Map;

public class DiagonalSumOfBinaryTree extends BinaryTree{
	Map<Integer, Integer> slopeMap;
	public DiagonalSumOfBinaryTree() {
		super();
		this.slopeMap = new HashMap<Integer, Integer>();
	}
	
	public void diagonalSum(Node node, int slope) {
		if(node.right != null) 
			this.diagonalSum(node.right, slope);
		if(this.slopeMap.get(slope) == null) {
			this.slopeMap.put(slope, node.data);
		} else {
			int val = this.slopeMap.get(slope);
			val += node.data;
			this.slopeMap.put(slope, val);
		}		
		if(node.left != null)
		   this.diagonalSum(node.left, slope + 1);
	}
	
	public static void main(String[] args) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		DiagonalSumOfBinaryTree t = new DiagonalSumOfBinaryTree();
		t.diagonalSum(t.root, 1);
		System.out.println(t.slopeMap);
	}
}
