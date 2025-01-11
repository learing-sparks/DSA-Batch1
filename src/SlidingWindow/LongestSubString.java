package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcabcd";
		LongestSubString l = new LongestSubString();
		int res = l.longestSub(s);
		System.out.println("res : " + res);
		int optimal_res = l.optimalLongSub(s);
		System.out.println("optimal_res : " + optimal_res);
	
	}
	
	
	
	public int longestSub(String s) {
		int res = Integer.MIN_VALUE; // 
		ArrayList<ArrayList<Character>> subarrays = new ArrayList<ArrayList<Character>>(); // n(n+1//2)
		int n = s.length();
		for (int i = 0; i < n; i++) {  // n 
			ArrayList<Character> sub = new ArrayList<Character>(); // n
			for (int j = i; j < n; j++) { // n
				sub.add(s.charAt(j));
			}
			subarrays.add(sub);
		}
		System.out.println("subarrys: " + subarrays);
		for (ArrayList<Character> arr: subarrays) { // n(n+1)/2
			int subArrLen = arr.size();
			HashSet<Character> set = new HashSet<Character>(arr);
			int setSize = set.size();
			if (setSize == subArrLen) {
				res = Math.max(subArrLen, res);
			}
		}
		return res;
	}
	
//	TC: O(n^2)
//	SC: O(n(n+1)/2 * o(n))
	
	public int optimalLongSub(String s) {
		int res = Integer.MIN_VALUE;
		HashSet<Character> set = new HashSet<Character>();
//		int left = 0;
		int n = s.length();
		for (int right = 0; right < n; right++) { // n
			Character ch = s.charAt(right);
			while(set.contains(ch)) { // Overall iterations it will also be n 
				set.remove(ch);
			}
			set.add(ch);
			res = Math.max(set.size(), res);
		}
		return res;
	}
	
//	TC: o(n)
// SC: o(1)

}
