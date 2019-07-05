package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.html.ListView;

public class discG {

	public static void main(String[] arg) {
		Scanner inputScanner = new Scanner(System.in);
		int vertices = inputScanner.nextInt();
		int edges = inputScanner.nextInt();
		if (vertices ==1) {
			System.out.println(1 + " " + 1);
		}else {
		graph g = new graph(vertices);
		int e = edges;
		for (int i = 1; i <= e; i++)
        {
			int v1 = inputScanner.nextInt();
            int v2 = inputScanner.nextInt();
            g.addEdge(g, v1, v2);
        }
        inputScanner.close();
		
		//System.out.println("\nAdd all info finished!");
		//g.printGraph(g);
		g.connectedComponents();
		int connected;
		int count=0;
		if (g.count >= 1) {
			connected = 0;
			count = g.count;
		}else {
			connected = 1;
			count = 0;
		}
		System.out.println(connected + " " + count);
		}
	}

}
