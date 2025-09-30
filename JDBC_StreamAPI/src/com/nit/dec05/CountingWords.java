package com.nit.dec05;

import java.util.Arrays;
import java.util.List;

public class CountingWords {
	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("Sun", "Moon", "Stars", "Sky", "Sea", "Sand", "Mountain");
		 long count=strings.stream().filter(str->str.startsWith("S")).count();
		 System.out.println("Count: "+count);
	}
}
