package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Brtue force solution

//1. generate all the subarrays
//2. iterate through all the subarrys and get the sum of the subarray , if the sum is greater than or equal to target you just need to compare with res if it is lesser update the res
//3. return res

public class SmallSub {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>(List.of(1,2,3,4,5,6,7));
		int target = 12;
		int res = SmallSub.smallestSubarray(nums, target);
		System.out.println(res);
//		optimal
		int optimal_res = SmallSub.optimalSubArray(nums, target);
		System.out.println("optimal res : " + optimal_res);
	}
	
	public static int optimalSubArray(ArrayList<Integer> nums, int target) {
		int res = Integer.MAX_VALUE;
		int current_sum = 0;
		int left = 0;
		int n = nums.size();
		if (target == 0) {
			if (n > 0) {
				return 1;
			}
			return 0;
		}
		for(int right = 0; right < n; right++) { // n
			current_sum += nums.get(right);
			while (current_sum >= target) { // overall iterations n
				res = Math.min(res, right - left + 1);
				current_sum -= nums.get(left);
				left++;
			}
		}
		return res;
	}
	
// TC: O(n + n) = O(n)
// SC: O(1)	
	
	
	
	public static int smallestSubarray(ArrayList<Integer> nums , int target) {
//		generate all subarrays
		int res = Integer.MAX_VALUE; // 
		ArrayList<ArrayList<Integer>> subarrays = new ArrayList<ArrayList<Integer>>(); // n(n+1//2)
		int n = nums.size();
		for (int i = 0; i < n; i++) {  // n 
			ArrayList<Integer> sub = new ArrayList<Integer>(); // n
			for (int j = i; j < n; j++) { // n
				sub.add(nums.get(j));
			}
			subarrays.add(sub);
		}
		System.out.println("subarrys: " + subarrays);
		for (ArrayList<Integer> arr: subarrays) { // n(n+1)/2
			int current_sum = 0;
			int subArrLen = arr.size();
			for (int num: arr) { // n 
				current_sum += num;
			}
			if(current_sum >= target) {
				if(subArrLen < res) {
					res = subArrLen;
				}
			}
		}
		return res;
	}

}

// Brute Force


// Overall TC: (O(n) * O(n)) + (0(n(n+1)/2) + o(n))
// TC: (O(n) * O(n)) = O(n^2)

// SC: O(n(n+1)/2 * n)



