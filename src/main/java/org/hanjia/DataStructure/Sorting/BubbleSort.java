package org.hanjia.DataStructure.Sorting;

public class BubbleSort {
	
	public static void main(String[] args){
		int[] array = {2, 5, 3, 6, 8, 4, 7, 1};
		int[] sortedArray = bubbleSort(array);
		for(int element: sortedArray){
			System.out.print(element + ",");
		}
	}
	
	public static int[] bubbleSort(int[] array) {
		boolean swapped = true;
		for(int pass = array.length -1; pass >= 0 && swapped; pass--) {
			swapped = false;
			for(int i = 0; i < pass; i++){
				if(array[i] > array[i+1]){
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swapped = true;
				}
			}
		}
		return array;
	}
}
