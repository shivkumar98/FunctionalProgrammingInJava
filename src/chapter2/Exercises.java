package chapter2;

import java.util.List;

public class Exercises {
	
	public static void printOddNumbersFromList(List<Integer> numbers) {
		numbers.stream()
		.filter(e -> e%2==0)
		.forEach(System.out::println);
	}
	
	private static void printEachCourse(List<String> courses) {
		courses.stream()
		.forEach(System.out::println);
		
	}
	
	private static void printEachCourseContainingSpring(List<String> courses) {
		courses.stream()
		.filter(e -> e.contains("Spring")||e.contains("spring"))
		.forEach(System.out::println);
		
	}

	private static void printEachCourseWithAtLeast4(List<String> courses) {
		courses.stream()
		.filter(e -> e.length()>3)
		.forEach(System.out::println);
		
	}

	
	public static void main(String[] args) {
		//Ex 1 print only odd numbers
		printOddNumbersFromList(List.of(1,2,3,4,5,6,7,8));
		
		//Ex 2 print these courses individually
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure","Docker", "Kubernetes");
		
		printEachCourse(courses);
		
		// Ex 3 print courses containing the word spring
		System.out.println("yo");
		printEachCourseContainingSpring(courses);
		
		// Ex 4 print courses with atleast 4 letters
		printEachCourseWithAtLeast4(courses);
	}


	

	
	
}
