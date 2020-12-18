package org.hanjia.datastructure.graph;

import java.util.Stack;

public class GraphDFSTraversal extends Graph {
	
	private Stack<Integer> stack;
	
	public GraphDFSTraversal() {
		vertexArray = new Vertex[MAX_VERTICES];
		adjacentMatrix = new int[MAX_VERTICES][MAX_VERTICES];
		vertexCount = 0;
		stack = new Stack<Integer>();
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
	
	public static void main(String[] args) {
		GraphDFSTraversal traversal = new GraphDFSTraversal();
		traversal.addVertex("1");
		traversal.addVertex("2");
		traversal.addVertex("3");
		traversal.addVertex("4");
		traversal.addVertex("5");
		traversal.addEdge(0, 1);
		traversal.addEdge(0, 2);
		traversal.addEdge(0, 3);
		traversal.addEdge(0, 4);
		traversal.addEdge(1, 2);
		traversal.addEdge(1, 4);		
		traversal.dfs();	
	}
}
