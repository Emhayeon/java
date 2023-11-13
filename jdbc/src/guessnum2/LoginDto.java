package guessnum2;

public class LoginDto {
	private String userId;
	private String userPw;
	
	
	public LoginDto() {
		super();
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		return "LoginDto [userId=" + userId + ", userPw=" + userPw + "]";
	}

	public LoginDto(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}
	
	
	
	
	

	
	

	
	
}
