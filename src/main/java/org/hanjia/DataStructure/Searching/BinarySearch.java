package org.hanjia.datastructure.searching;

public class BinarySearch {

	public int binarySearchIterative(int[] A, int n, int data) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] == data) {
				return mid;
			} else if (A[mid] < data) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public int binarySearchRecursive(int[] A, int low, int high, int data) {
		int mid = low + (high - low) / 2;
		if (A[mid] == data)
			return mid;
		else if (A[mid] < data)
			return binarySearchRecursive(A, mid + 1, high, data);
		else
			return binarySearchRecursive(A, low, mid - 1, data);
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BinarySearch bs = new BinarySearch();
		int index1 = bs.binarySearchIterative(array, array.length, 3);
		int index2 = bs.binarySearchRecursive(array, 0, array.length, 3);
		System.out.println(index1);
		System.out.println(index2);
	}
}
