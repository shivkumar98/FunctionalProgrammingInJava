package chapter4;

import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;



public class FP03FunctionalInterfaces {
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,23,4,5,6,7823,3,5,2);
		
		Predicate<Integer> isEven = x->x%2==0;
		Function<Integer, Integer> squareFunction = x-> x*x;
		Consumer<Integer> display= x-> System.out.println(x);
		BinaryOperator<Integer> sumBinaryOperator = (x,y)->x+y;
		
		//Suppliers have no input but have an output
		
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		
		System.out.println( randomIntegerSupplier.get());
		
		//unary operator takes one input and returns the same type as output;
		UnaryOperator<Integer> timesThree = x->3*x;
		
		System.out.println(timesThree.apply(3));
		
	}
	

}
