package chapter4;

import java.util.List;
import java.util.function.Predicate;

public class FP03BehaviourParameterisation {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,4,7,4,9,12,43);
		Predicate<Integer> EvenPred = x -> x%2==0;
		Predicate<Integer> OddPred = x -> x%2==1;
		
		System.out.println("The numbers in my list are:");
		numbers.stream().forEach(System.out::println);
		
		System.out.println("The even numbers in my list are:");
		//getting even numbers
		fileAndPrint(numbers, EvenPred);
		
		System.out.println("The odd numbers in my list are:");
		//getting odd numbers
		fileAndPrint(numbers, OddPred);
		
		System.out.println("The numbers which are multiples of 3 in my list are");
		fileAndPrint(numbers, x -> x%3==0);
	}

	private static void fileAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream()
				.filter(predicate)
				.forEach(System.out::println);
	}
}
