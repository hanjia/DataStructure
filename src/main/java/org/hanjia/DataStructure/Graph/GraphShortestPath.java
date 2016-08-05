package org.hanjia.DataStructure.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphShortestPath extends Graph{
	
	private int[] distance;
	private int[] path;

	public void unweightedShortestPath(Graph graph, int start) {
		distance = new int[graph.vertexCount];
		path = new int[graph.vertexCount];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);						
		for (int i = 0; i < graph.vertexCount; i++) {
			distance[i] = -1;
		}
		distance[start] = 0;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			int next;
			while ((next = getAdjacentUnvisitedVertex(current)) != -1) {
				if (distance[next] != -1) {
					distance[next] = distance[current] + 1;
					path[next] = current;
					vertexArray[next].visited = true;
					queue.add(next);	
				}
			}
		}
	}
	
	public int getAdjacentUnvisitedVertex(int current) {
		for (int target = 0; target < vertexCount; target++) {
			if (adjacentMatrix[current][target] == 1 && vertexArray[target].visited == false)
				return target;
		}
		return -1;
	}
}
