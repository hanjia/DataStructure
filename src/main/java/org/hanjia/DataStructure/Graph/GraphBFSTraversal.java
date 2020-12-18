package org.hanjia.datastructure.graph;

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

	public static void main(String[] args) {
		GraphBFSTraversal traversal = new GraphBFSTraversal();
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
		traversal.bfs();	
	}
}
