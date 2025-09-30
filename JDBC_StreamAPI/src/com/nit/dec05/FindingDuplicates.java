package com.nit.dec05;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindingDuplicates {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 7, 3, 8, 9, 3, 4);
		Set<Integer> dup=numbers.stream().filter(n->Collections.frequency(numbers, n)>1).collect(Collectors.toSet());
		System.out.println(dup);
	}
}
