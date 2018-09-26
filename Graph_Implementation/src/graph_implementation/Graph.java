/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        System.out.print(" \nBreadth First Search result of this graph is : ");
        
        boolean visited[]= new boolean[6];
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
        boolean visited[]=new boolean[6];
        dfsBase(v, visited);
    
    }

    
   public static void main(String[] args) {
       
        Scanner s1= new Scanner(System.in);
//        System.out.println("Enter the number of vertices : ");
//        int noOfVertices= s1.nextInt();
        Graph g = new Graph(5);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        
        
        g.printGraph();
        
        //g.bfs(1);
        g.dfs(1);
        
        int to,from,i=1;
        
//        while(i!=0){
//            System.out.println("Enter 1 to insert a vertex ");
//            System.out.println("Enter 0 to exit ");
//            i=s1.nextInt();
//            System.out.println(i);
//            if(i==0){
//                g.printGraph();
//                System.exit(0);
//            }else{
//                System.out.println("Enter the source of the vertex : ");
//                from= s1.nextInt();
//                System.out.println("Enter the destination of the vertices : ");
//                to=s1.nextInt();
//                g.addEdge(from, to);
//            
//            }
//            
//            
//        }
   
                      
         
    }
    
}
