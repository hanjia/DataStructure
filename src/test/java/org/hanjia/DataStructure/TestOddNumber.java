package org.hanjia.DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestOddNumber {
	public static void main(String[] args){
		int[] array = {1,2,3,4};
		System.out.println(findOddNumberElements(array));
	}
	
	public static List<Integer> findOddNumberElements(int[] array){
		Map<Integer,Integer> countMap = new HashMap<Integer, Integer>();
		for(int element: array){
			if(countMap.containsKey(element)){
				countMap.put(element, countMap.get(element) + 1);
			}else{
				countMap.put(element, 1);
			}
		}
		
		List<Integer> oddNumberElements = new ArrayList<Integer>();
		for(Entry<Integer, Integer> entry: countMap.entrySet()){
			if(entry.getValue() %2 != 0){
				oddNumberElements.add(entry.getKey());
			}
		}
		return oddNumberElements;
	}
	
	
}
