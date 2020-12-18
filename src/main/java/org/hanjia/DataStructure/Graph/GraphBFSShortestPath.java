package org.hanjia.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Using BFS for graph with unweighted paths
 * 
 * @author hanjia
 *
 */
public class GraphBFSShortestPath extends Graph{

	public GraphBFSShortestPath() {
		vertexArray = new Vertex[MAX_VERTICES];
		adjacentMatrix = new int[MAX_VERTICES][MAX_VERTICES];
		vertexCount = 0;
	}
	
	public int[] unweightedShortestPath(Graph graph, int start) {
		int[] distance = new int[graph.vertexCount];
		int[] path = new int[graph.vertexCount];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);						
		for (int i = 0; i < graph.vertexCount; i++) {
			distance[i] = -1;
		}
		distance[start] = 0;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next: getAdjacentVertex(current)) {
				if (distance[next] == -1) { // To make sure each vertex will only be examined once
					distance[next] = distance[current] + 1;
					path[next] = current;
					queue.add(next);	
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) {
		GraphBFSShortestPath shortestPath = new GraphBFSShortestPath();
		shortestPath.addVertex("A");
		shortestPath.addVertex("B");
		shortestPath.addVertex("C");
		shortestPath.addVertex("D");
		shortestPath.addVertex("E");
		shortestPath.addVertex("F");
		shortestPath.addVertex("G");

		shortestPath.addEdge(0, 1);
		shortestPath.addEdge(0, 3);
		shortestPath.addEdge(1, 3);
		shortestPath.addEdge(1, 4);
		shortestPath.addEdge(2, 0);
		shortestPath.addEdge(2, 5);
		shortestPath.addEdge(3, 5);
		shortestPath.addEdge(3, 6);
		shortestPath.addEdge(4, 6);
		shortestPath.addEdge(6, 5);	
		System.out.println(Arrays.toString(shortestPath.unweightedShortestPath(shortestPath, 2)));	
	}

}
