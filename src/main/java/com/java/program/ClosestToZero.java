package com.java.program;

import java.util.Arrays;

public class ClosestToZero {

	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 2,2,1,1,1,0};
		int closestIndex = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; ++i) {
		    int abs = Math.abs(arr[i]);
		    if (abs < diff) {
		        closestIndex = i;
		        diff = abs;
		    } else if (abs == diff && arr[i] > 0 && arr[closestIndex] < 0) {
		        //same distance to zero but positive 
		        closestIndex =i;
		    }
		}   
		System.out.println(arr[closestIndex ]);

        /*//int[] data = {2,3,-2};
        int[] data = {1, 2, 2, 2, 3 , 4};
        int curr = 0;
        int near = data[0]; 
        Arrays.sort(data);      //  add this
        System.out.println(Arrays.toString(data));        
        // find the element nearest to zero
        for ( int i = 0; i < data.length; i++ ){
            System.out.println("dist from " + data[i] + " = " + Math.abs(0 -data[i]));
            curr = data[i] * data[i]; 
            if ( curr <= (near * near) )  { 
                near = data[i];
            } 
        }
        System.out.println( near );*/
	}
}
