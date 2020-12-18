package org.hanjia.datastructure.sorting;

/**
 * 
 * @author hanjia
 *
 */
public class MergeSort {

	public static void main(String[] args){
		int[] array = { 2, 5, 3, 6, 8, 4, 7, 1 };
		mergeSort(array);
		for (int element : array) {
			System.out.print(element + ",");
		}
	}
	
	public static void mergeSort(int[] array){
		if (array.length > 1) {
			int[] firstHalf = new int[array.length / 2];
			System.arraycopy(array, 0, firstHalf, 0, array.length / 2);
			mergeSort(firstHalf);

			int[] secondHalf = new int[array.length - array.length / 2];
			System.arraycopy(array, array.length / 2, secondHalf, 0, array.length - array.length / 2);
			mergeSort(secondHalf);

			int[] temp = merge(firstHalf, secondHalf);
			System.arraycopy(temp, 0, array, 0, temp.length);
		}
	}
	
	public static int[] merge(int[] array1, int[] array2){
		int[] result = new int[array1.length + array2.length];
		int current = 0, current1 = 0, current2 = 0;
		
		while (current1 < array1.length && current2 < array2.length) {
			if (array1[current1] < array2[current2]) {
				result[current++] = array1[current1++];
			} else {
				result[current++] = array2[current2++];
			}
		}

		while (current1 < array1.length) {
			result[current++] = array1[current1++];
		}

		while (current2 < array2.length) {
			result[current++] = array2[current2++];
		}
			
		return result;	
	}
}
