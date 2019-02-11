package com.java.program;

import java.util.Arrays;

public class Seggregate01 {

	public static void main(String[] args) {
		
		int[] num = {1, 0, 1, 0, 0,1};
		seggregate01(num);

	}
	
	private static void seggregate01(int[] num) {
		int count = 0;
		int len = num.length;
		for(int i = 0; i < len; i++ ) {
			if(num[i] == 0){
				count++;
			}
		}
		for(int i = 0; i < len; i++) {
			if(i < count)
				num[i] = 0;
			else {
				num[i] = 1;
			}
		}
		System.out.println(Arrays.toString(num));
	}

}
