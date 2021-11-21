package chapter3;

import java.util.List;

public class FP02Structured {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
		
		int sum = addListStructured(numbers);
		
		System.out.println(sum);
		
	

	}

	
	private static int addListStructured(List<Integer> numbers) {
		int sum = 0;
		for (int num:numbers) {
			sum+=num;
		}
		return sum;
	}

	
	

}
