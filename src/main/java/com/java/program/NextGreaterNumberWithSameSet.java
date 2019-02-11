/*

 1) If all digits sorted in descending order, then output is always "Not Possible". For example, 4321.
 2) If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
 3) For other cases, we need to process the number from rightmost side (why? because we need to find the 
 smallest of all greater numbers)

You can now try developing an algorithm yourself. 

Following is the algorithm for finding the next greater number.
I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than 
the previously traversed digit. For example, if the input number is 534976, we stop at 4 because 4 is smaller 
than next digit 9. If we do not find such a digit, then output is Not Possible.

II) Now search the right side of above found digit d for the smallest digit greater than d. For '534976',
 the right side of 4 contains 976. The smallest digit greater than 4 is 6.

III) Swap the above found two digits, we get 536974 in above example.

IV) Now sort all digits from position next to d to the end of number. The number that we get after sorting is
 the output. For above example, we sort digits in bold 536974. We get 536479 which is the next greater number 
 for input 534976.


 */

package com.java.program;

import java.util.Arrays;

public class NextGreaterNumberWithSameSet {

	public static void main(String[] args) {
		char[] digit = { '5','3','4','9','7','6' };//4321
		int len = digit.length;
		
		findNextGreater(digit, len);

	}
	
	private static void findNextGreater(char[] digit, int len) {
		
		int i;
		for(i = len-1; i > 0; i--) {
			if(digit[i-1] < digit[i]) {
				break;
			}
		}
		if(i == 0) {
			System.out.println("Next greater number is not possible");
		} else {
			int x = i-1; int min = i;
			for(int j = i+1; j < len; j++) {
				if(digit[j] > x && digit[j] < digit[min]) {
					min = j;
				}
			}
			
			char temp = digit[i-1];
            digit[i-1] = digit[min];
            digit[min] = temp;
            Arrays.sort(digit, i, len-1);
            
            System.out.println(Arrays.toString(digit));

		}
		
		
	}

}
