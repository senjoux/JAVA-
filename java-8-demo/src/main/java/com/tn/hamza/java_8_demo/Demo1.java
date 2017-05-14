package com.tn.hamza.java_8_demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <h1>From external to internal iterators</h1>
 * 
 * From "External" to "Internal" iterators 
 * 
 * @author hamza
 */
public class Demo1 {

	public static void main(String[] args) {

		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5);

		/**
		 * 
		 * A- Using an "External Iterators"
		 * (-) : The user is in charge of iterating through the collection
		 *       so mistakes can be made. Eg : whether use .length or size()
		 *       ... or is it < or > or =< ....
		 *        
		 */
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}

		for (Integer i : lst)
			System.out.println(i);
		
		

		/**
		 *
		 * B- Using an "Internal iterators"
		 * 
		 */
		
		/**
		 * B-1 : Two much noise with this "Consumer" approach (passing the anonymous class explicitly ...) 
		 *
		 */
		lst.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.println(i);
			}
		});
		
		/**
		 * Simplification of the B-1 approach (by passing the anonymous class implicitly ...)
		 */
		lst.forEach((Integer i) -> System.out.println(i));
		
		
		/**
		 * B-2 : Can get ride of the passed parameter type !
		 */
		lst.forEach(i -> System.out.println(i));
		
		/**
		 * Simplification of B-2 approach : Why bother passing the variable name to the 
		 * method "syso" where this last will only print out the iterated xvariable ?
		 *   
		 */
		lst.forEach(System.out::println);
			
		/**
		 *	=> Evade using Lambda for complex situation (multiple lines of code )
		 *     because the code will become hard to read, understand, test ... 
		 */
	}

}
