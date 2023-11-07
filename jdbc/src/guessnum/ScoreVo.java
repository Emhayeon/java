package guessnum;

public class ScoreVo {
	private String username;
	private Integer score;
	
	public ScoreVo() {
		super();
		
	}
	public ScoreVo(String username, Integer score) {
		super();
		this.username = username;
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	
	@Override
	public String toString() {
		return "ScoreVo [username=" + username + ", score=" + score + "]";
	}
	
	
	
	
}
