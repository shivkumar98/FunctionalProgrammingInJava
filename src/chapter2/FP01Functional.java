package chapter2;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		
		printAllNumbersInListStructured(List.of(12,13,2,5));
		printEvenNumbersInListStructured(List.of(12,3,5,6));
		printEvenNumbersUsingLambdas(List.of(12,3,5,6));
		printSquaresOfEvenNumbers(List.of(23,45,656,777));
		System.out.println("cubes of odd numbers");
		printCubeOfOddNumbers(List.of(1,23,5,6,8));

	}
	
	private static void printCubeOfOddNumbers(List<Integer> numbers) {
		numbers.stream()
		.filter(n -> n%2==1)
		.map(n -> n*n*n)
		.forEach(System.out::println);
		
	}

	private static void printSquaresOfEvenNumbers(List<Integer> numbers) {
		numbers.stream().
		filter(n -> n%2==0)
		.map(n -> n*n)
		.forEach(System.out::println);
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
