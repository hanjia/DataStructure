package org.hanjia.DataStructure.Sorting;


/**
 * Every repetition of insertion sort: 
 * 1) removes an element from the input data; 
 * 2) inserts it into the correct position in the already-sorted list until no input elements remain. 
 * @author hanjia
 *
 */
public class InsertionSort {

	public static void main(String[] args){
		int[] array = {2, 5, 3, 6, 8, 4, 7, 1};
		int[] sortedArray = insertionSort(array);
		for(int element: sortedArray){
			System.out.print(element + ",");
		}
	}
	
	public static int[] insertionSort(int[] array){
		for(int i = 1; i <= array.length - 1; i++){
			int temp = array[i];
			int j = i;
			while(j >= 1 && array[j - 1] > temp){
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
		}
		return array;
	}
}
