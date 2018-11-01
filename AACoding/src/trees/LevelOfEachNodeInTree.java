package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LevelOfEachNodeInTree extends BinaryTree {
	public LevelOfEachNodeInTree() {
		super();
	}
	
	public Map<Integer, Integer> levelOfEachNode() {
		Queue<Node> queue = new LinkedList<Node>();
		Map<Integer, Integer> levelMap = new HashMap<Integer, Integer>();
		queue.add(this.root);
		int level = 1;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize-- > 0) {
				Node node = queue.remove();
				levelMap.put(node.data, level);
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}			
			level++;
		}
		return levelMap;
	}
	
	public static void main(String[] args) {
		// 50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		LevelOfEachNodeInTree t = new LevelOfEachNodeInTree();
		System.out.println("Level of each node: " + t.levelOfEachNode());  // 43:3
	}

}
