package com.tn.hamza.java_8_demo;

import java.util.Arrays;
import java.util.List;

/** 
 * <h1>Parallelism</h1>
 * 
 *	Parallelism : faster iteration but very resources consuming
 *  How to use it ? -> "parallelStream()" operation instead of "stream()" operation
 *  
 *  @author hamza
 */
public class Demo4 {

	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		/**
		 * B- "stream()" operation :
		 * 		(-) slower then parallelStream(), but still fast
		 * 		(+) Non-resource consumer
		 */		
		MyUtiliy.printDuration( () ->  //takes apprx. 5 seconds 
				System.out.println(
					lst.stream()
							.filter(i->i%2 == 0 )
							.mapToInt(Demo4::doSomething)
							.sum()	 
				)
		);
		/**
		 * A- "parallelStream()" operation : 
		 *		(+) faster
		 *		(-) Resource consumer
		 *	=>  
		 */
		MyUtiliy.printDuration( () ->  //take apprx. 2 seconds
				System.out.println(		
					lst.parallelStream()
							.filter(i->i%2 == 0 )
							.mapToInt(Demo4::doSomething)
							.sum()
				)
		);		
	}
	
	public static int doSomething(int x){
		 try { Thread.sleep(1000);	} catch (Exception e) { //simple wait to see the time difference later
		}
		return x*2;
	}
	
	
	/**
	 * Some utility class
	 * @author hamza
	 *
	 */
	public static class MyUtiliy{
		/**
		 * A method that prints the time taken by a code to be totally executed
		 * @param Runnable	codeBlock
		 */
		public static void printDuration(Runnable codeBlock){
			long start = System.nanoTime();
			try {
				codeBlock.run();
			} finally{
				long end = System.nanoTime();
				System.out.println("Duration =  "+(end-start)/1.0e9);
			}
		}
	}


}
