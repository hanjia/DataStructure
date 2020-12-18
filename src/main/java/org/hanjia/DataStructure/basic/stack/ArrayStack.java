package org.hanjia.datastructure.basic.stack;

public class ArrayStack {
	private int top;
	private int capacity;
	private int[] array;

	public ArrayStack() {
		capacity = 1;
		array = new int[capacity];
		top = -1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isStackFull() {
		return (top == capacity - 1);
	}

	public void push(int data) {
		if (isStackFull())
			System.out.println("The stack is overflow");
		else
			array[++top] = data;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("The stack is empty");
			return 0;
		} else {
			return array[top--];
		}
	}

	public void deleteStack() {
		top = -1;
	}
}