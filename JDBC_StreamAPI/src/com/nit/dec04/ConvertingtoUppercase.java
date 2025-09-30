package com.nit.dec04;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertingtoUppercase {
	public static void main(String[] args) {
		List<String> list=List.of("Amar","Param","Sundar","Rakesh","Kishor","Aravind");
		List<String>up=list.stream().map(String::toUpperCase).collect(Collectors.toList());
		up.forEach(System.out::println);
	}
}
