package com.nit.dec02;

import java.util.Arrays;
import java.util.List;

public class PalindromeDetection {
	public static boolean isPalindrome(String str) {
		String reverse=new  StringBuilder(str).reverse().toString();
		return str.equalsIgnoreCase(reverse);
			
	}
	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("apple", "level", "banana", "radar", "cherry");
		 boolean hasPalindrome=strings.stream().anyMatch(PalindromeDetection::isPalindrome);
		 if(hasPalindrome) System.out.println("List contain palindrome strings ");
		 else System.out.println("List can not contain palindrome Strings ");
	}
}
