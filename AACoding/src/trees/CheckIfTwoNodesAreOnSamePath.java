package trees;

import java.util.HashMap;
import java.util.Map;

public class CheckIfTwoNodesAreOnSamePath extends GenericTree {
	Map<Integer, Integer> inTime;
	Map<Integer, Integer> outTime;
	int timer;
	public CheckIfTwoNodesAreOnSamePath() {
		super();
		this.inTime = new HashMap<>();
		this.outTime = new HashMap<>();
		this.timer = 0;
	}
	
	public void checkNodesInSamePath() {
		this.checkNodesInSamePathDFS(this.root);
		
	}
	
	public boolean inSamePath(int u, int v) {	
		if(this.inTime.get(u) < this.inTime.get(v) && this.outTime.get(u) > this.outTime.get(v) ||
		   this.inTime.get(u) > this.inTime.get(v) && this.outTime.get(u) < this.outTime.get(v))
			return true;
		return false;
	}
	
	public void checkNodesInSamePathDFS(GenericNode node) {
		this.inTime.put(node.data, ++this.timer);
		for(GenericNode n : node.children) {
			this.checkNodesInSamePathDFS(n);
		}
		this.outTime.put(node.data, ++this.timer);
	}
	
	
	public static void main(String[] args) {
		CheckIfTwoNodesAreOnSamePath t = new CheckIfTwoNodesAreOnSamePath();
		t.root.data = 1;
		GenericNode n = new GenericNode(2);
		GenericNode x= new GenericNode(5);
		n.children.add(x);
		t.root.children.add(n);
		n = new GenericNode(3);
		x = new GenericNode(6);
		n.children.add(x);
		t.root.children.add(n);
		n = new GenericNode(4);
		x = new GenericNode(7);
		n.children.add(x);
		t.root.children.add(n);
		t.checkNodesInSamePath();
		System.out.println(t.inSamePath(5, 2));  // True
		t.display(t.root);
		
	}

}
