package com.java.program;

import java.util.Arrays;

public class PairsInArray {

	public static void main(String[] args) {
		int[] arr = {1, 7 , 5, 4, 9, 6};
		int sum = 10;
		
		findPair(arr, sum);

	}
	
	private static void findPair(int[] arr, int sum) {
		int len = arr.length-1;
		int start = 0;
		int end = len;
		Arrays.sort(arr);
		while(start < end) {
			if(arr[start]+arr[end] > sum) {
				end--;
			} else if(arr[start]+arr[end] < sum) {
				start++;
			} else {
				System.out.println(arr[start] + " , " + arr[end]);
				start++;
			}
			
		}
	}

}
