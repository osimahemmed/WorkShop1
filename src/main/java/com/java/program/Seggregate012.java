package com.java.program;

import java.util.Arrays;

public class Seggregate012 {

	public static void main(String[] args) {
		int[] arr = {2, 0, 1, 1, 0, 0, 1};
		int len = arr.length-1;
		
		seggregate012(arr, len);

	}
	
	private static void seggregate012(int[] arr, int end) {
		
		int start = 0;
		int i = 0;
		while(start <= end) {
			switch (arr[start]) {
			case 2:
				int temp = arr[start];
				arr[start] = arr[end];//{2, 0, 1, 1, 0, 0, 1};
				arr[end] = temp;
				end--;
				
				break;
			case 0:
				int temp1 = arr[start];
				arr[start] = arr[i];
				arr[i] = temp1;
				i++;
				start++;
				break;
			default:
				start++;
				}
			
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

}
