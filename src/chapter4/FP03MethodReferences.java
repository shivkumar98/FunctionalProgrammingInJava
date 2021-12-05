package chapter4;

import java.util.List;

public class FP03MethodReferences {
	
		@SuppressWarnings("unused")
		private static void print(String str) {
			System.out.println(str);
		}
	
		public static void main(String[] args) {
			//Method references
			
			
			List<String> course = List.of("Spring", "Spring Boot", "API");
			
			course.stream()
				//.map(str -> str.toUpperCase())
				.map(String::toUpperCase)
				.forEach(FP03MethodReferences::print);
		}
			
	
}
