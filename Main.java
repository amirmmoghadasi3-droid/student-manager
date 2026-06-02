package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Student> student;
		student = new ArrayList<>();
		
		boolean running = true;
		int id = 2;
		int sum = 0;
		String studentName,major;
		//for testing
		student.add(new Student(1,"ali","math"));
		student.get(0).addCourse(1,4,"math1",16);
		
		while(running) {
			System.out.println("==========start menu==========");
			System.out.println("1.add a new student");
			System.out.println("2.add a new corse for a student(base on student id)");
			System.out.println("3.display student info (base on student id)");
			System.out.println("4.display all students info");
			System.out.println("5.search (base on student id)");
			System.out.println("6.calss average");
			System.out.println("7.exit");
			System.out.println("==============================");
			System.out.println("input >>");
			
			int input = scanner.nextInt();
			scanner.nextLine();
			switch(input) {
				//==============add student
				case 1:
					System.out.println("enter student name >>>");
					studentName = scanner.nextLine();
					System.out.println("enter student major >>>");
					major = scanner.nextLine();
					student.add(new Student(id,studentName,major));
					System.out.println("student needs atleast one course (max 10)");
					student.get(id-1).addCourse();
					id++;
					break;
				//===============add course	
				case 2:
					System.out.println("enter student ID >>>");
					int input1 = scanner.nextInt();
					if(findStudent(input1,student))
						student.get(input1 - 1).addCourse();
					break;
				//===============student info	
				case 3:
					System.out.println("enter student ID >>>");
					int input2 = scanner.nextInt();
					if(findStudent(input2,student)) {
						System.out.println("===============student info=================");
						student.get(input2 - 1).getGaradeReport();
						System.out.print("GPA: "+student.get(input2 - 1).calculateGPA()+"       ");
						if(student.get(input2 - 1).calculateGPA() >= 16)
							System.out.println("[PASSS]");
						else
							System.out.println("[FAILED]");
						System.out.println("============================================");
					}break;
				//===============all students info
				case 4:
					System.out.println("===============students info=================");
					for(int i = 0;i < student.size();i++) {
						student.get(i).getGaradeReport();
						System.out.print("GPA: "+student.get(i).calculateGPA()+"       ");
						if(student.get(i).calculateGPA() >= 16)
							System.out.println("[PASSS]");
						else
							System.out.println("[FAILED]");
						System.out.println("============================================");
					}break;
				//==============search	
				case 5:
					System.out.println("enter student ID >>>");
					int input3 = scanner.nextInt();
					if(findStudent(input3,student)) {
						System.out.println("[FOUND] "+student.get(input3 - 1).getName()+" ID:"+student.get(input3 - 1).getID());
						System.out.print("GPA: "+student.get(input3 - 1).calculateGPA()+"  ");
						if(student.get(input3 - 1).calculateGPA() >= 16)
							System.out.println("[PASSS]");
						else
							System.out.println("[FAILED]");
					}break;
				//================class average	
				case 6:
					for(int i = 0;i < student.size();i++) 
						sum += student.get(i).calculateGPA();
					System.out.println("class average: "+sum/student.size());
					break;
				//================exit	
				case 7:
					running = false;break;
				default:System.out.println("ERROR");break;	
			}
			
		}
		scanner.close();
	}
	

	static boolean findStudent(int id, ArrayList<Student> student) {
		for(int i = 0;i < student.size();i++)
			if(id == student.get(i).getID())
				return true;
		
		System.out.println("no student with this ID were found!!");
		return false;
	}

}
