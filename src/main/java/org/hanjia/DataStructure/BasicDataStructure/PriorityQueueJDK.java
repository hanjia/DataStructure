package org.hanjia.DataStructure.BasicDataStructure;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueJDK {
	
	//JDK embedded PriorityQueue (implemented in heap)
	//Note: The capacity specified is just an initial value and it will be automatically increased if necessary
	public static void main(String[] args){
		int capacity = 10;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(capacity, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				if(o1 == o2){
					return 0;
				}
				return (o1 > o2)? 1: -1;
			}
		});

		queue.add(5);
		queue.add(10);
		queue.add(4);
		queue.add(2);
		queue.add(8);
		queue.add(1);
		queue.add(9);
		queue.add(7);
		queue.add(3);
		queue.add(6);
		
		while(queue.peek() != null){
			System.out.println(queue.poll());
			System.out.println(queue.toString());
		}
	}
}
