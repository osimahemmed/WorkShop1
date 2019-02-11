package com.java.program;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

	/*public static String subString(String input) {

		Set<Character> set = new HashSet<Character>();

		String longestOverAll = "";
		String longestTillNow = "";

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (set.contains(c)) {
				longestTillNow = "";
				set.clear();
			}
			longestTillNow += c;
			set.add(c);
			if (longestTillNow.length() > longestOverAll.length()) {
				longestOverAll = longestTillNow;
			}
		}

		return longestOverAll;
	}*/

	
	
	public static void main(String[] args) {
		// String input = "substringfindout";
		 String input = "GEEKSFORGEEKS";
		// String input = "BBBB";
		//String input = "ABDEFGABEF";
		System.out.println(subString(input));
	}

	private static String subString(String input) {
		
		String longest = "";
		String longestSub = "";
		int size = input.length();
		Set<Character> set = new HashSet<>();
		
		for(int index = 0; index < size; index ++) {
			char ch = input.charAt(index);
			if(set.contains(ch)) {
				longest = "";
				set.clear();
			}
			longest = longest + ch;
			set.add(ch);
			if(longest.length() > longestSub.length()) {
				longestSub = longest;
			}
		}
		
		return longestSub;
	}

}
