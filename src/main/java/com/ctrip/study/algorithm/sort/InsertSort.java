package com.ctrip.study.algorithm.sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] array = SortUtil.createArray();
		System.out.println("原始的数组：" + Arrays.toString(array));
		InsertSort.sort(array);
	}

	private static void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			// insertValue准备和前一个数比较
			int index = i - 1;
			while (index >= 0 && key < array[index]) {
				// 将把arr[index]向后移动
				array[index + 1] = array[index];
				// 让index向前移动一位
				index--;
			}
			// 将insertValue插入到适当位置
			array[index+1] = key;
		}
		System.out.println("排序后的数组：" + Arrays.toString(array));
	}

}
