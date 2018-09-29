
package graph_implementation;

import java.util.*;

/**
 *
 * @author Damsara
 */
public class Graph {
      private LinkedList<Integer> graph[];
      private int numberOfVertices;

    public Graph(int noOfVertices) {
        this.numberOfVertices=noOfVertices;
        graph= new LinkedList[noOfVertices];
        
        for(int i=0; i<noOfVertices;i++){
            graph[i]=new LinkedList<>();
        
        }
                
    }
    
    void addEdge(int from, int to){
        graph[from].add(to);
         
    }
    
     
    void printGraph(){
        /*
            * This function displays all the vertices in the graph and its connections(edges)
        */
        
        for(int i=0; i<numberOfVertices; i++){
            if(graph[i].size()<0){
                System.out.println("");
            
            }else{
                System.out.print("Vertex " + i + " is connected to : ");
                for(int j=0;j<graph[i].size();j++){
                    System.out.print(graph[i].get(j)+ " ");
                
                }
                System.out.println("");
            
            }
        
        }
        
              
    }
    
    void bfs(int s){
        /*
            * Breadth First Search function
        */
        
        System.out.print(" \nBreadth First Search result of this graph is : ");      
        
        boolean visited[]= new boolean[this.numberOfVertices];       // Boolean array has elements equal to no of vertices
        LinkedList<Integer> queue=new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);
        
        while(queue.size()!=0){
            s= queue.poll();
            System.out.print(s+" ");
            
            Iterator<Integer> i= graph[s].iterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                
                }
            }
        }
        
        System.out.println("");
    }
    
    
    void dfsBase(int v, boolean visited[]){
        /*
            * Depth First Search base function
        */
        
        visited[v]=true;
        System.out.print(v +" ");
        
        Iterator<Integer> i= graph[v].iterator();
        
        while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    dfsBase(n, visited);
                }
            }
    }
    
    void dfs(int v){
        /*
            * Depth First Search function
        */
        
        boolean visited[]=new boolean[this.numberOfVertices];    // Boolean array has elements equal to no of vertices
        dfsBase(v, visited);
    
    }

    
   public static void main(String[] args) {
       
        Scanner s1= new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int noOfVertices= s1.nextInt();     // Gets the no of vertices for the graph from the user
        Graph g = new Graph(noOfVertices);
        
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
        
        
        
//        g.printGraph();
//        
//        g.bfs(1);
//        g.dfs(1);
        
        int to,from,i=1;
        
        while(i!=0){
            System.out.println("Enter 1 to insert an edge ");
            System.out.println("Enter 2 to display the graph ");
            System.out.println("Enter 3 to perform BFS ");
            System.out.println("Enter 4 to perform DFS ");
            System.out.println("Enter 0 to exit \n");
            i=s1.nextInt();
            //System.out.println(i);
            
            switch(i){
                case 1:
                    System.out.println("\nEnter the source of the vertex : ");
                    from= s1.nextInt();
                    System.out.println("\nEnter the destination of the vertices : ");
                    to=s1.nextInt();
                    g.addEdge(from, to);
                    break;
                
                case 2:
                    g.printGraph();
                    System.out.println(" ");
                    break;
                   
                case 3:
                    System.out.println("\nOutput of BFS of the graph is: ");
                    g.bfs(1);
                    break;
                    
                case 0:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("\nEnter a valid option");
                    break;
                    
            }
            
            
            
        }
   
                      
         
    }
    
}
