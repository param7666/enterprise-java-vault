package com.nit.dec04;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class MaximumAndMinimum {
	public static void main(String[] args) {
		int[]num= {5, 10, 15, 20, 25, 30};
		OptionalInt min=Arrays.stream(num).min();
		OptionalInt max=Arrays.stream(num).max();
		min.ifPresent(minValue->System.out.println("Minimum value: "+minValue));
		max.ifPresent(maxValue->System.out.println("Minimum value: "+maxValue));
	}
}
