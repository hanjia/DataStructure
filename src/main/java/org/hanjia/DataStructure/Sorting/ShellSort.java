package org.hanjia.DataStructure.Sorting;

public class ShellSort {

	public static void main(String[] args){
		int[] array = {2, 5, 3, 6, 8, 4, 7, 1};
		int[] sortedArray = shellSort(array);
		for(int element: sortedArray){
			System.out.print(element + ",");
		}
	}
	
	public static int[] shellSort(int[] array){
		for(int gap = array.length / 2; gap > 0; gap = gap/2){
			for (int i = gap; i < array.length; i++) {
	            int value = array[i];
	            int j = i;
	            while(j >= gap && array[j - gap] > value){
	            	array[j] = array[j - gap];
	            	j = j - gap;
	            }
	            array[j] = value;
	        }
		}
		return array;
	}
}
