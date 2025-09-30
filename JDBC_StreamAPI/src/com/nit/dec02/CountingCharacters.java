package com.nit.dec02;

import java.util.Arrays;
import java.util.List;

public class CountingCharacters {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew");
		int c=words.stream().mapToInt(String::length).sum();
		System.out.println("Total number of count: "+c);
	}
}
