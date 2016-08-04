package org.hanjia.DataStructure.Graph;

import java.util.Stack;

public class GraphDFSTraversal {
	private final int MAX_VERTICES = 20;
	
	private Vertex[] vertexArray;
	private int[][] adjacentMatrix;
	private int vertexCount;
	private Stack<Integer> stack;
	
	public GraphDFSTraversal() {
		vertexArray = new Vertex[MAX_VERTICES];
		adjacentMatrix = new int[MAX_VERTICES][MAX_VERTICES];
		vertexCount = 0;
		stack = new Stack<Integer>();
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
	
	public void dfs() {
		vertexArray[0].visited = true;
		showVertex(0);
		stack.push(0);
		
		while (!stack.isEmpty()) {
			int next = getAdjacentUnvisitedVertex(stack.peek());
			if (next == -1) {
				stack.pop();
			} else {
				vertexArray[next].visited = true;
				showVertex(next);
				stack.push(next);
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
