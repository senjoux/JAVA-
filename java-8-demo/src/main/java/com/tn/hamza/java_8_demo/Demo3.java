package com.tn.hamza.java_8_demo;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>Function Composition</h1>
 * 
 *	Function Composition 
 *	Definition : series of operations / pipeline 
 *  Note, Best practice : when doing function composition it s better 
 *                        to Write the code on multiple lines 
 *                    
 *  @author hamza                      
 */
public class Demo3 {
	public static void main(String[] args) {
		
		List<Integer> lst = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		/**
		 * A- The Imperative style : Old style 
		 * Limits : (-) A lot of work 
		 * 			(-) Code complex to understand if there are too many conditions 
		 */
		int total = 0;
		for(int i : lst){
			if(i% 2 == 0 )
				total +=i;
		}
		System.out.println(total);
		
		
		/**
		 * B- The Functional style ==> Function Composition (composition of multiple functions)
		 * Advantages : (+) Expressive code 
		 * Eg : filter even numbers -> map (do the integer double) -> return the sum
		 */
		System.out.println(
		//lst.stream().filter(i-> i%2 == 0).map(i->i*2).reduce(0,Integer::sum)
		lst.stream()
				.filter(i->i%2 == 0 )
				.mapToInt(i->i*2)
				.sum()
		);
	}
}
