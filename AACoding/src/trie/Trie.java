package trie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Node {
    Character data;
	HashMap<Character, Node> children;
	boolean isTerminal;
	public Node() {}
	public Node(Character data, boolean isTerminal) {
		this.data = data;
		this.isTerminal = isTerminal;
		this.children = new HashMap<Character, Node>();
	}
}

public class Trie {
	Node root;
	int numberOfWords;
	public Trie() {
		this.root = new Node('\0', false);
		this.numberOfWords = 0;
	}
	
	public void addWord(String word) {
		this.addWord(this.root, word);
	}
	
	public void addWord(Node parent, String word) {
		if(word.length() == 0) { // This means parent node will symbolize empty string
			if(!parent.isTerminal)  // Comment: If we add 'There' and then 'The'.
				parent.isTerminal = true;
			this.numberOfWords++;
		} else {
			char currentCharacter = word.charAt(0);
			String restOfString = word.substring(1);
			Node child = parent.children.get(currentCharacter);  // See if character already exist.
			if(child == null) {  // currentCharacter doesn't exist in path
				child =  new Node(currentCharacter, false);
				parent.children.put(currentCharacter, child);
			} else {
				// Do nothing. Because character already exist.
			}
			this.addWord(child, restOfString); // add the rest of string to current path.
		}
	}
	
	public void displayWords(Node node, String word) {
		if(node.isTerminal) {  // A word is formed when we reach this node.
			String print = word.substring(1) + node.data;
			System.out.println("|" + print + "|");
		}
		// A node can be terminal as well as part of a path. E.g: 'there' and then 'the'
//		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
//		for(Map.Entry<Character, Node> entry : entries)
//			this.displayWords(entry.getValue(), word + node.data);
		Collection<Node> nodeSet = node.children.values();
		for(Node n : nodeSet)
			this.displayWords(n, word + node.data);
	}
	
	public void displayAsTree(Node node) {
		String word = "";
		word += node.data + " => ";
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for(Map.Entry<Character, Node> entry : entries)
			word += entry.getKey() + ", ";
		System.out.println(word + "END.");
		for(Map.Entry<Character, Node> entry : entries)
			this.displayAsTree(entry.getValue());
	}
	
	public boolean search(Node node, String word) {
		if(word.length() == 0) 
			return true;
		char currentCharacter = word.charAt(0);
		String restOfString = word.substring(1);
		Node child = node.children.get(currentCharacter);
		if(child == null) // character not found in the path. 
			return false;
		else 
			return this.search(child, restOfString);
	}
	
	public void remove(Node parent, String word) {
		if(word.length() == 0) {
			if(parent.isTerminal)
				parent.isTerminal = false;
			this.numberOfWords--;
			return;  // if else can be used to replace return statement.
		}
		char currentCharacter = word.charAt(0);
		String restOfString = word.substring(1);
		Node child = parent.children.get(currentCharacter);
		if(child != null) 
			this.remove(child, restOfString);
		if(!child.isTerminal && child.children.size() == 0)
			parent.children.remove(currentCharacter);		
	}
	
	public static void main(String... args) {
		Trie t = new Trie();
		t.addWord("art");
		t.addWord("arts");
		t.addWord("boys");
		t.addWord("bugs");
		t.displayWords(t.root, "");
		t.displayAsTree(t.root);
		System.out.println("Searching the word arts: " + t.search(t.root, "arts"));
		System.out.println("Removing art.");
		t.remove(t.root, "art");
		t.displayWords(t.root, "");
		System.out.println("Number of words: " + t.numberOfWords);
	}
}
