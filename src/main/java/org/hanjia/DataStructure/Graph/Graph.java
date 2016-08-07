package org.hanjia.DataStructure.Graph;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	public final int MAX_VERTICES = 20;	
	public Vertex[] vertexArray;
	public int[][] adjacentMatrix;
	public int vertexCount;
	
	public void addVertex(String label) {
		vertexArray[vertexCount++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end) {
		adjacentMatrix[start][end] = 1;
		// To make the graph directed
		//adjacentMatrix[end][start] = 1;
	}
	
	public void showVertex(int index) {
		System.out.println(vertexArray[index].label);
	}
	
	public int getAdjacentUnvisitedVertex(int current) {
		for (int target = 0; target < vertexCount; target++) {
			if (adjacentMatrix[current][target] == 1 && vertexArray[target].visited == false)
				return target;
		}
		return -1;
	}
	
	public Set<Integer> getAdjacentVertex(int current) {
		Set<Integer> results = new HashSet<Integer>();
		for (int target = 0; target < vertexCount; target++) {
			if (adjacentMatrix[current][target] == 1)
				results.add(target);
		}
		return results;
	}
}
