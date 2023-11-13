package guessnum2;

public class ScoreUserVo {
	private String user_id;
	private String user_name;
	private String score;
	private String regdate;
	private String grade;
	
	public ScoreUserVo() {}

	public String getUserId() {
		return user_id;
	}

	public void setUserId(String userId) {
		this.user_id = userId;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String userName) {
		this.user_name = userName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public ScoreUserVo(String userId, String userName, String score, String regdate, String grade) {
		super();
		this.user_id = userId;
		this.user_name = userName;
		this.score = score;
		this.regdate = regdate;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "ScoreUserVo [userId=" + user_id + ", userName=" + user_name + ", score=" + score + ", regdate=" + regdate
				+ ", grade=" + grade + "]";
	}
	
	
}
