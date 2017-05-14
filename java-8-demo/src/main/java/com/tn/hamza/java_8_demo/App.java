package com.tn.hamza.java_8_demo;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/* The old approach */
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("anonymous function 1 call ");
			}
		});
		th1.start();
		/**
		 * The new approach using Lambda expressions 
		 * Parameters on the left and method core or logic on the right 
		 * () : means empty parameters 
		 */
		Thread th2 = new Thread(() -> System.out.println("anonymous function 2 call"));
		th2.start();
		Thread th3 = new Thread(() -> System.err.println("anonymous function 3 call"));
		th3.start();
		
	}
}
