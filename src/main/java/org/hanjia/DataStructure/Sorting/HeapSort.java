package org.hanjia.datastructure.sorting;


/**
 * 
 * procedure heapsort(a, count) is
    input: an unordered array a of length count
 
    (Build the heap in array a so that largest value is at the root)
    heapify(a, count)

    (The following loop maintains the invariants that a[0:end] is a heap and every element
     beyond end is greater than everything before it (so a[end:count] is in sorted order))
    end ← count - 1
    while end > 0 do
        (a[0] is the root and largest value. The swap moves it in front of the sorted elements.)
        swap(a[end], a[0])
        (the heap size is reduced by one)
        end ← end - 1
        (the swap ruined the heap property, so restore it)
        siftDown(a, 0, end)          
 * 
 * 
 * (Put elements of 'a' in heap order, in-place)
 * procedure heapify(a, count) is
    (start is assigned the index in 'a' of the last parent node)
    (the last element in a 0-based array is at index count-1; find the parent of that element)
    start ← floor ((count - 2) / 2)
    
    while start ≥ 0 do
        (sift down the node at index 'start' to the proper place such that all nodes below
         the start index are in heap order)
        siftDown(a, start, count - 1)
        (go to the next parent node)
        start ← start - 1
    (after sifting down the root all nodes/elements are in heap order)
 *
 *
 * (Repair the heap whose root element is at index 'start', assuming the heaps rooted at its children are valid)
 * procedure siftDown(a, start, end) is
    root ← start

    while root * 2 + 1 ≤ end do    (While the root has at least one child)
        child ← root * 2 + 1       (Left child)
        swap ← root                (Keeps track of child to swap with)

        if a[swap] < a[child]
            swap ← child
        (If there is a right child and that child is greater)
        if child+1 ≤ end and a[swap] < a[child+1]
            swap ← child + 1
        if swap = root
            (The root holds the largest element. Since we assume the heaps rooted at the
             children are valid, this means that we are done.)
            return
        else
            swap(a[root], a[swap])
            root ← swap            (repeat to continue sifting down the child now)
 * 
 * 
 * @author hajia
 *
 */
public class HeapSort {
	static int N;
	
	public static void main(String[] args){
		int[] array = {2, 5, 3, 8, 4, 7, 1, 6};
		//heapSort(array, array.length);
		heapSort(array);
		for(int element: array){
			System.out.print(element + ",");
		}
	}
	
	public static void heapSort(int[] array){
		for(int i = 1; i < array.length; i++){
			makeHeap(array,i);
		}

		for(int last = array.length - 1; last > 0; ){
			int temp = array[last];
			array[last] = array[0];
			array[0] = temp;
			rebuildHeap(array, --last);
		}
	}
	
	public static void makeHeap(int[] array, int k){
		int current = k;
		while(current > 0 && array[current] > array[(current - 1)/2]){
			int temp = array[current];
			array[current] = array[(current - 1)/2];
			array[(current - 1)/2] = temp;
			current = (current - 1)/2;
		}
	}
	
	public static void rebuildHeap(int[] array, int last){
		int current = 0;

		while (true) {
			int left = 2 * current + 1;
			int right = 2 * current + 2;
			int max = current;
			if (left <= last && array[max] < array[left]) {
				max = left;
			}
			if (right <= last && array[max] < array[right]) {
				max = right;
			}

			if (max != current) {
				int temp = array[max];
				array[max] = array[current];
				array[current] = temp;
				current = max;
			} else {
				break;
			}
		}
	}
	
	/**
	public static void heapSort(int arr[])
    {       
        heapify(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    } 
	
	// Function to build a heap   
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
    
    // Function to swap largest element in heap         
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }   
    
    // Function to swap two numbers in an array
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }
    **/

//	public static int[] heapSort(int[] A, int n){
//		Heap h = new Heap(n,0);
//		int oldSize, i;
//		h.buildHeap(h, A, n);
//		
//		oldSize = h.count;
//		for(i = n-1; i > 0; i--){
//			int temp = h.array[0];
//			h.array[0] = h.array[i];
//			h.array[i] = temp;
//			h.count--;
//			h.siftDown(0);
//		}
//		h.count = oldSize;
//		return h.array;
//	}
	
}


class Heap{
	public int[] array;
	public int count;
	public int capacity;
	public int heap_type;
	
	public Heap(int capacity, int heap_type){
		this.heap_type = heap_type;
		this.count = 0;
		this.capacity = capacity;
		this.array = new int[capacity];
	}
	
	public int parent(int i){
		if(i <= 0 || i >= this.count)	return -1;
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
		if(this.count == 0)	return -1;
		return this.array[0];
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
			//Swap
			temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
			siftDown(max); // Recursive
		}
		
	}
	
	public int deleteMax(){
		if(this.count == 0)	return -1;
		int data = this.array[0];
		// Copy last element into first element location 
		this.array[0] = this.array[this.count - 1]; 
		this.count--;
		siftDown(0);
		return data;
	}

	public int insert(int data){
		int i = 0;
		if(this.count == this.capacity)		resizeHeap();
		this.count++;
		i = this.count - 1;
		while (i >= 0 && data > this.array[(i-1)/2]){ // Bottom up
			this.array[i] = this.array[(i-1)/2];
			i = (i - 1) / 2;
		}
		this.array[i] = data;
		return i;
	}

	public void resizeHeap(){
		int[] oldArray = new int[this.capacity];
		System.arraycopy(this.array, 0, oldArray, 0, this.count - 1);
		this.array = new int[this.capacity * 2];
		if(this.array == null){
		
		}
		for(int i=0; i < this.capacity; i++){
			this.array[i] = oldArray[i];
		}
		this.capacity *= 2;
		oldArray = null;
	}

	public void buildHeap(Heap h, int A[], int n){
		if(h == null)	return;
		while(n > this.capacity){
			h.resizeHeap();
		}
		for(int i = 0; i < n; i++){
			h.array[i] = A[i];
		}
		this.count = n;
		for(int i = (n-1)/2; i >= 0; i--){ // (count - 1)/2 is the location for parent of the last element
			h.siftDown(i);
		}
	}
}