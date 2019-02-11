package com.java.program;

public class CountingValley {

	public static void main(final String[] args) {
		String terrain = "UDDDUDUU";
		int count = valleyCount(terrain);
		System.out.println(count);
	}

	private static int valleyCount(final String terrain) {
		int level = 0;
		int valleys = 0;
		boolean belowSea = false;
		int length1 = terrain.length();
		for(int i = 0; i <length1; i++ ) {
			char ch = terrain.charAt(i);
			if(ch == 'U') {
				level ++;
			} else {
				level --;
			}
			if(!belowSea && level < 0) {
				valleys ++;
				belowSea = true;
			}
			if(level > 0)
				belowSea = false;
		}
		
		return valleys;
	}

}
