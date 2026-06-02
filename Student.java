package project1;

import java.util.Scanner;

public class Student {
	private int id;
	private String studentName;
	private String major;
	private int NumberCourses = 0;
	private Scanner scanner;
	private Course[] courses = new Course[10];
	//=======================Constructor
	public Student(int id,String studentName,String major) {
		this.id = id;
		this.studentName = studentName;
		this.major = major;
	}
	//add a new course
	public void addCourse() {
		scanner = new Scanner(System.in);
		
		 {
			
		}
		if(NumberCourses >= 10) {
			System.out.println("===> Max number of courses <===");
			return;
		}
		
		System.out.println("enter course code >>>>");
		int code = scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter course name >>>>");
		String name = scanner.nextLine();
		int grade,units;
		// checking inputs
		do {
			System.out.println("enter course units >>>>");
			units = scanner.nextInt();
			System.out.println("enter student grade >>>>");
			grade = scanner.nextInt();
		}while(grade < 0 || grade > 20 || units <= 0);
		
		courses[NumberCourses]= new Course( code, units, name,grade);
			NumberCourses++;
	}
	
	public void addCourse(int code, int units, String name, int grade) {
	
			courses[NumberCourses]= new Course( code, units, name,grade);
			NumberCourses++;
	}
	
	public float calculateGPA() {
		int sum = 0;
		int unitSum = 0;
		for(int i=0;i < NumberCourses;i++) {
			sum += courses[i].Units()*courses[i].Grade();
			unitSum += courses[i].Units();
		}
		float GPA = (float)sum/unitSum;
		return GPA;
	}
	//=======================getter 
	public int getID() {
		return id;
	}
	public String getName() {
		return studentName;
	}
	
	public void getGaradeReport() {
		System.out.println(studentName+"     id:"+id+"     major:"+major);
		for(int i=0;i < NumberCourses;i++) {
			System.out.println("==========course "+(i+1)+"==========");
			courses[i].displayCourseInfo();
			System.out.println("grade in char: "+courses[i].gradeINchar());
		}
	}
	
}
