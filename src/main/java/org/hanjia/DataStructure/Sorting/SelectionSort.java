package org.hanjia.DataStructure.Sorting;

/**
 * Selection Sort Algorithm: 
 * 1) Find the minimum value in the list; 
 * 2) Swap it with the value in the current position; 
 * 3) Repeat this process for all the elements until the entire array is sorted
 * @author hanjia
 *
 */
public class SelectionSort {
	public static void main(String[] args){
		int[] array = {2, 5, 3, 6, 8, 4, 7, 1};
		int[] sortedArray = selectionSort(array);
		for(int element: sortedArray){
			System.out.print(element + ",");
		}
	}
	
	public static int[] selectionSort(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[min]) min = j;
			}
			
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
		return array;
	}
}
