package trees;

public class BinarySearchTrees {
   // Data field.
   private Node root;
   private int size;
   
   // Constructor.
   public BinarySearchTrees() {
	   this.root = null;
	   this.size = 0;
   }
   // Methods.   
   
   /**
    * 
    * @param node
    * @return
    */
   private Node maxNode(Node node) {
	   if(node.right == null)
		   return node;
	   return maxNode(node.right);
   }   
   /**
    * Method is visible to the client and uses another method as utility.
    * @param data
    */
   public void remove(int data) {
	   this.root = this.remove(this.root, data);
   }
   /**
    * Removing the node using a recursive method.
    * @param node
    * @param data
    * @return
    */
   private Node remove(Node node, int data) {
	   if(node == null) {
		   return null;
	   }
	   if(data < node.data) {
		   node.left = this.remove(node.left, data);
		   return node;	   
	   }
	   if(data > node.data) {
		   node.right = this.remove(node.right, data);
	   }
	   else {
		   if(node.left == null && node.right == null) {
			   this.size--;
			   return null;
		   }
		   else if(node.left == null) {
			   this.size--;
			   return node.right;
		   }
		   else if(node.right == null) {
			   this.size--;
			   return node.left;
		   }
		   else {
			   Node maxNode = maxNode(node.left);
			   node.data = maxNode.data;
			   this.remove(node.left, maxNode.data);
			   return node;
		   }
	   }
	return null;	   
   }
   /**
    * Public method for adding the nodes in the tree.
    * @param data
    */
   public void add(int data) {
	   if(root == null) {  // First node in tree.
		   root = new Node(data, null, null);
	   }
	   else {   // Construct the BST.
		   Node parent = null;  // find the parent of the new node.
		   Node temp = root;
		   while(temp != null) {
			   parent = temp;
			   if(data < temp.data) 
				   temp = temp.left;			   
			   else if(data >= temp.data) 
				   temp = temp.right;			  
		   }
		   if(data >= parent.data)
			   parent.right = new Node(data, null, null);
		   else
			   parent.left = new Node(data, null, null);		   
	   }
	   this.size++;
   }
   /**
    * Returning the number of nodes in the tree.
    * @return
    */
   public int getSize() {
	   return this.size;
   }
   /**
    * Client visible method for calculating the height of the tree.
    * @return
    */
   public int getHeight() {
	   return this.getHeight(root);
   }
   /**
    * Calculates the height of the tree recursively.
    * @param node
    * @return
    */
   private int getHeight(Node node) {
	   if(node == null)   // Empty tree. 
		   return -1;
	   int h1 = getHeight(node.left); 
	   int h2 = getHeight(node.right);		  	
	   return 1 + Math.max(h1, h2); 
   }
   /**
    * Client visible method.
    */
   public void display() {
	   this.display(root);
   }
   /**
    * Displaying the tree recursively.
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
}  // End of class.
