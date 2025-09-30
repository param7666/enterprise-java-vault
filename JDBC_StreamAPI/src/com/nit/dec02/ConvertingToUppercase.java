package com.nit.dec02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertingToUppercase {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew");
		List<String> upp=words.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upp);
	}
}
