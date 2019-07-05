package BreadthFirstTraversal;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;
import javax.swing.text.StyledEditorKit.ForegroundAction;


public class kDistance {
		private List<Nodet> nodesList = new ArrayList<Nodet>(); 
	    Nodet root; 
	    /* Recursive function to print all the nodes at distance k in 
	       tree (or subtree) rooted with given root. */
	    
	    
	    
	    void printPriority() {
	    	int X = this.nodesList.size();
	    	for (int i = 0; i < X; i++) {
	    		//System.out.println(nodesList.get(i).priority);
	    		findMax();
	    	}
	    }
	    	
	    void findMax() {
	    	int min = 9999999;
	    	int mini = 0;
		    for (int i = 0; i < this.nodesList.size(); i++) {
		    	if(this.nodesList.get(i).priority<=min) {
		    		min = this.nodesList.get(i).priority;
		    		mini = i;
		    	}
			}
		    	System.out.print(this.nodesList.get(mini).data+" ");
		    	this.nodesList.remove(mini);
	    }
	    
	    void printkdistanceNodeDown(Nodet node, int k)  
	    { 
	        // Base Case 
	        if (node == null || k < 0) 
	            return; 
	   
	        // If we reach a k distant node, print it 
	        if (k == 0)  
	        { 
	            //System.out.print(node.data); 
	            //System.out.print(" "); 
	            nodesList.add(node);
	            return; 
	        } 
	   
	        // Recur for left and right subtrees 
	        printkdistanceNodeDown(node.left, k - 1); 
	        printkdistanceNodeDown(node.right, k - 1); 
	    } 
	   
	    // Prints all nodes at distance k from a given target node. 
	    // The k distant nodes may be upward or downward.This function 
	    // Returns distance of root from target node, it returns -1 
	    // if target node is not present in tree rooted with root. 
	    int printkdistanceNode(Nodet root, Nodet target, int k)  
	    { 
	        // Base Case 1: If tree is empty, return -1 
	        if (root == null) 
	            return -1; 
	   
	        // If target is same as root.  Use the downward function 
	        // to print all nodes at distance k in subtree rooted with 
	        // target or root 
	        if (root == target)  
	        { 
	            printkdistanceNodeDown(root, k); 
	            return 0; 
	        } 
	   
	        // Recur for left subtree 
	        int dl = printkdistanceNode(root.left, target, k); 
	   
	        // Check if target node was found in left subtree 
	        if (dl != -1)  
	        { 
	               
	            // If root is at distance k from target, print root 
	            // Note that dl is Distance of root's left child from  
	            // target 
	            if (dl + 1 == k)  
	            { 
	                //System.out.print(root.data); 
	                //System.out.print(" "); 
	                nodesList.add(root);
	            } 
	               
	            // Else go to right subtree and print all k-dl-2 distant nodes 
	            // Note that the right child is 2 edges away from left child 
	            else
	                printkdistanceNodeDown(root.right, k - dl - 2); 
	   
	            // Add 1 to the distance and return value for parent calls 
	            return 1 + dl; 
	        } 
	   
	        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE 
	        // Note that we reach here only when node was not found in left  
	        // subtree 
	        int dr = printkdistanceNode(root.right, target, k); 
	        if (dr != -1)  
	        { 
	            if (dr + 1 == k)  
	            { 
	                //System.out.print(root.data); 
	                //System.out.print(" "); 
	                nodesList.add(root);
	            }  
	            else 
	                printkdistanceNodeDown(root.left, k - dr - 2); 
	            return 1 + dr; 
	        } 
	   
	        // If target was neither present in left nor in right subtree 
	        return -1; 
	    } 
}
