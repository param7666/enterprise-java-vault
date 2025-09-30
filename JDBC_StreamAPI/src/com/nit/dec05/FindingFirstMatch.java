package com.nit.dec05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindingFirstMatch {
	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi");
		 Optional<String> s=strings.stream().filter(str->str.length()>5).findFirst();
		 s.ifPresent(st->System.out.println(st));
	}
}
