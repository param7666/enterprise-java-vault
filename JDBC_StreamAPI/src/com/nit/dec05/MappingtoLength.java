package com.nit.dec05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingtoLength {
	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi");
		 Map<Integer, List<String>> group=strings.stream().collect(Collectors.groupingBy(s->s.length()));
		 System.out.println(group);
	}
}
