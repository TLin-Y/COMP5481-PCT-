package BreadthFirstTraversal;

import java.util.Scanner;


public class Tree {
public static void main(String args[]) 
 { 
	Scanner inputLine = new Scanner(System.in);
	//System.out.println("Enter the binary tree:");
	
	String firstLine = inputLine.nextLine();
	firstLine = firstLine.replaceAll(" ","");
	String secondLine = inputLine.nextLine();
	int k = inputLine.nextInt();
	
//Binary Tree constructor
	StringToTree temp = new StringToTree();	
	Nodet rootNode = temp.str2tree(firstLine);	//BigO(n)
	Nodet targetNode = rootNode.search(rootNode,secondLine); //BigO(n)
	
//Output level first search order
	LevelFirstTree tree = new LevelFirstTree();  
    tree.printLevelOrder(rootNode); //BigO(n)
    tree.printAll(); //BigO(1)

//Find out k Distance nodes
    kDistance kFind = new kDistance();
    kFind.printkdistanceNode(rootNode, targetNode, k); //BigO(n)
    kFind.printPriority(); //BigO(1)
 } 

}