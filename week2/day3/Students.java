package week2.day3;

public class Students 
{
	public void getStudentInfo(int id)
	{
		System.out.println("Student Id: " +id);
	}
	
	public void getStudentInfo(int id,String name)
	{
		System.out.println("Student Id: " +id);
		System.out.println("Student Name: "+name);
	}
	
	public void getStudentInfo(String email,String phonenumber)
	{
		System.out.println("email: " +email);
		System.out.println("Phonenumber: "+phonenumber);
	}

	public static void main(String[] args) 
	{
		Students obj = new Students();
		obj.getStudentInfo(101);
		obj.getStudentInfo(101, "Pavithra");
		obj.getStudentInfo("abc@gmail.com", "6380812361");
	}
}

