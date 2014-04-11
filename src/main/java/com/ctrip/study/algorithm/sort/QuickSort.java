package com.ctrip.study.algorithm.sort;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * 快速排序算法实现.
 */
public class QuickSort {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		QuickSort.sort();
	}

	/**
	 * Sort.
	 */
	private static void sort() {
		int[] array = SortUtil.createArray();
		System.out.println(Arrays.toString(array));
		int low = 0, high = array.length - 1;
		quickSort(array, low, high);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int middle = getMiddle(array, low, high); 
			quickSort(array, low, middle - 1);
			quickSort(array, middle + 1, high);
		}
	}

	private static int getMiddle(int[] array, int low, int high) {
		int flag = array[low];
		while (low < high) {
			while (array[high] > flag) {
				high--;
			}
			SortUtil.swap(array, high, low);
			while (array[low] < flag) {
				low++;
			}
			SortUtil.swap(array, high, low);
		}
		System.out.println(Arrays.toString(array));
		return low;
	}

}
