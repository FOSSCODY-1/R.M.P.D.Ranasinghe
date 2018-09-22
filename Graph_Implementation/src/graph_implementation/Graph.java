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

    
   public static void main(String[] args) {
       
        Scanner s1= new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int noOfVertices= s1.nextInt();
        Graph g = new Graph(noOfVertices);
        
        int to,from;
   
        
        for(int i=0; i<noOfVertices;i++){
            System.out.println("Enter the source of the vertex : ");
            from= s1.nextInt();
            System.out.println("Enter the destination of the vertices : ");
            to=s1.nextInt();
            g.addEdge(from, to);
        }
              
         g.printGraph();
    }
    
}
