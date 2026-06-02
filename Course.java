package project1;

public class Course {
	private int code;
	private String name;
	private int units;
	private int grade;
	
	//=======================Constructor
	public Course(int code,int units,String name,int grade) {
		this.code = code;
		this.units = units;
		this.name = name;
		this.grade = grade;
	}
	
	//========================getter and display
	public int Grade() {
		return grade;
	}
	public int Units() {
		return units;
	}
	
	public void displayCourseInfo() {
		System.out.println("code: "+code+" name: "+name);
		System.out.println("units: "+units+" grade: "+grade);
	}
	//========================turn grade into (A-F)
	//for simplicity i used 5 char
	public char gradeINchar() {
		switch(grade/5) {
			case 4 : return 'A';
			case 3 : return 'B';
			case 2 : return 'C';
			case 1 : return 'D';
			case 0 : return 'F';
			//for any possible ERROR
			default: return 'E';
			
		}
	}

}
