/*************************************************************
 *
 * Amazon:
 * Given an input array of integers, write a function that returns
 * the Run Length Encoded string for the input.
 *
 * Example:
 * Input: [1,1,1,0,0,1,1,0,1]
 * Output: "1302120111"
 *
 * Keyword: Array
 *
 * @author Jiafeng Ni
 *
 *************************************************************/

import java.util.*;


public class ArrayLengthEncoding{

    public static void main(String[] args){
	int[] test = new int[]{1,1,1,0,0,1,1,0,1};
	int[] empty = new int[0];
	
	System.out.println(encodeLength(test));
	System.out.println(encodeLength(empty));
    }

    /**
     * Return the Run Length Encoded string for the input array.
     * @param arr the array of integers
     * @return the Run length encoded string for input array
     */
    public static String encodeLength(int[] arr) {
	if (arr == null || arr.length == 0) { return "empty"; }
	
	StringBuilder result = new StringBuilder();
	int prev = arr[0];
	int count = 1;
	result.append(prev);
	
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i] == prev) {count++;}
	    else {
		result.append(count);
		count = 1;
		prev = arr[i];
		result.append(prev);
	    }
	}

	result.append(count);

	return result.toString();
    }

}