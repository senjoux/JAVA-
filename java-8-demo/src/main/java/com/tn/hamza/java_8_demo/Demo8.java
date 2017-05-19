package com.tn.hamza.java_8_demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * <h1>Characteristics of a Stream<h1>
 * Can be :
 * 	. Sorted/Non-Sorted
 *  . Sized/Unsized
 *  . Ordered/Unordered
 *  . Distinct/Non-Distinct
 *  
 * @author Hanza Hedhly
 *
 */
public class Demo8 {

	public static void main(String[] args) {

		/**
		 * distinct() : make the stream elements distinct
		 * sorted() : sort the stream elements
		 * limit (n) : limit the stream size to n elements
		 * ... etc
		 */
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		
		numbers.stream().filter(e-> e%2 ==0)
		//.sorted() //sorted elements
		//.distinct() //distinct elements
		//.limit(maxSize) //give a limit/size
		.forEach(System.out::println);
		
		
		/**
		 * Operations types 
		 */
		//Given a number k, and a count n, find the total of double of n even numbers
		//starting with k, where sqrt of each number is > 20 
		
		int k = 121;
		int n = 51;
		System.out.println(compute(k,n));
		
		
		/**
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * Operations can be classified into :
		 * 		A- Lazy operations : 
		 * 			.Operations : filter, limit, skip, map ... etc
		 * 			. How To distinguish them : return type is "Stream"
		 * 		B- Terminal operations : 
		 * 			.Operations : findFirst, sum, min, max, count, reduce, collect ...	etc
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * 		 
		 */
	}

	private static int compute(int k, int n) {
		return Stream.iterate(k, e -> e+1) //lazy, with only iterate we have an infinite stream but its s lazy it will not be executed
			  .filter(e -> e % 2 ==0) //lazy
			  .filter(e -> Math.sqrt(e) > 20) //lazy
			  .mapToInt(e->e*2)	//lazy
			  .limit(n)	//lazy, will limite the infinite stream, AWESOME JAVA8 STREAMS !!YOHOOOOOO!!! 	
			  .sum();  //eager
		 
	}

}
