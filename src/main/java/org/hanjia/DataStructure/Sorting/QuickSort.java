package org.hanjia.DataStructure.Sorting;

public class QuickSort {
	public static void main(String[] args){
		int[] array = {2, 5, 3, 6, 8, 4, 7, 1};
		int[] sortedArray = quickSort(array, 0 , 7);
		for(int element: sortedArray){
			System.out.print(element + ",");
		}
	}
	
	public static int[] quickSort(int[] list, int first, int last){
		if(first < last){
			int pivotIndex = partition(list,first,last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
		return list;
	}
	
	public static int partition(int[] list, int first, int last){
		int pivot = list[first];
		int low = first + 1;
		int high = last;
		while(high > low){
			while(low <= high && list[low] <= pivot) low++;
			while(low <= high && list[high] > pivot) high--;
			if(high > low){
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while(high > first && list[high] >= pivot)	high--;
		
		if(pivot > list[high]){
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}else{
			return first;
		}
	}
}
