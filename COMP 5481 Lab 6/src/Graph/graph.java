package Graph;

import java.util.Dictionary;
import java.util.Iterator;
import java.util.LinkedList;

public class graph {

        private int V; //vertices
        private Dictionary<String,String> adjListArray; 
        //                  A : BCD
        private boolean[] list= new boolean[V]; ;// A- B- C- D-
        //A+ B+ C+ D+ boolean = true
        //
        public int count = 0;
        
        // constructor  
        graph(int V) 
        { 
            this.V = V; 
              
            // define the size of array as  
            // number of vertices 
            adjListArray = new LinkedList[V]; 
              
            // Create a new list for each vertex 
            // such that adjacent nodes can be stored 
            for(int i = 0; i < V ; i++){ 
                adjListArray[i] = new LinkedList<>(); 
            } 
        } 
     
      
    // Adds an edge to an undirected graph 
    public void addEdge(graph graph, int src, int dest) 
    { 
        // Add an edge from src to dest.  
        graph.adjListArray[src].add(dest); 
          
        // Since graph is undirected, add an edge from dest 
        // to src also 
        graph.adjListArray[dest].add(src); 
    } 
       
    // A utility function to print the adjacency list  
    // representation of graph 
    public void printGraph(graph graph) 
    {        
        for(int v = 0; v < graph.V; v++) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for(Integer pCrawl: graph.adjListArray[v]){ 
                System.out.print(" -> "+pCrawl); 
            } 
            System.out.println("\n"); 
        } 
    }
    
    // A function used by DFS 
    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        //System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adjListArray[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as false by default in java) 
        boolean visited[] = new boolean[V]; 
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 
    
    void connectedComponents() { 
        // Mark all the vertices as not visited 
        boolean[] visited = new boolean[V]; 
        for(int v = 0; v < V; ++v) { 
            if(!visited[v]) { 
                // print all reachable vertices 
                // from v 
                DFSUtil(v,visited); 
                //System.out.println(); 
                count++;
            } 
        } 
        //System.out.println("Count = "+count);
    }
}
