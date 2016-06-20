package org.hanjia.DataStructure.Sorting;

/**
 * 
 * @author hanjia
 *
 */
public class MergeSort {

	public static void main(String[] args){
		int[] array = { 2, 5, 3, 6, 8, 4, 7, 1 };
		int[] sortedArray = mergeSort(array);
		for (int element : sortedArray) {
			System.out.print(element + ",");
		}
	}
	
	public static int[] mergeSort(int[] list){
		if (list.length > 1) {
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);

			int[] secondHalf = new int[list.length - list.length / 2];
			System.arraycopy(list, list.length / 2, secondHalf, 0, list.length - list.length / 2);
			mergeSort(secondHalf);

			int[] temp = merge(firstHalf, secondHalf);
			System.arraycopy(temp, 0, list, 0, temp.length);
		}
		return list;
	}
	
	public static int[] merge(int[] list1, int[] list2){
		int[] result = new int[list1.length + list2.length];
		int current1 = 0;
		int current2 = 0;
		int current = 0;
		
		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2]) {
				result[current++] = list1[current1++];
			} else {
				result[current++] = list2[current2++];
			}
		}

		while (current1 < list1.length) {
			result[current++] = list1[current1++];
		}

		while (current2 < list2.length) {
			result[current++] = list2[current2++];
		}
			
		return result;	
	}
}
