/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_implementation;

import java.util.LinkedList;

/**
 *
 * @author Damsara
 */
public class Graph {
    
    private LinkedList<Integer> graph[];
    private int numberOfVertices;

    public Graph(int noOfVertices) {
        
        this.numberOfVertices=noOfVertices;
        graph = new LinkedList[this.numberOfVertices];
        
        for(int i=0; i<numberOfVertices; i++){
            graph[i]=new LinkedList();
        
        }
    }
    
    void addEdge(int from, int to){
        graph[from].add(to);
    }

    public static void main(String[] args) {
        
        Graph g= new Graph(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        
          
    }
    
}
