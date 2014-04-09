package com.ctrip.study.algorithm.sort;

public class SortUtil {
	
	/**
	 * 交换数组中两个位置的数据.
	 *
	 * @param array the array
	 * @param a the a
	 * @param b the b
	 */
	public static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	
	public static int[] createArray(){
		int[] array = {8, 3, 2, 5, 9, 1, 6};
		return array;
	}
	
	

}
