package com.training.classes;

import java.util.function.Function;

public class Demo2 {

	public static void main(String[] args) {
	//square of a number
		Function<Integer,Integer> square = (Integer input)->(input * input);
		
		System.out.println(square.apply(12));
		
		
	}

}
