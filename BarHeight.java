/*************************************************************
 *
 * Amazon: 
 * Given n non-negative integers h1, h2, ..., hn, where each 
 * represents a point at coordinate (i, ai). N vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai)
 * and (i, 0). Find two lines, which together with x-axis forms
 * a container, such that:
 * 1. the container hold highest water, return the max height
 * 2. the container hold water with max volume, return the volume
 *
 * highestWaterLevel Example:
 * Input: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 3, 1]
 * Output: 3
 *
 * maxVolume Example: LeetCode No. 11
 * Input: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 3, 1]
 * Output: 14
 *
 * Keyword: DP
 *
 * @author Jiafeng Ni
 *
 *************************************************************/

public class BarHeight{

    public static void main(String[] args){
	int[] elevation = new int[]{0,1,0,2,1,0,1,3,2,1,3,1};
	//	int[] test = new int[]{100};

	//	System.out.println(highestWaterLevel(test));
	System.out.println(highestWaterLevel(elevation));
	System.out.println(maxVolume(elevation));
    }

    public static int highestWaterLevel(int[] elevation) {
	if (elevation == null || elevation.length < 2) { return 0; }
	
	int len = elevation.length;
	int left = 0;
	int right = len - 1;
	int height = 0;

	while (left < right) {
	    if (elevation[left] < elevation[right]) {
		height = Math.max(height, elevation[left++]);
	    } else if (elevation[left] > elevation[right]) {
		height = Math.max(height, elevation[right--]);
	    } else {
		height = Math.max(height, elevation[left]);
		left++;
		right--;
	    }
	}

	return height;
    }

    public static int maxVolume(int[] elevation) {
	if (elevation == null || elevation.length == 0) { return 0; }
	
	int left = 0;
	int right = elevation.length - 1;
	int volume = 0;

	while (left < right) {
	    volume = Math.max(volume, (right - left) * Math.min(elevation[left], elevation[right]));
	    
	    if (elevation[left] < elevation[right])      { left++;}
	    else if (elevation[left] > elevation1[right]) { right--;}
	    else                                   { left++; right--;}
	}

	return volume;
    }
}