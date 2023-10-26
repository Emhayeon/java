package ex03;

public class Student extends Person{
	private String grade;
	private String department;//기본적으로 있어야함
	
	
	public Student() {
		super();
		
	}//반드시있어야함

	public Student(String grade, String department) {
		super();
		this.grade = grade;
		this.department = department;
	}//옵션

	public String getGrade() {
		return grade;
	}
	

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", department=" + department + "]";
	}
	
	
}
