package org.hanjia.DataStructure.Sorting;

public class QuickSort {
	public static void main(String[] args){
		int[] array = {2, 5, 3, 6, 8, 4, 7, 1};
		int[] sortedArray = quickSort(array, 0 , 7);
		for(int element: sortedArray){
			System.out.print(element + ",");
		}
	}
	
	public static int[] quickSort(int[] list, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(list, start, end);
			quickSort(list, start, pivotIndex - 1); // To sort the first part
			quickSort(list, pivotIndex + 1, end); // To sort the second part
		}
		return list;
	}
	
	public static int partition(int[] list, int start, int end){
		int pivot = list[start];
		int low = start + 1;
		int high = end;
		
		while (high > low) {
			while (low <= high && list[low] <= pivot) {
				low++;
			}
			while (low <= high && list[high] > pivot) {
				high--;
			}
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > start && list[high] >= pivot) {
			high--;
		}
		
		if (pivot > list[high]) {
			list[start] = list[high];
			list[high] = pivot;
			return high;
		}
		
		return start;
	}
}
