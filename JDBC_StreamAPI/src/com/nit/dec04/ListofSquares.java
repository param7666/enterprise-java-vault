package com.nit.dec04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListofSquares {
	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(5, 10, 15, 20, 25, 30);
		List<Integer> list = num.stream().map(n -> n * n).collect(Collectors.toList());
		list.forEach(System.out::println);
//		IntStream stream = num.stream().mapToInt(n->n*n);
//		stream.forEach(System.out::println);
	}
}
