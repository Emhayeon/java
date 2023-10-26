package ex03;

public class PersonMain {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동", "hong");
		System.out.println(p1);
		System.out.println(p1.toString());//자동으로 호출됨
		
		Person p2 = new Student("1","회계");//up-casting
		// p2.getGrade(); //error
		//Student s1 = (Student)p2; //down-casting
		//s1.getGrade();//o
		
		System.out.println(p2 instanceof Student);
		if(p2 instanceof Student) {
			Student s1 =(Student)p2;
			System.out.println(s1.getGrade());
			System.out.println(s1.getDepartment());
		}
	}

}
