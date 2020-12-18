package org.hanjia.datastructure.basic.queue;

import org.hanjia.datastructure.basic.linkedlist.ListNode;

public class LLQueue {
	private ListNode previous;
	private ListNode next;

	private LLQueue() {
		this.previous = null;
		this.next = null;
	}

	public boolean isEmpty() {
		return (previous == null);
	}

	public void enQueue(int data) {
		ListNode newNode = new ListNode(data);
		if (next == null) {
			next = newNode;
			previous = newNode;
		} else {
			next.setNext(newNode);
			next = newNode;
		}
	}

	public int deQueue() {
		int data = -1;
		if (isEmpty()) {
			// Print an error message
		} else {
			data = previous.getValue();
			previous = previous.getNext();
		}
		return data;
	}
}
