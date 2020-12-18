package org.hanjia.datastructure.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args){
		int[] array = {2, 5, 3, 6, 8, 4, 7, 1};
		quickSort(array, 0 , 7);
		System.out.println(Arrays.toString(array));
	}
	
	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(array, start, end);
			quickSort(array, start, pivotIndex - 1); // To sort the first part
			quickSort(array, pivotIndex + 1, end); // To sort the second part
		}
	}
	
	public static int partition(int[] array, int start, int end){
		int pivot = array[start];
		int low = start + 1;
		int high = end;
		
		while (high > low) {
			while (low <= high && array[low] <= pivot) {
				low++;
			}
			while (low <= high && array[high] > pivot) {
				high--;
			}
			if (high > low) {
				int temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
		}

		while (high > start && array[high] >= pivot) {
			high--;
		}
		
		if (pivot > array[high]) {
			array[start] = array[high];
			array[high] = pivot;
			return high;
		}
		
		return start;
	}
}
