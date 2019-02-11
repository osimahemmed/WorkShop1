package com.java.program;

public class MissingNumberTest {

	public static void main(String[] args) {
		int[] num = {1, 3, 4, 5};
		
		int mis = printMissing(num);
		System.out.println("mising " + mis);
		printMissingNumber();

	}
	
	private static int printMissing(int[] num) {
		
		int x1 = num[0];
		int x2 = 1;
		
		for(int i = 1; i < num.length; i++) {
			x1 = x1^num[i];
		}
		System.out.println(x1);
		for(int i = 2; i <= num.length+1; i++) {
			x2 = x2^i;
		}
		return x1^x2;
	}
	
	private static void printMissingNumber() {
		int[] num = {10, 14, 13, 12};
		int n1 = num[0];
		int len = num.length;
		for(int i = 1; i < len; i++) {
			n1 = n1^num[i];
		}
		System.out.println("n1 " +n1);
		int min = num[0];
		int max = num[0];
		for(int num1 : num) {
			if(min > num1) {
				min = num1;
			}
			if(max < num1) {
				max = num1;
			}
		}
		
		//System.out.println(min + " "+max);
		int x2 = min;
		for(int i = min+1; i <=max; i++) {
			x2 = x2^i;
		}
		System.out.println(n1^x2);
		
	}

}
