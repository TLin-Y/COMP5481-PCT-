package binarySearchTree;

import java.util.ArrayList;

public class BSTBuilder {
	
	private int smallInt;
	private int middleInt;
	private int bigInt;
	private ArrayList<Integer> intList;
	
	public void lineToInt(String line) {
		String arrayIntp[] = line.split("\\s+");
		for (int i = 0; i < arrayIntp.length; i++) {
			int INT = Integer.parseInt(arrayIntp[i]);
			intList.add(INT);
			}
		}
	public Node search(Node root, int key) 
	{ 
	    // Base Cases: root is null or key is present at root 
	    if (root==null || root.key==key) 
	        return root; 
	  
	    // val is greater than root's key 
	    if (root.key > key) 
	        return search(root.left, key); 
	  
	    // val is less than root's key 
	    return search(root.right, key); 
	} 

}
