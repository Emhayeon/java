package guessnum2;

import java.sql.Date;

public class ScoreVo {
	private Integer scoreId;
	private String userId;
	private Integer score;
	private Date regdate;

	public ScoreVo() {
		super();
	}

	public ScoreVo(String userId, Integer score) {
		super();
		this.userId = userId;
		this.score = score;
	}

	public ScoreVo(Integer scoreId, String userId, Integer score, Date regdate) {
		super();
		this.scoreId = scoreId;
		this.userId = userId;
		this.score = score;
		this.regdate = regdate;
	}

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ScoreVo [scoreId=" + scoreId + ", userId=" + userId + ", score=" + score + ", regdate=" + regdate + "]";
	}

}