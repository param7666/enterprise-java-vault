package com.nit.dec05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilteringPrimeNumbers {
	public static boolean isPrime(int num) {
		if(num<=1) return false;
		return IntStream.rangeClosed(2, (int)Math.sqrt(num)).allMatch(n->n%n!=0);
	}
	
	public static void main(String[] args) {
		List<Integer> num=Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<Integer> prime=num.stream().filter(FilteringPrimeNumbers::isPrime).collect(Collectors.toList());
		prime.forEach(System.out::println);
	}
}
