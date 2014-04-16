package com.ctrip.study.algorithm.leetcode;

// TODO: Auto-generated Javadoc
/**
 * 给定一个整数数组，
 * 数组中所有元素都出现了两次，
 * 只有一个元素只出现了一次，
 * 找出这个只出现了一次的元素。.
 */
public class SingleNumber {
	
	/**
	 * 用异或来解.
	 */
	public int singleNumber(int[] A) {
		int key = A[0];
		for (int i = 1; i < A.length; i++) {
			key = key ^ A[i];
		}
		return key;
	}
	
}