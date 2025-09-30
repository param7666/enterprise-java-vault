package com.nit.dec05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningbyLength {
	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi");
		 Map<Boolean, List<String>> p=strings.stream().collect(Collectors.partitioningBy(s->s.length()%2==0));
		 System.out.println("Even length String: "+p.get(true));
		 System.out.println("Odd length String: "+p.get(false));
	}
}
