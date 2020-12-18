package org.hanjia.datastructure.basic.priorityqueue;

import java.util.Arrays;

public class Heap {
	public int[] array;
	public int count;
	public int capacity;
	public String heap_type;
	
	public Heap(int capacity, String heap_type){
		this.heap_type = heap_type;
		this.count = 0;
		this.capacity = capacity;
		this.array = new int[capacity];
	}
	
	public int parent(int i){
		if(i <= 0 || i >= this.count)	
			return -1;
		return (i - 1)/2;
	}

	public int getLeftChild(int i){
		int left = 2 * i + 1;
		if(left >= this.count){
			return -1;
		}
		return left;
	}
	
	public int getRightChild(int i){
		int left = 2 * i + 2;
		if(left >= this.count){
			return -1;
		}
		return left;
	}
		
	public int getMaximum(){
		if(this.count == 0)	
			return -1;
		return this.array[0];
	}
	
	public int deleteMax(){
		if(this.count ==0)	return -1;
		int data = this.array[0];
		//Copy last element into first element location 
		this.array[0] = this.array[this.count - 1]; 
		this.count--;
		siftDown(0);
		return data;
	}
	
	
	
	public void siftDown(int i){
		int leftIndex,rightIndex;
		int temp,max;
		leftIndex = getLeftChild(i);
		rightIndex = getRightChild(i);
		
		if(leftIndex != -1 && this.array[leftIndex] > this.array[i]){	
			max = leftIndex;
		}else{
			max = i;
		}
		
		if(rightIndex != -1 && this.array[rightIndex] > this.array[max]){
			max = rightIndex;
		}

		if(max != i){
			temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
			siftDown(max); //Recursive
		}		
	}

	
	
	public int insert(int data){
		int i = 0;
		if(this.count == this.capacity)		
			resizeHeap();
		this.count++;
		i = this.count - 1;
		while (i > 0 && data > this.array[(i-1)/2]){ //Bottom up
			this.array[i] = this.array[(i-1)/2];
			i = (i - 1) / 2;
		}
		this.array[i] = data;
		return i;
	}

	public void resizeHeap(){
		int[] oldArray = new int[this.capacity];
		System.arraycopy(this.array, 0, oldArray, 0, this.count);
		this.array = new int[this.capacity * 2];
		if(this.array == null){
			return;
		}
		for(int i = 0; i < this.capacity; i++){
			this.array[i] = oldArray[i];
		}
		this.capacity *= 2;
		oldArray = null;
	}
	
	
	public void buildHeap(Heap h, int A[], int n){ //n is the length of the array
		if(h == null)	return;
		while(n > this.capacity){
			h.resizeHeap();
		}
		for(int i = 0; i < n; i++){
			h.array[i] = A[i];
		}
		this.count = n;
		for(int i = (n-1)/2; i >= 0; i--){ 
			//(count - 1)/2 is the location for parent of the last element
			h.siftDown(i);
		}
	}
	
	
	
	public static void main(String[] args){
		Heap heap = new Heap(10, "Max");
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		heap.buildHeap(heap, array, 10);
		System.out.println(Arrays.toString(heap.array));
		heap.deleteMax();
		System.out.println(Arrays.toString(heap.array));
		heap.insert(10);
		System.out.println(Arrays.toString(heap.array));
		heap.insert(0);
		System.out.println(Arrays.toString(heap.array));
	}
}
