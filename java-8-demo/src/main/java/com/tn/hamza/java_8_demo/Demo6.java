package com.tn.hamza.java_8_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tn.hamza.dumb.Employee;

/**
 * <h1>Stream Operations</h1> 
 * @author hamza
 *
 */
public class Demo6 {

	public static void main(String[] args) {
		
		List<Integer> lst=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		/**
		 * A- Filter :
		 * . Filtering function
		 * . How it works : block or let go elements if condition satisfied  
		 * . Elements : 0 <= number of elements in the output <= number of elements in the input
		 * . Parameter : for Stream<T> (a stream of type "T"), filter takes Predicate<T> as a parameter (a predicate of type "T") 
		 * 				 and returns Stream<T>
		 */
		//Eg :
		//.filter(x-> x %2 == 0)
		
		/**
		 * B- Map :
		 * . Transforming function : transforms values 
		 * . How it works : receive and transforms values 
		 * . Elements : 1- number of elements in the output == number of elements in the input
		 * 				2- no guarantee that the output will have the same type as the output
		 * . Parameter : for Stream<T> (a stream of type "T"), map takes Function<T,R> as a parameter (a map function where "T" is the 
		 * 				 input type and "R" is the output type) and returns Stream<R> (a stream of type "R") 
		 */
		//Eg :
		//.map(x-> x * 2) //input type is "Integer" and output type is "Integer"
		//.map(x-> x * 2.0) //input type is "Integer" but output type is "Double" 
		
		
		/**
		 * !!!!!!
		 * Swinlane approach : Both map & filter stay within their "Swimlane", (they mind their own business),
		 * 					   receive values then do what it have to do then pass the values to the next operation ..
		 *                     !! So, they don't look neither left or right into other operations  
		 * !!!!!!                     
		 */
		
		/**
		 * C- Reduce :
		 * . Production function : perform an operation
		 * . Crosses the Swimlane, not like Filter & Map
		 * . The result of each reduce operation becomes the feedback of the next reduce operation and so on 
		 * . Parameter : for Stream<T> (a stream of type "T"), reduce takes two parameters, the 1st parameter of type "T" 
		 *               the 2nd is of type "BiFunction<R,T,R>" to produce a result of "R" 
		 *               (1st "R" is the input type, 2nd "R" is the output type)    
		 */
		//Eg : 
		//.reduce(0.0,(carry,e) -> carry + e)
		//System.out.println(lst.stream().reduce(2,(a,b) -> a+b).intValue()); //57
		
		
		/**
		 * D- Specialized Reduces :
		 */
				
				/**
				 * D-1 SUM  
				 * .Sum the stream elements (n0 + n1 + n2 + N3 + ... etc)
				 */
				//Eg :
				//System.out.println(lst.stream().mapToDouble(e -> e*1.0).sum());
		
				/**
				 * D-2 COLLECT
				 * . Is a reduce operation
				 * . Collect elements after map ..etc
				 * (+) Effective solution for shared mutability 
				 */
				//Eg : Bad way -> shared mutability
				List<Integer> numbers=Arrays.asList(1,2,3,4,5,1,2,3,4,5);
				List<Integer> evenNumbers1 = new ArrayList<>();
				numbers.stream().filter(e -> e % 2 == 0).map(e -> e*2).forEach(e->evenNumbers1.add(e)); // !bad way to do => shared mutability 
					/**
					 * a- toList : 
					 * . Create a list
					 * . Support duplicates
					 */
							//Eg : Good way 
							List<Integer> evenNumbers2 = new ArrayList<>(); 
							evenNumbers2 = numbers.stream().filter(e -> e % 2 == 0).map(e -> e*2).collect(Collectors.toList()); //duplicates : OK 
							System.out.println(evenNumbers2); //4,8,4,8
					/**
					 * b- toSet :
					 * . Create a set
					 * . Doesn't support duplicates, any duplication is removed 		
					 */
							Set<Integer> evenNumbers3 = new HashSet<Integer>();
							evenNumbers3 = numbers.stream().filter(e -> e % 2 == 0).map(e -> e*2).collect(Collectors.toSet());	//duplicates : No ! 
							System.out.println(evenNumbers3); //4,8
							
					/**
					 * c- toMap	:
					 * . Create a map (key,value)
					 */		//Eg : 
							//create a map with name & age as keys and the employee object as value
							List<Employee> employees = Employee.createEmployees();
							System.out.println(
									employees.stream().collect(Collectors.toMap(emp -> emp.getName()+"-"+emp.getAge(), emp->emp))
									);
							
					/**
					 * d- groupingBy :
					 * 	. Create a map (key, value)	: grouped by key
					 */
							//Eg :  
							//create a map where name is the key and value all the employees with that name
							System.out.println(
									employees.stream().collect(Collectors.groupingBy(emp-> emp.getName()))
							);
							//or simplified
							System.out.println(
									employees.stream().collect(Collectors.groupingBy(Employee::getName))
							);
							//Eg : create a map where name is the key and value is all the ages of people with that name
							System.out.println(
									employees.stream().collect(
											Collectors.groupingBy(Employee::getName,
																	Collectors.mapping(Employee::getAge,Collectors.toList())))
							);
	}
	
	

}
