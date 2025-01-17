package com.centurylink;

import java.util.HashMap;
import java.util.Scanner;

public class Testing {
	static class hello {
		int va;
		hello(){
			va=0;
		}
		hello(int va){
			this.va=va;
		}
		@Override
		public int hashCode() {
			System.out.println("... working ")
			return 5;
		}
	}
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
//		// Two strings with the same hashcode (intentionally)
//		hello key1 = new com.centurylink.testing.hello(2);
//		hello key2 = new hello(3);
//		
////		// Calculate hashcodes
//		int hash1 = key1.hashCode();
//		int hash2 = key2.hashCode();
		
//		System.out.println("Hashcode of key1: " + hash1);
//		System.out.println("Hashcode of key2: " + hash2);
		
		// Put the key-value pairs in the map
		map.put("bharath", 100);
		map.put("rupesh", 200);
		
		
		
		// Retrieve values
		System.out.println("Value for key1: " + map.get(key1));
		System.out.println("Value for key2: " + map.get(key2));
		System.out.println("Value for key2: " + map);
	}
}