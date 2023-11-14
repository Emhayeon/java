package guessnum2;

import java.sql.Date;

public class ScoreUserVo {
	private String userId;
	private String userName;
	private int score;
	private Date regdate;
	private String grade;

	public ScoreUserVo() {
		super();
	}

	public ScoreUserVo(String userId, String userName, int score, Date regdate, String grade) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.score = score;
		this.regdate = regdate;
		this.grade = grade;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "ScoreUserVo [userId=" + userId + ", userName=" + userName + ", score=" + score + ", regdate=" + regdate
				+ ", grade=" + grade + "]";
	}

}