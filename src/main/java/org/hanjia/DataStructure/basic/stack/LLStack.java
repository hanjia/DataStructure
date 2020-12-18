package org.hanjia.datastructure.basic.stack;

import org.hanjia.datastructure.basic.linkedlist.ListNode;

public class LLStack {
	private ListNode head;

	public LLStack() {
		this.head = null;
	}

	public void push(int data) {
		if (head == null) {
			head = new ListNode(data);
		} else if (head.getValue() == 0) {
			head.setValue(data);
		} else {
			ListNode current = new ListNode(data);
			current.setNext(head);
			head = current;
		}
	}

	public int top() {
		if (head == null)
			throw new RuntimeException("The stack is empty");
		else
			return head.getValue();
	}

	public int pop() {
		if (head == null) {
			throw new RuntimeException("The stack is empty");
		} else {
			int data = head.getValue();
			head = head.getNext();
			return data;
		}
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public void deleteStack() {
		head = null;
	}
}