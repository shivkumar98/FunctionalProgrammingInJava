package chapter2;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		
		printAllNumbersInListStructured(List.of(12,13,2,5));
		printEvenNumbersInListStructured(List.of(12,3,5,6));
		printEvenNumbersUsingLambdas(List.of(12,3,5,6));

	}
	
	private static void printEvenNumbersUsingLambdas(List<Integer> numbers) {
		numbers.stream()
		.filter(n -> n%2==0)
		.forEach(System.out::println);
	}

	public static boolean isEven(int num)
	{
		return num%2==0;
	}

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		numbers.stream()
		.filter(FP01Functional::isEven)
		.forEach(System.out::println);
	}



	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		// using a functional approach
		//convert list to stream
		numbers.stream().forEach(System.out::println);
	}
	
	
	
}
