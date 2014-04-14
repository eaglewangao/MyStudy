package com.ctrip.study.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序.
 */
public class ChoiceSort {
	
	public static void main(String[] args) {
		int[] array = SortUtil.createArray();
		System.out.println("原始的数组：" + Arrays.toString(array));
		ChoiceSort.sort(array);
	}

	private static void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if(array[min] > array[j]){
					min = j;
				}
			}
			SortUtil.swap(array, min, i);
			System.out.println("第 "+ i + " 轮排序后: " + Arrays.toString(array));
		}
	}

}
