package chapter2;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		
		printAllNumbersInListStructured(List.of(12,13,2,5));
		printEvenNumbersInListStructured(List.of(12,3,5,6));
		
	

	}

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		for (int i:numbers) {
			if (i%2==0) {
				System.out.println(i);
			}
		}
		
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		for (int number: numbers) {
			System.out.println(number);
		}
	}
	
	

}
