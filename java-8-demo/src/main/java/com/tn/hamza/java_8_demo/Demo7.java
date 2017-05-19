package com.tn.hamza.java_8_demo;

import java.util.Arrays;
import java.util.List;
/**
 * <h1>Efficiency of streams</h1>
 * @author Hamza Hedhly
 *
 */
public class Demo7 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 9, 6, 8, 7, 20, 11, 12, 13, 14, 15, 16, 17, 18, 19, 10);

		// Eg : find the double of the first even number greater than 3
		
		/**
		 * A- The Imperative style : Old style
		 * Performance : 8 units of work 
		 * Explanation : The execution would be this way 
		 *               test 1 > 3 no, test 2 > 3 no,test 3 > 3 no, test 5 > 3 yes, test 5 % 2 == 0 no,
		 *               test 4 > 3 yes, test 4 % 2 == 0 yes, double the 4 
		 *               => 8 operations   (in addition if there was no break it could be worse ..)
		 */
		int result = 0;
		for (int e : numbers) {
			if (isGT3(e) && isEven(e)) {
				result = doubleIt(e);
				break;
			}

		}
		System.out.println(	result);
		
		System.out.println("----------------------------");
		
		/**
		 * B- The Functional style : Lazy Evaluation 
		 * Performance : 8 units of work 
		 * Explanation : It create a pipeline of operations (aggregation of operations) that each element will pass through 
		 * 				 The execution would be this way,
		 * 				 test 1 > 3 no, 2 > 3 no, 3 > 3 no, test 5 > 3 yes, test 5 % 2 == 0 no,
		 * 				 test 4 > 3 yes, 4 % 2 == 0 yes, double the 4 
		 * 				  => Same 8 operations  
		 * 				 !!!!! Amazing : All the operations are evaluated only after triggering the findFirst() operation 
		 * 				 [findFirst : an eager also called a terminal operation] otherwise nothing will happen and none of the operations 
		 *               will be executed !!!!! 
		 */
		System.out.println(
				numbers.stream()
				.filter(Demo7::isGT3)
				.filter(Demo7::isEven)
				.map(Demo7::doubleIt)
				.findFirst() //return "Optional[8]" : "Optional", means there is guarantee of returning something 
		);
		
	}
	
	public static boolean isEven(int x) {
		System.out.println("isEven-"+x);
		return x%2 == 0;
	}
	
	public static boolean isGT3(int x) {
		System.out.println("isGT3-"+x);
		return x>3;
	}
	
	public static int doubleIt(int x) {
		System.out.println("doubleIt-"+x);
		return x*2;
	}
}
