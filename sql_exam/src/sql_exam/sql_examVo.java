package sql_exam;

public class sql_examVo {
	private String studentid;
	private String name;
	private int grade;
	private String gender;
	private int major;
	private int score;
	
	public sql_examVo() {
		super();
	}

	public sql_examVo(String studentid, String name, int grade, String gender, int major, int score) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.grade = grade;
		this.gender = gender;
		this.major = major;
		this.score = score;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "sql_examVo [studentid=" + studentid + ", name=" + name + ", grade=" + grade + ", gender=" + gender
				+ ", major=" + major + ", score=" + score + "]";
	}
	
	

	
	
	
	
}
