package chapter11;

import chapter08.Student;

public class JavaAPIExample {
	public static void main(String[] args) {
		
		//1. 
		Class.forName("chapter08.student");
		//2.
		Student student = new Student("", 0);
		Class class1 = student.getClass();
		//3.
		Student.class;
		

	}
}
