package com.ctrip.study.algorithm.leetcode;

public class Sqrt {

	public static void main(String[] args) {
		System.out.println(new Sqrt().sqrt(101));
	}

	private int sqrt(int i) {
		Long key = Long.valueOf(i);
		while ((key * key - i) > 0) {
			key = (key + i / key) / 2;
		}
		return key.intValue();
	}

}
