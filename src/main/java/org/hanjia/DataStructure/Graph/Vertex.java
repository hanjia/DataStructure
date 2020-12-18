package org.hanjia.datastructure.graph;

public class Vertex {
	public String label;
	public boolean visited;

	public Vertex() {
		
	}
	
	public Vertex(String label) {
		this.label = label;
	}

	public int distance;
	public int index;
}
