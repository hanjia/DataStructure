package org.hanjia.DataStructure.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort extends Graph{
	
	public TopologicalSort() {
		vertexArray = new Vertex[MAX_VERTICES];
		adjacentMatrix = new int[MAX_VERTICES][MAX_VERTICES];
		vertexCount = 0;
	}
	
	// DFS solution
	public void topologicalSortDFS() {
	}
	
	
	// BFS solution: the time complexity O(E + V)
	public int[] topologicalSortBFS(Graph graph) {
		int[] inDegrees = new int[]{0, 1, 1, 2, 2}; // in-degrees
		
		int[] result = new int[graph.vertexCount];
		Queue<Integer> queue = new LinkedList<Integer>();
		int counter = 0;
		for (int i = 0; i < graph.vertexCount; i++) {
			if (inDegrees[i] == 0)
				queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			result[current] = ++counter;
			showVertex(current);
			for (Integer next: getAdjacentVertex(current)) {
				if (--inDegrees[next] == 0) { // To make sure each vertex will only be examined once
					queue.add(next);
				}
			}			
		}
		
		if (counter != graph.vertexCount) {
			System.out.println("The graph has cycles");
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		TopologicalSort sort = new TopologicalSort();
		sort.addVertex("A");
		sort.addVertex("B");
		sort.addVertex("C");
		sort.addVertex("D");
		sort.addVertex("E");
		sort.addEdge(0, 1);
		sort.addEdge(0, 3);
		sort.addEdge(1, 2);
		sort.addEdge(2, 3);
		sort.addEdge(2, 4);
		sort.addEdge(3, 4);
		sort.topologicalSortBFS(sort);	
	}
	
}
