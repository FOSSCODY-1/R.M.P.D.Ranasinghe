/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_implementation;

/**
 *
 * @author Damsara
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
// class to represent a graph object
class graphtestclas
{
	// data structure to store graph edges
	static class Edge {
		int src, dest;

		Edge(int src, int dest)
		{
			this.src = src;
			this.dest = dest;
		}
	};

	// A list of lists  to represent adjacency list
	List<List<Integer>> adj = new ArrayList<>();

	// Constructor to construct graph
	public graphtestclas(List<Edge> edges)
	{
		// allocate memory for adjacency list
		for (int i = 0; i < edges.size(); i++)
			adj.add(i, new ArrayList<>());

		// add edges to the undirected graph
		for (Edge current : edges)
		{
			// allocate new node in adjacency List from src to dest
			adj.get(current.src).add(current.dest);

			// Uncomment line 38 for undirected graph
	
			// allocate new node in adjacency List from dest to src
			// adj.get(current.dest).add(current.src);
		}
	}

	// print adjacency list representation of graph
	private static void printGraph(graphtestclas graph)
	{
		int src = 0;
		int n = graph.adj.size();

		while (src < n)
		{
			// print current vertex and all its neighboring vertices
			for (int dest : graph.adj.get(src))
				System.out.print("(" + src + " --> " + dest + ")\t");

			System.out.println();
			src++;
		}
	}

	// Directed Graph Implementation in Java
	public static void main (String[] args)
	{
		// Input: List of edges in a directed graph (as per above diagram)
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), 
								new Edge(2, 0), new Edge(2, 1),new Edge(3, 2), 
								new Edge(4, 5), new Edge(5, 4));

		// construct graph from given list of edges
		graphtestclas graph = new graphtestclas(edges);

		// print adjacency list representation of the graph
		printGraph(graph);
                
                
	}
 }