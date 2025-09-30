package com.nit.dec02;

import java.util.Arrays;
import java.util.List;

public class FilteringStrings {
	public static void main(String[] args) {
		List<String> str=Arrays.asList("Pavan","Mangesh","Raju","Vevek");
		List<String> answer=str.stream().filter(s->s.contains("a")).toList();
		System.out.println("List of all Strings that contain 'a'"+answer);
	}
}
