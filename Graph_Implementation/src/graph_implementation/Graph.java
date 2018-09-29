
package graph_implementation;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Damsara
 */
public class Graph {
      private LinkedList<Integer> graph[];
      public StringBuilder sbdfs = new StringBuilder();
      

    public Graph() {
//        graph= new LinkedList[20];        
//        for(int i=0; i<20;i++){
//            graph[i]=new LinkedList<>();
//        
//        }
    }
      private int numberOfVertices;

    public void createGraph(int noOfVertices) {
        this.numberOfVertices=noOfVertices;
        graph= new LinkedList[noOfVertices];
        
        for(int i=0; i<noOfVertices;i++){
            graph[i]=new LinkedList<>();
        
        }
                
    }
    
    public void addEdge(int from, int to){
        graph[from].add(to);
         
    }
    
     
    public void printGraph(){
        /*
            * This function displays all the vertices in the graph and its connections(edges)
        */
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numberOfVertices; i++){
            if(graph[i].size()<0){
                System.out.println("");
            
            }else{
                System.out.print("Vertex " + i + " is connected to : ");
                for(int j=0;j<graph[i].size();j++){
                    System.out.print(graph[i].get(j)+ " ");
                    sb.append(i).append(" ").append("-->").append(" ").append(graph[i].get(j)).append("\n");
                
                }
                System.out.println("");
            
            }
        
        }
        
        //String out = sb.substring(0, sb.length() - 1);
        JOptionPane.showMessageDialog(null, sb);  
    }
    
    public void bfs(int s){
        /*
            * Breadth First Search function
        */
        
        System.out.print(" \nBreadth First Search result of this graph is : ");      
        
        StringBuilder sb = new StringBuilder();
        sb.append("Start ");
        
        boolean visited[]= new boolean[this.numberOfVertices];       // Boolean array has elements equal to no of vertices
        LinkedList<Integer> queue=new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);
        
        while(queue.size()!=0){
            s= queue.poll();
            System.out.print(s+" ");
            sb.append("--> ").append(s).append(" ");
            
            Iterator<Integer> i= graph[s].iterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                
                }
            }
        }
        JOptionPane.showMessageDialog(null, sb);
        System.out.println("");
    }
    
    
    public void dfsBase(int v, boolean visited[]){
        /*
            * Depth First Search base function
        */
        
        
        
        visited[v]=true;
        System.out.print(v +" ");
        sbdfs.append("--> ").append(v).append(" ");
        
        Iterator<Integer> i= graph[v].iterator();
        
        while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    dfsBase(n, visited);
                }
            }
        
        
    }
    
    public void dfs(int v){
        /*
            * Depth First Search function
        */
        
        System.out.print(" \nDepth First Search result of this graph is : ");
        sbdfs.append("Start ");
        boolean visited[]=new boolean[this.numberOfVertices];    // Boolean array has elements equal to no of vertices
        dfsBase(v, visited);
        JOptionPane.showMessageDialog(null, sbdfs);
    
    }

    
   public static void main(String[] args) {
       
        Scanner s1= new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int noOfVertices= s1.nextInt();     // Gets the no of vertices for the graph from the user
        Graph g = new Graph();
        g.createGraph(noOfVertices);
        
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
                    
                case 4:
                    System.out.println("\nOutput of DFS of the graph is: ");
                    g.dfs(1);
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
