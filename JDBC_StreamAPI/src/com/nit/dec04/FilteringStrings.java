package com.nit.dec04;

import java.util.List;

public class FilteringStrings {
	public static void main(String[] args) {
		List<String> str=List.of("Amar","Param","Sundar","Rakesh","Kishor","Aravind");
		List<String> result=str.stream().filter(s->s.contains("a")).toList();
		System.out.println(result);
	}
}
