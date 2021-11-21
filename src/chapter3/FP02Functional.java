package chapter3;

import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		
	List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
		
		int sum = addListFunctional(numbers);
		
		System.out.println(sum);

	}
	
	private static int sum(int a, int b) {
		System.out.println(a+" "+b);
		return a+b;
	}

	private static int addListFunctional(List<Integer> numbers) {
		return numbers.stream()
		 // .reduce(0, FP02Functional::sum);
		//	.reduce(0, (x,y) -> x+y);
			.reduce(0, Integer::sum);
		
	}
	

	
	
	
}
