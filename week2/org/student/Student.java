package org.student;

import org.department.Department;

public class Student extends Department
{
	public void studentName() 
	{
		System.out.println("student name Pavithra");
	}
	
	public void studentDept() 
	{
		System.out.println("Student Department EIE");
	}
	
	public void studentId() 
	{
		System.out.println("Student ID 1234");
	}
	
	public static void main(String[] args)
	{
		Student obj = new Student();
		obj.collegeCode();
		obj.collegeName();
		obj.collegeRank();
		obj.deptName();
		obj.studentName();
		obj.studentDept();
		obj.studentId();
		
	}
}


//multi level inheritance