package binarySearchTree;

public class Node {
	Node root;
	Node left;
	Node right;
	int key;
	
	public Node() {
		root = null;
	}
	public Node(int dataInt) {
		key = dataInt;
		left=right=null;
	}
	public Node(int dataInt, Node left, Node right) {
		key = dataInt;
		this.left = left;
		this.right = right;
	}
	void insert(int key) { 
	       root = insertRec(root, key); 
	    } 
	      
	    /* A recursive function to insert a new key in BST */
	    Node insertRec(Node root, int key) { 
	  
	        /* If the tree is empty, return a new node */
	        if (root == null) { 
	            root = new Node(key); 
	            return root; 
	        } 
	  
	        /* Otherwise, recur down the tree */
	        if (key < root.key) 
	            root.left = insertRec(root.left, key); 
	        else if (key > root.key) 
	            root.right = insertRec(root.right, key); 
	  
	        /* return the (unchanged) node pointer */
	        return root; 
	    } 
	  
	    // This method mainly calls InorderRec() 
	    void inorder()  { 
	       inorderRec(root); 
	    } 
	  
	    // A utility function to do inorder traversal of BST 
	    void inorderRec(Node root) { 
	        if (root != null) { 
	            inorderRec(root.left); 
	            System.out.println(root.key); 
	            inorderRec(root.right); 
	        } 
	    } 
	  
	
}
