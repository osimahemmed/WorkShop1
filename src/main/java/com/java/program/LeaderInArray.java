package com.java.program;

public class LeaderInArray {

	public static void main(String[] args) {
		int[] num = {15, 16, 3, 2, 6, 1, 4};
		int len = num.length;
		int mfr = num[len-1];
		System.out.print(mfr + " ");
		for(int i = len-2; i >= 0; i--) {
			if(mfr < num[i]) {
				mfr = num[i];
				System.out.print(mfr + " ");
			}
		}
		
	}

}
