package org.hanjia.DataStructure.Sorting;

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
