package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tries {
   // Data Field.
	private Node root;
	private int numberOfWords;
	/**
	 *  Constructor. 
	 */
	public Tries() {
		root = new Node('\0', false);
		numberOfWords = 0;
		
	}
	/**
	 * 
	 * @param word
	 */
	public void addWord(String word) {
		this.addWord(this.root, word);
	}
	/**
	 * 
	 * @param parent
	 * @param word
	 */
	private void addWord(Node parent, String word) {
		if(word.length() == 0) {
			if(parent.isTerminal) {
				// DO nothing.
			}
			else
				parent.isTerminal = true;  // New word stored.			
			this.numberOfWords++;
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if(child == null) {  // Character appeared for the first time.
			child = new Node(cc, false);
			parent.children.put(cc, child);
		}
		this.addWord(child, ros);		
	}
	/**
	 * 
	 * @param word
	 */
	public void remove(String word) {
		this.remove(this.root, word);
	}
	/**
	 * 
	 * @param parent
	 * @param word
	 */
	private void remove(Node parent, String word){
		if(word.length() == 0) {
			if(parent.isTerminal) {				
			    parent.isTerminal = false; 	
			    this.numberOfWords--;
			}			
			return;
		}		
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = null;
		child = parent.children.get(cc);
		if(child != null)
			remove(child, ros);
		if(!child.isTerminal && child.children.size() == 0)
			parent.children.remove(cc);		
	}
	/**
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		return this.search(this.root, word);
	}
	/**
	 * 
	 * @param parent
	 * @param word
	 * @return
	 */
	private boolean search(Node parent, String word) {
		if(word.length() == 0 ) {
			if(parent.isTerminal)
			   return true;
			else
				return false;
		}		
		char cc = word.charAt(0);
		Node currentNode = null;
		currentNode = parent.children.get(cc);
		if(currentNode != null)
			return this.search(currentNode, word.substring(1));	
		else
		    return false;		
	}
	/**
	 * 
	 */
	public void displayAsTree() {
		this.displayAsTree(this.root);
	}
	/**
	 * 
	 * @param node
	 */
	private void displayAsTree(Node node) {
		String str = "";
		str += node.data + "=>";
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for(Map.Entry<Character, Node> entry : entries)
			str += entry.getKey() + ",";
		str += "END";
		System.out.println(str);
		for(Map.Entry<Character, Node> entry : entries)
			this.displayAsTree(entry.getValue());
	}
	/**
	 * 
	 */
	public void display() {
		this.display(this.root, "");
	}
	/**
	 * 
	 * @param node
	 * @param word
	 */
	private void display(Node node, String word) {
		if(node.isTerminal) {
			String toPrint = word.substring(1) + node.data;
			System.out.println(toPrint);
		}
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for(Map.Entry<Character, Node> entry : entries)
			this.display(entry.getValue(), word + node.data);	
	}	
	/**
	 * 
	 * @author aridamannandan
	 *
	 */
	private class Node {
		Character data;
		HashMap<Character, Node> children;
		
		boolean isTerminal;
		public Node(Character data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			children = new HashMap<>();
			
		}
	}
	
	 public static void main(String[] args) {
		   Tries t = new Tries();
		   t.addWord("art");
		   t.addWord("arts");
		   t.addWord("boy");
		   t.addWord("bug");
		   t.addWord("see");
		   t.addWord("seen");
		   t.addWord("sea");	  
		   
	       t.displayAsTree();	
	       System.out.println(t.search("arts"));
	       t.display();
	   }
}  // End of class.

