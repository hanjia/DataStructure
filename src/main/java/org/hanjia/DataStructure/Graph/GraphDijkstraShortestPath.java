package org.hanjia.datastructure.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * Using Dijkstra's algorithm for graph with weighted paths
 * 
 * @author hanjia
 *
 */
public class GraphDijkstraShortestPath extends Graph{

	private int[][] weights;
	
	public GraphDijkstraShortestPath() {
		vertexArray = new Vertex[MAX_VERTICES];
		adjacentMatrix = new int[MAX_VERTICES][MAX_VERTICES];
		vertexCount = 0;
	}
	
	public int[] dijkstraShortestPath(Graph graph, int start) {
		int[] distance = new int[graph.vertexCount];
		int[] path = new int[graph.vertexCount];
		
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		Vertex vertex = new Vertex();
		vertex.index = 0;
		vertex.distance = 0;
		queue.add(vertex);	
		
		for (int i = 0; i < graph.vertexCount; i++) {
			distance[i] = -1;
		}
		distance[start] = 0;
		
		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			for (int next: getAdjacentVertex(current.index)) {
				int newDistance = distance[current.index] + weights[current.index][next];
				
				// TODO: fix
				if (distance[next] == -1) { // To make sure each vertex will only be examined once
					distance[next] = newDistance;
					path[next] = current.index;
					Vertex nextVertex = new Vertex();
					nextVertex.index = next;
					nextVertex.distance = newDistance;
					queue.add(nextVertex);	
				}
				
				if (distance[next] > newDistance) {
					Vertex nextVertex = new Vertex();
					nextVertex.index = next;
					nextVertex.distance = distance[next];
					queue.remove(nextVertex);

					distance[next] = newDistance;
					path[next] = current.index;
					nextVertex.distance = newDistance;
					queue.add(nextVertex);					
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) {
		GraphDijkstraShortestPath shortestPath = new GraphDijkstraShortestPath();
		shortestPath.addVertex("A");
		shortestPath.addVertex("B");
		shortestPath.addVertex("C");
		shortestPath.addVertex("D");
		shortestPath.addVertex("E");

		shortestPath.addEdge(0, 1);
		shortestPath.addEdge(0, 2);
		shortestPath.addEdge(1, 4);
		shortestPath.addEdge(2, 1);
		shortestPath.addEdge(2, 3);
		shortestPath.addEdge(3, 4);

		shortestPath.weights = new int[5][5];
		shortestPath.weights[0][1] = 4;
		shortestPath.weights[0][2] = 1;
		shortestPath.weights[1][4] = 4;
		shortestPath.weights[2][1] = 2;
		shortestPath.weights[2][3] = 4;
		shortestPath.weights[3][4] = 4;
		
		System.out.println(Arrays.toString(shortestPath.dijkstraShortestPath(shortestPath, 2)));	
	}
}
