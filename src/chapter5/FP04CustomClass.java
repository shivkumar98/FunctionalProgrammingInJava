package chapter5;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Course{
	private String name;
	private String Category;
	private int reviewScore;
	private int noOfStudents;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		Category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	
	public String toString() {
		return name +":"+noOfStudents+":"+reviewScore;
	}
}

public class FP04CustomClass {
	
	public static void main(String[] args) {
		List<Course> courses =
		List.of(
				new Course("Spring","Framework", 98, 20000),
				new Course("Spring Boot","Framework", 98, 26000),
				new Course("Docker","Cloud", 77, 27000),
				new Course("Kubernetes","Cloud", 98, 27000),
				new Course("Full Stack","FullStack", 88, 19000)
				);
		
		//allMatch, anyMatch noneMatch

		Predicate<? super Course> ScoreAbove90predicate = course -> course.getReviewScore()>90;
		boolean coursesWithScoreAbove90 = courses.stream().allMatch(ScoreAbove90predicate);
		System.out.println("Do all the courses have a score above 90?");
		System.out.println(coursesWithScoreAbove90 );
		
		boolean AreAnyCoursesScoreAbove90 = courses.stream().anyMatch(ScoreAbove90predicate);
		System.out.println("Do any courses have a score above 90??");
		System.out.println(AreAnyCoursesScoreAbove90);
		
		boolean NoCoursesHaveReviewScoreAbove90 = courses.stream().noneMatch(ScoreAbove90predicate);
		System.out.println("None of the courses have a score above 90?");
		System.out.println(NoCoursesHaveReviewScoreAbove90);
		
		Comparator<Course> comparingByNumberOfStudents = Comparator.comparingInt (Course::getNoOfStudents).reversed();
		
		System.out.println(courses.stream().sorted(comparingByNumberOfStudents).collect(Collectors.toList()));
		
		Comparator<Course> comparingByNumberOfStudentsAndReviews =
				Comparator.comparingInt(Course::getNoOfStudents)
					.thenComparingInt(Course::getReviewScore).reversed();
		
		System.out.println(courses.stream().sorted(comparingByNumberOfStudentsAndReviews).collect(Collectors.toList()));
		
		//Skip , Limit, takeWhile, dropWhile

		System.out.println(courses.stream().sorted(comparingByNumberOfStudentsAndReviews).limit(2).collect(Collectors.toList()));
		
		System.out.println(courses.stream().sorted(comparingByNumberOfStudentsAndReviews).skip(2).limit(2).collect(Collectors.toList()));
		
		System.out.println( courses.stream().takeWhile(course -> course.getReviewScore()>=95)
				.collect(Collectors.toList()));
		
		//max min
		
		System.out.println("The course with the max ");
		System.out.println( courses.stream().max(comparingByNumberOfStudentsAndReviews));
		//max returns the last elememt
		
		System.out.println("The course with min: ");
		System.out.println(courses.stream().min(comparingByNumberOfStudentsAndReviews));
				
		System.out.println("filter!");
		System.out.println(
			courses.stream()
				.filter(c -> c.getReviewScore()>100)
				.min(comparingByNumberOfStudentsAndReviews)
				.orElse(new Course("shiv sucks","sucks",123, 1))
				);
		
		System.out.println("find first");
		courses.stream().forEach(System.out::print);
		System.out.println(
			
			courses.stream().filter(c -> c.getReviewScore()<95).findFirst()
		);
		
		System.out.println("find any");
		System.out.println(
				
				courses.stream().filter(c -> c.getReviewScore()>70).findAny()
			);
		//find any is non deterministic
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		// sum, average, count
		
		System.out.println(
		courses.stream().filter(c -> c.getReviewScore()>90).mapToInt(c -> c.getNoOfStudents()).sum()
				);
		System.out.println(
				courses.stream().mapToInt(c -> c.getNoOfStudents()).average()
				);
		System.out.println(
				courses.stream().mapToInt(c -> c.getNoOfStudents()).count()
				);
		System.out.println(
				courses.stream().mapToInt(c -> c.getNoOfStudents()).min()
				);
		System.out.println(
				courses.stream().mapToInt(c -> c.getNoOfStudents()).max()
				);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//group by
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory)
						)
				);
		
		//count the course
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())
						)
				);
				
		
		//returning highest reviewed course per category
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
				);
		
		//mapping name of course
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())))
				
				);
		
			
					
	}
}
