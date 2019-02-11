package com.java.program;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class CutStick {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		SortedMap<Integer, Integer> length2count = new TreeMap<Integer, Integer>();
		int[] arr = new int[]{3, 6, 10, 5, 3};
		for (int i = 0; i < arr.length; i++) {
			if (!length2count.containsKey(arr[i])) {
				length2count.put(arr[i], 0);
			}
			length2count.put(arr[i], length2count.get(arr[i]) + 1);
		}
		int leftNum = arr.length;
		for (int count : length2count.values()) {
			System.out.println(leftNum);
			leftNum -= count;
		}

		in.close();
	}
}
