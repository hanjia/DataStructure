package org.hanjia.datastructure.basic.queue;

public class ArrayQueue {
	private int front;
	private int rear;
	private int capacity;
	private int[] array;

	public ArrayQueue(int size) {
		capacity = size;
		front = -1;
		rear = -1;
		array = new int[size];
	}

	public boolean isEmpty() {
		return (front == -1);
	}

	public boolean isFull() {
		return ((rear + 1) % capacity == front);
	}

	public int getQueueSize() {
		return ((capacity - front + rear + 1) % capacity);
	}

	public void enQueue(int data) {
		if (isFull()) {
			// Print an error message
		} else {
			rear = (rear + 1) % capacity;
			array[rear] = data;
			if (front == -1)
				front = rear;
		}
	}

	public int deQueue() {
		int data = -1;
		if (isEmpty()) {
			// Print an error message
		} else {
			data = array[front];
			if (front == rear)
				front = rear - 1;
			else
				front = (front + 1) % capacity;
		}
		return data;
	}

	public void resizeQueue() {
		int initCapacity = capacity;
		capacity *= 2;
		int[] oldArray = array;
		array = new int[this.capacity];
		for (int i = 0; i < oldArray.length; i++) {
			array[i] = oldArray[i];
		}
		if (rear < front) { // To handle circular situation
			for (int i = 0; i < front; i++) {
				array[i + initCapacity] = this.array[i];
				array[i] = -1;
			}
			rear = rear + initCapacity;
		}
	}
}
