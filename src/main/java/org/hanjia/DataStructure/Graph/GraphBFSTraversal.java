package org.hanjia.DataStructure.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSTraversal extends Graph {
	
	private Queue<Integer> queue;
	
	public GraphBFSTraversal() {
		vertexArray = new Vertex[MAX_VERTICES];
		adjacentMatrix = new int[MAX_VERTICES][MAX_VERTICES];
		vertexCount = 0;
		queue = new LinkedList<Integer>();
	}
	
	public void addVertex(String label) {
		vertexArray[vertexCount++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end) {
		adjacentMatrix[start][end] = 1;
		adjacentMatrix[end][start] = 1;
	}
	
	public void showVertex(int index) {
		System.out.println(vertexArray[index].label);
	}
	
	public void bfs() {
		vertexArray[0].visited = true;
		showVertex(0);
		queue.add(0);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			int next;
			while ((next = getAdjacentUnvisitedVertex(current)) != -1) {
				vertexArray[next].visited = true;
				showVertex(next);
				queue.add(next);
			}
		}
		
		for (int i = 0; i < vertexCount; i++) { // reset flags
			vertexArray[i].visited = false;
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
