package com.nit.dec02;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindingMaximumAndMinimum {

	public static void main(String[] args) {
		int []numbers= {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
		OptionalInt min=Arrays.stream(numbers).min();
		OptionalInt max=Arrays.stream(numbers).max();
		
		min.ifPresent(minValue->System.out.println("Min value: "+minValue));
		max.ifPresent(maxValue->System.out.println("Max value: "+maxValue));
	}

}
