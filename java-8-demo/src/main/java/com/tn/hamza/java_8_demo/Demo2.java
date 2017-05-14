package com.tn.hamza.java_8_demo;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>Method references</h1>
 * 
 * Method references : 
 * When ? -> used when passing what you receive to the next step in the flow .. 
 *         It Can be of different types : 
 *         1- Parameter as an argument 
 *         2- Parameter as an argument to a static method 
 *         3- Parameter as a target 
 *         4- Two parameters as arguments
 *         
 * @author hamza         
 */
public class Demo2 {

	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5);

		/**
		 * 1- Parameter as an argument : "println" is an instance method on
		 * "System.out" object, so not a static method as it was always believed
		 * to be (check javaDoc) So in this case we are passing the parameter
		 * "i" as an argument to "println" method, and the target is
		 * "System.out" object
		 * 
		 */
		lst.forEach(
				//i -> System.out.println(i));
				System.out::println); // method reference to an instance method "println"

		/**
		 * 2- Parameter as an argument to a static method
		 * Same as before buthere parameter as an argument to a static method "valueOf" which is a
		 * static method of the "String" class
		 * 
		 */
		lst.stream()
				//.map(i-> String.valueOf(i))
				.map(String::valueOf) // method reference to a static method "valueOf"
				.forEach(System.out::println);

		/**
		 * 3- Parameter as a target
		 *  The parameter "i" here is the target
		 */
		lst.stream()
				.map(i->String.valueOf(i))
				//.map(i-> i.toString())
				.map(String::toString) // method reference to an instance method "toString" where "i" is the target implicitly 
				.forEach(System.out::println);
		
		/**
		 * => When there is One parameter, it s easy to decide it should be an "argument" or a "target" 
		 *  !!  If more then one parameter the parameters order is very important !!
		 */
		
		/**
		 * 0 : is the initial value of the sum
		 */
		System.out.println(
				lst.stream()
				//.reduce(0,(total,i)-> Integer.sum(total, i))
				.reduce(0,Integer::sum));
		
		/**
		 * " " : is the initial value of the string
		 * !!  This case is an eg. where the order of the parameters is very important (strings concatenation)
		 *   "carry" is a target parameter | "e" is an argument parameter
		 */
		System.out.println(
				lst.stream().map(String::valueOf)
				//.reduce("", (ch,e)->ch.concat(e))
				.reduce("",String::concat)
						);
		
		/**   !!! Method references limitations, cannot be used when :
		 * 		1-  manipulating the data 
		 * 		2-  there is a conflict between an instance & static method 
		 * 
		 */
	}

}
