package org.hanjia.datastructure.selection;

public class FindKSmallestElement {

	public static void main(String[] args){
		int[] array = {5, 3, 4, 1, 7, 8 ,2, 9};
		System.out.println(findKSmallestElement(array,2));
	}
	
	public static int findKSmallestElement(int[] array, int k){
		 int left = 0;
	     int right = array.length - 1;
	     while(left <= right){
	    	 int pivotIndex = left + 1;
	    	 int index = partition(array, left, right, pivotIndex);
	    	 int length = index - left + 1; //pivot左边的长度
	    	 if(length < k){ //如果pivot左边的长度小于k,则可以忽略pivot左边的元素，但是右边只需要查找第(k-length)个元素
	    		 left = index + 1; 
	    		 k = k - length;
	    	 }else if(length > k){ //如果pivot左边的长度大于k,则可以忽略pivot右边的元素
	    		 right = index - 1; 
	    	 }else{
	    		 return array[index];
	    	 }
	     }		
		return Integer.MIN_VALUE;
	}
	
	public static int partition(int[] array, int left, int right, int pivotIndex){
		int pivotValue = array[pivotIndex];
		
		int temp = array[pivotIndex]; //交换最右边的元素与pivot的值，从而能保存pivot的值
		array[pivotIndex] = array[right];
		array[right] = temp;
		
		int storedIndex = left; //用来储存pivot的正确index
		for(int i = left; i < right; i++){
			if(array[i] < pivotValue){
				temp = array[i]; //把小于pivot值的元素移到左边
				array[i] = array[storedIndex];
				array[storedIndex] = temp;
				
				storedIndex++;
			}
		}
		
		temp = array[storedIndex]; //将pivot原本的值从最右边的位置移回到正确的位置
		array[storedIndex] = array[right];
		array[right] = temp;
		
		return storedIndex;
	}
}
