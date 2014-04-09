package com.ctrip.study.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	
	
	public static void sort(){
		int[] array = SortUtil.createArray();
		System.out.println("原始的数组：" + Arrays.toString(array));
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if(array[j] > array[j + 1]){
					SortUtil.swap(array, j, j + 1);
				}
				System.out.println("第 "+ i + "---" + j + " 轮排序后: " + Arrays.toString(array));
			}
			System.out.println("第 "+ i + " 轮排序后: " + Arrays.toString(array));
		}
	}
	
	
	public static void main(String[] args) {
		BubbleSort.sort();
	}

}
