package BreadthFirstTraversal;

public class Nodet {
		 String data; 
		 int priority;
		 Nodet left, right; 
		 public Nodet(String item) 
		 { 
		     data = item; 
		     left = right = null; 
		 } 
		 public void setPri(Nodet item,int p) 
		 { 
		     item.priority = p; 
		 } 
		 
		 public Nodet search(Nodet node, String name){
			    if(node != null){
			        if(node.data.equals(name)){
			           return node;
			        } else {
			            Nodet foundNode = search(node.left, name);
			            if(foundNode == null) {
			                foundNode = search(node.right, name);
			            }
			            return foundNode;
			         }
			    } else {
			        return null;
			    }
			}
	}

