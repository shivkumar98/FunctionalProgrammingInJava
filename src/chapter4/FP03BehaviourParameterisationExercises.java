package chapter4;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03BehaviourParameterisationExercises {
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,2,3,4,5,65,7,8,8);
		
		// Ex 1
		/*
		 * Do behavior parameterisation on the following
		 * List<Integer> squaredNums = numbers.stream().map( x -> x*x).collect(Collectors.toList())
		 */
		

		Function<? super Integer, ? extends Integer> mappingFunction = x -> x*x;
		List<Integer> squaredNums = mapAndCreateList(numbers, mappingFunction);
		
		// returning cubes
		List<Integer> cubedNumber = mapAndCreateList(numbers, x -> x*x*x);
		
		// returning doubled numbers
		List<Integer> doubledNumbers = mapAndCreateList(numbers, x -> 2*x);
		
		System.out.println(doubledNumbers);
		
		

	}

	private static List<Integer> mapAndCreateList(List<Integer> numbers,
			Function<? super Integer, ? extends Integer> mappingFunction) {
		return numbers.stream().map( mappingFunction ).collect(Collectors.toList());
	}
	

}
