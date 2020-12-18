package org.hanjia.datastructure.basic.linkedlist;

public class ListNode {
	private int value;
	private ListNode next;

	public ListNode(int value) {
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getNext() {
		return this.next;
	}

	public int getListLength(ListNode head) {
		int length = 0;
		ListNode current = head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return length;
	}

	public ListNode insertToLinkedList(ListNode head, ListNode nodeToInsert, int position) {
		if (head == null)
			return nodeToInsert;
		int size = getListLength(head);
		if (position > size + 1 || position < 1) {
			// print an error message
			return head;
		}

		if (position == 1) {
			nodeToInsert.setNext(head);
			return nodeToInsert;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position - 1) {
				previous = previous.getNext();
				count++;
			}
			ListNode current = previous.getNext();
			nodeToInsert.setNext(current);
			previous.setNext(nodeToInsert); // 循环停在插入前节点,先连新节点与后面的节点,再连前面的节点与新节点
		}
		return head;
	}

	public ListNode deleteNodeFromLinkedList(ListNode head, int position) {
		int size = getListLength(head);
		if (position > size || position < 1) {
			//print an error message
			return head;
		}
		
		if (position == 1) {
			ListNode current = head.getNext();
			head = null;
			return current;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position) {
				previous = previous.getNext();
				count++;
			}
			ListNode current = previous.getNext(); //循环停在插入前节点,先连前面的节点与后面的节点,再断开需要删除节点
			previous.setNext(current.getNext());
			current = null;
		}
		return head;
	}
}
