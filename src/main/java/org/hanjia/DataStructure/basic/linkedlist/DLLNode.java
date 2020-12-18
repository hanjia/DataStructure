package org.hanjia.datastructure.basic.linkedlist;

public class DLLNode {
	private int value;
	private DLLNode next;
	private DLLNode previous;

	public DLLNode(int value) {
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getNext() {
		return this.next;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}

	public DLLNode getPrevious() {
		return this.previous;
	}
	
	public int getDLLLength(DLLNode head) {
		int length = 0;
		DLLNode current = head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return length;
	}
	
	public DLLNode insertToDLL(DLLNode head, DLLNode nodeToInsert, int position) {
		if (head == null)	return nodeToInsert;
		int size = getDLLLength(head);
		if (position > size + 1 || position < 1) {
			//print an error message
			return head;
		}

		if (position == 1) {
			nodeToInsert.setNext(head);
			head.setPrevious(nodeToInsert);
			return nodeToInsert;
		} else {
			DLLNode previous = head;
			int count = 1;
			while (count < position - 1) {
				previous = previous.getNext();
				count++;
			}
			DLLNode current = previous.getNext();
			nodeToInsert.setNext(current);
			if(current != null) current.setPrevious(nodeToInsert);

			previous.setNext(nodeToInsert);   	
		      nodeToInsert.setPrevious(previous); //先连新节点与后面的节点(双向),再连前面的节点与新节点(双向）
		}
		return head;
	}
	
	public DLLNode deleteFromDLL(DLLNode head, int position) {
		int size = getDLLLength(head);
		if (position > size || position < 1) {
			//print an error message
			return head;
		}
		
		if (position == 1) {
			DLLNode current = head.getNext();
			head = null;
			current.setPrevious(null);
			return current;
		} else {
			DLLNode previous = head;
			int count = 1;
			while (count < position - 1) {
				previous = previous.getNext();
				count++;
			}
			DLLNode current = previous.getNext(); //先将前面节点的后指针指向后面节点,再将后面节点的前指针指向前节点
			previous.setNext(current.getNext());
			if (current.getNext() != null) {
				current.getNext().setPrevious(previous);
			}
	            current = null;
		}
		return head;
	}
}
