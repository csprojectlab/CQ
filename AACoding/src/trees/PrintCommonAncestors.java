package trees;

public class PrintCommonAncestors extends BinaryTree {

	public PrintCommonAncestors() {
		super();
	}

	public boolean printUtil(Node node, int target) {
		if(node.data == target) {
			System.out.print(node.data + " ");
			return true;
		}
		boolean left = false;
		boolean right = false;
		if(node.left != null)
			left = this.printUtil(node.left, target);
		if(node.right != null)
			right = this.printUtil(node.right, target);
		if(left || right) {
			System.out.print(node.data + " ");
			return true;
		}
		return false;
	}
	
	public void printCommonAnc(int k1, int k2) {
		Node lca = this.lca(this.root, k1, k2);
		this.printUtil(this.root, lca.data);
	}
	
	public boolean printKthUtil(Node node, int target, int currentK, int k) {
		if(node.data == target) {
			if(currentK == k)
				System.out.println(node.data);
			return true;
		}
		boolean left = false;
		boolean right = false;
		if(node.left != null)
			left = this.printKthUtil(node.left, target, currentK + 1, k);
		if(node.right != null)
			right = this.printKthUtil(node.right, target, currentK + 1, k);
		if(left || right) {
			if(currentK == k)
				System.out.println(node.data);
			return true;
		}
		return false;
	}
	
	public void printKthCommonAncestor(int k1, int k2, int k) {
		Node lca = this.lca(this.root, k1, k2);
		this.printKthUtil(this.root, lca.data, 1, k);
	}
	
	
	public static void main(String[] args) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		PrintCommonAncestors t = new PrintCommonAncestors();
		System.out.print("Ancestors: ");
		t.printCommonAnc(39, 41);
		System.out.println();
		System.out.print("Kth Ancestor: ");
		t.printKthCommonAncestor(39, 41, 2);  // 80
	}

}
