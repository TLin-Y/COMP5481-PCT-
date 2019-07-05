package BreadthFirstTraversal;
import java.lang.String;
public class LevelFirstTree {

	 // Root of the Binary Tree 
	 Nodet root; 
	 int p;
	 private String outPut = new String();
	 
	 public LevelFirstTree() 
	 { 
	     root = null; 
	 } 

	 /* function to print level order traversal of tree*/
	 void printLevelOrder(Nodet root) 
	 { 
	     int h = height(root); 
	     int i; 
	     for (i=1; i<=h; i++) 
	         printGivenLevel(root, i); 
	 } 

	 /* Compute the "height" of a tree -- the number of 
	 nodes along the longest path from the root node 
	 down to the farthest leaf node.*/
	 int height(Nodet root) 
	 { 
	     if (root == null) 
	        return 0; 
	     else
	     { 
	         /* compute  height of each subtree */
	         int lheight = height(root.left); 
	         int rheight = height(root.right); 
	           
	         /* use the larger one */
	         if (lheight > rheight) 
	             return(lheight+1); 
	         else return(rheight+1);  
	     } 
	 } 

	 /* Print nodes at the given level */
	 void printGivenLevel (Nodet root ,int level) 
	 { 
		 p++;
	     if (root == null) 
	         return; 
	     if (level == 1) {
	    	 root.setPri(root, p);
	    	 
	    	 if (root.data.length()==0) {
	    		 return;
			}else {
				outPut += root.data+" ";
			}
	    	 
	         //System.out.print(root.data+" "); 
	    	 }
	         else if (level > 1) 
	     { 
	         printGivenLevel(root.left, level-1); 
	         printGivenLevel(root.right, level-1); 
	     } 
	 } 
	 void printAll() {

		 System.out.print(outPut);
	 }
}
