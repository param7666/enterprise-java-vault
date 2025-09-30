package com.nit.dec02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListofSquares {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
		List<Integer> result=numbers.stream().map(n->n*n).collect(Collectors.toList());
		System.out.println("List of Square ");
		System.out.println(result);
		
	}
}
